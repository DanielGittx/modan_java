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
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import java.util.ArrayList;
import java.util.List;
//import java.awt.image.BufferedImage;
import java.io.File;


import com.amazonaws.regions.Regions;
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
    
    public static void UploadObjectMPULowLevelAPI()  throws IOException
    { 
        String bucketName  = "modanengine"; 
        String keyName     = "AKIAJAVRYGK3XEOZV72A";
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
    
     public void transfer()
     {
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
