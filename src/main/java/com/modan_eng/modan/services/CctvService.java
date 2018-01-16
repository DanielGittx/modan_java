/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modan_eng.modan.services;

/**
 *
 * @author danial
 */
import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazonaws.services.s3.model.PartETag;
import com.amazonaws.services.s3.model.UploadPartRequest;

public class CctvService {
   
    // Get file size 
    public static long getFileSize(String filename) {
      File file = new File(filename);
      if (!file.exists() || !file.isFile()) {
         System.out.println("File doesn\'t exist");
         return -1;
      }
      return file.length();    //Bytes
   }
     // Get number of file(s)/items in content folder
    public static int getNumberOfFilesInFolder()
    {
        File folder = new File("H:/HIGH LEVEL/Projects/Retail Analytics/File_system_video");
        //File folder = new File("C:/Users/danial/Downloads");
        File[] listOfFiles = folder.listFiles(); 

    for (int i = 0; i < listOfFiles.length; i++) {
      if (listOfFiles[i].isFile()) {
        System.out.println("File " + listOfFiles[i].getName());
        //return listOfFiles.length;
      } else if (listOfFiles[i].isDirectory()) {
        System.out.println("Directory " + listOfFiles[i].getName());
        //return listOfFiles.length;
      }
    }
         return listOfFiles.length;
    }
    // Get capacity of content folder
    public static long getCapacityOfContentFolder(){
        File File_system_video_directory = new File("H:/HIGH LEVEL/Projects/Retail Analytics/File_system_video");
        //File File_system_video_directory = new File("C:/Users/danial/Downloads");
        long capacityOfFolder =0;
            for (File file : File_system_video_directory.listFiles()) {
        if (file.isFile())
            capacityOfFolder += file.length();
        else
            capacityOfFolder += getCapacityOfContentFolder();
    }
          return capacityOfFolder/1073741824;     //This is how big File_system_video folder is
    }
    
    public static void UploadObjectMPULowLevelAPI() //throws IOException
    { 
        String existingBucketName  = "modanRetailBucket"; 
        String keyName             = "AKIAJAVRYGK3XEOZV72A";
        String filePath            = "H:/HIGH LEVEL/Projects/Retail Analytics/File_system_video/faithful_.mp3";   
        
//        AmazonS3Client s3Client = new AmazonS3Client(new ProfileCredentialsProvider());      
          AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                       .withRegion(Regions.DEFAULT_REGION)
                       .build();

        // Create a list of UploadPartResponse objects. You get one of these
        // for each part upload.
        List<PartETag> partETags = new ArrayList<PartETag>();

        // Step 1: Initialize.
        InitiateMultipartUploadRequest initRequest = new 
             InitiateMultipartUploadRequest(existingBucketName, keyName);
        InitiateMultipartUploadResult initResponse = 
        	                   s3Client.initiateMultipartUpload(initRequest);

        File file = new File(filePath);
        long contentLength = file.length();
        long partSize = 5242880; // Set part size to 5 MB.

        try {
            // Step 2: Upload parts.
            long filePosition = 0;
            for (int i = 1; filePosition < contentLength; i++) {
                // Last part can be less than 5 MB. Adjust part size.
            	partSize = Math.min(partSize, (contentLength - filePosition));
            	
                // Create request to upload a part.
                UploadPartRequest uploadRequest = new UploadPartRequest()
                    .withBucketName(existingBucketName).withKey(keyName)
                    .withUploadId(initResponse.getUploadId()).withPartNumber(i)
                    .withFileOffset(filePosition)
                    .withFile(file)
                    .withPartSize(partSize);

                // Upload part and add response to our list.
                partETags.add(
                		s3Client.uploadPart(uploadRequest).getPartETag());

                filePosition += partSize;
            }

            // Step 3: Complete.
            CompleteMultipartUploadRequest compRequest = new 
                         CompleteMultipartUploadRequest(
                                    existingBucketName, 
                                    keyName, 
                                    initResponse.getUploadId(), 
                                    partETags);

            s3Client.completeMultipartUpload(compRequest);
            //System.out.println("completed...");
        } catch (Exception e) {
            //System.out.println(e);
            s3Client.abortMultipartUpload(new AbortMultipartUploadRequest(
                    existingBucketName, keyName, initResponse.getUploadId()));
        }
   
        
    }
}
