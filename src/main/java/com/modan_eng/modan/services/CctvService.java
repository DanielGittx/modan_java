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

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import java.util.ArrayList;
import java.util.List;
//import java.awt.image.BufferedImage;
import java.io.File;


import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazonaws.services.s3.model.PartETag;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.Upload;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import java.io.FileOutputStream;

//import com.modan_eng.modan.services.AwsTransferManager;
//import com.amazonaws.services.s3.transfer.Transfer;
//import com.amazonaws.services.s3.transfer.Transfer.TransferState;
//import com.amazonaws.services.s3.transfer.TransferManager;
//import com.amazonaws.services.s3.transfer.TransferProgress;


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
    
    public static void UploadObjectMPULowLevelAPI()  throws IOException     //
    { 
        String bucketName  = ""; 
        String keyName     = "";
        String uploadFileName = "C:/Users/danial/Documents/NEHEMIAH/opencv_libs.txt"; 
   
        AmazonS3 s3client = new AmazonS3Client(new ProfileCredentialsProvider());
        try {
            System.out.println("Uploading a new object to S3 from a file\n");
            File file = new File(uploadFileName);
            s3client.putObject(new PutObjectRequest(
            		                 bucketName, keyName, file));

         } catch (AmazonServiceException ase) {
            System.out.println("Caught an AmazonServiceException, which " +
            		"means your request made it " +
                    "to Amazon S3, but was rejected with an error response" +
                    " for some reason.");
            System.out.println("Error Message:    " + ase.getMessage());
            System.out.println("HTTP Status Code: " + ase.getStatusCode());
            System.out.println("AWS Error Code:   " + ase.getErrorCode());
            System.out.println("Error Type:       " + ase.getErrorType());
            System.out.println("Request ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            System.out.println("Caught an AmazonClientException, which " +
            		"means the client encountered " +
                    "an internal error while trying to " +
                    "communicate with S3, " +
                    "such as not being able to access the network.");
            System.out.println("Error Message: " + ace.getMessage());
        }
   
        
    }
    
     public void transfer() throws IOException              //this method work but needs to be refined : TODO
     {
        System.out.println("Initiating Upload.....");
        
        
        String existingBucketName = "";
        String keyName = "NehemiahSummary.txt";

        String filePath = "C:/Users/danial/Documents/NEHEMIAH/NehemiahSummary.txt";
        String amazonFileUploadLocationOriginal=existingBucketName+"/";
        
        BasicAWSCredentials awsCreds = new BasicAWSCredentials("", "");   //name and secret key
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                        .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                        .withRegion(Regions.US_EAST_2)
                        .build();


       // AmazonS3 s3Client = new AmazonS3Client(new PropertiesCredentials(CctvService.class.getResourceAsStream("AwsCredentials.properties")));

        FileInputStream stream = new FileInputStream(filePath);
        ObjectMetadata objectMetadata = new ObjectMetadata();
        PutObjectRequest putObjectRequest = new PutObjectRequest(amazonFileUploadLocationOriginal, keyName, stream, objectMetadata);
        PutObjectResult result = s3Client.putObject(putObjectRequest);
        System.out.println("Etag:" + result.getETag() + "-->" + result);
        
        System.out.println("Upload Successful...");
         
         
         
         
         /*
         File f = new File("C:/Users/danial/Documents/NEHEMIAH/opencv_libs.txt");
           
           TransferManager xfer_mgr = new TransferManager();
           Upload xfer = xfer_mgr.upload("modanengine", "AKIAJAVRYGK3XEOZV72A", f);
           AwsTransferManager.waitForCompletion(xfer);
 */
 
         /*
            File f = new File("C:/Users/danial/Documents/NEHEMIAH/opencv_libs.txt");
           TransferManager xfer_mgr = new TransferManager();
           try {
               
               System.out.println("Uploading a new object to S3 from local folder.....\n");
               Upload xfer = xfer_mgr.upload("modanengine", "AKIAJAVRYGK3XEOZV72A", f);
               // loop with Transfer.isDone()
               //  or block with Transfer.waitForCompletion()
           } catch (AmazonServiceException e) {
               System.err.println(e.getErrorMessage());
               System.out.println("EXCEPTION:Uploading Unsuccessful  :( \n");
               System.exit(1);
           }
           System.out.println("Uploading Successful\n");
           xfer_mgr.shutdownNow();
          */ 
           
     }
     
     public void download () throws IOException
     {
         String existingBucketName = "<your Bucket>";
  String keyName = "/"+"";
  
       BasicAWSCredentials awsCreds = new BasicAWSCredentials("", "");   //name and secret key
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                        .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                        .withRegion(Regions.US_EAST_2)
                        .build();
  
  GetObjectRequest request = new GetObjectRequest(existingBucketName,
    keyName);
  S3Object object = s3Client.getObject(request);
  S3ObjectInputStream objectContent = object.getObjectContent();
  IOUtils.copy(objectContent, new FileOutputStream("D://upload//test.jpg"));
     }
    
    public static void launch_cctv () throws Exception
    {
       BufferedWriter fileOut;
       String itsFileLocation = "H:/jobs/dll/ModamEngine.exe";
       System.out.println(itsFileLocation);
       Runtime runtime = Runtime.getRuntime();
       try {
        Process process =runtime.exec("H:/jobs/dll/ModamEngine.exe");
       } catch (IOException e) {
        e.printStackTrace();
       }
          
    }
        
   }
