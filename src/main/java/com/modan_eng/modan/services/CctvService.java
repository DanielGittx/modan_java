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

import java.util.ArrayList;
import java.util.List;
//import java.awt.image.BufferedImage;
import java.io.File;


import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazonaws.services.s3.model.PartETag;
import com.amazonaws.services.s3.model.UploadPartRequest;


//import javax.imageio.ImageIO;
//import com.github.sarxos.webcam.Webcam;
//import com.github.sarxos.webcam.WebcamDriverUtils;
//import com.xuggle.mediatool.IMediaWriter; 
//import com.xuggle.mediatool.ToolFactory; 
//import com.xuggle.xuggler.ICodec; 
//import com.xuggle.xuggler.IPixelFormat; 
//import com.xuggle.xuggler.IVideoPicture; 
//import com.xuggle.xuggler.video.ConverterFactory; 
//import com.xuggle.xuggler.video.IConverter;

//import com.googlecode.javacv.OpenCVFrameGrabber;
//import com.googlecode.javacv.cpp.opencv_core.IplImage;
//import static com.googlecode.javacv.cpp.opencv_highgui.*;
//import org.bytedeco.javacv.*;
//
//import static org.bytedeco.javacpp.opencv_core.IplImage;
//import static org.bytedeco.javacpp.opencv_core.cvFlip;
//import static org.bytedeco.javacpp.opencv_imgcodecs.cvSaveImage;

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
        File folder = new File("C:/Users/danial/Documents/NetBeansProjects/Image_Processing_dll/ModamEngine/records");
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
        File File_system_video_directory = new File("C:/Users/danial/Documents/NetBeansProjects/Image_Processing_dll/ModamEngine/records");
        //File File_system_video_directory = new File("C:/Users/danial/Downloads");
        long capacityOfFolder =0;
            for (File file : File_system_video_directory.listFiles()) {
        if (file.isFile())
            capacityOfFolder += file.length();
        else
            capacityOfFolder += getCapacityOfContentFolder();
    }
          //return capacityOfFolder/1073741824;     //This is how big File_system_video folder is (GB)
          return capacityOfFolder;          //Bytes
    }
    
    public static void UploadObjectMPULowLevelAPI() //throws IOException
    { 
        String existingBucketName  = "modanengine"; 
        String keyName             = "AKIAJAVRYGK3XEOZV72A";
        String filePath            = "C:/Users/danial/Documents/NEHEMIAH/opencv_libs.txt";   
        
//        AmazonS3Client s3Client = new AmazonS3Client(new ProfileCredentialsProvider());      
          AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                       .withRegion(Regions.US_EAST_1)
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
