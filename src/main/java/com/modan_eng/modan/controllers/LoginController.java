/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modan_eng.modan.controllers;

/**
 *
 * @author danial
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.Random;

@Controller
public class LoginController {
    
     @RequestMapping("/login")  
   public ModelAndView login(HttpServletRequest request,
		   HttpServletResponse response) {
	  String userName=request.getParameter("userName");  
      String password=request.getParameter("password");
      String message;
      int revenue;
      int min = 0, max = 900;
      Random rndm = new Random();
      revenue = min + rndm.nextInt(max);                //TODO: Use AJAX for realtime streaming
      if(userName != null && 
    		  !userName.equals("") 
    		  && userName.equals("daniel") && 
    		  password != null && 
    		  !password.equals("") && 
    		  password.equals("maureen")){
    	  //message = "Welcome " +userName + ".";
          return new ModelAndView("welcome", "message", revenue);
       
 
      }else{
    	  message = "Wrong username or password.";
    	  return new ModelAndView("errorPage", 
    			  "message", message);
      }
   }
    
}



