<%-- 
    Document   : login
    Created on : Dec 30, 2017, 8:04:23 PM
    Author     : danial
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />
<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>
<!DOCTYPE html>
<!--<html>
  <head>
    <title>Spring MVC login example.</title>
  </head>
 
  <body>
    <form action="login.html" method="post">  
    UserName:<input type="text" name="userName"/>
    <br/><br/>  
    Password:<input type="password" name="password"/>
    <br/><br/>  
    <input type="submit" value="login"/>  
    </form>  
  </body>
</html>-->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modan Analytica</title>
<!--        <link rel="stylesheet" type="text/css" href="${cp}/resources/css/site.css" />-->
        
        <link href="<c:url value="/assets/css/demo.css" />" rel="stylesheet">
	<link href="<c:url value="/assets/css/form-login.css" />" rel="stylesheet">
        
        
<!--        <script src="${cp}/resources/js/js.js"></script>-->
    </head>
    <body>
      <!--  <h4>Modan Retail Analytics</h4> -->
      <!--  Welcome to Spring: <span class="blue">${msg}</span> -->
      <header>
          <h1> <b> Modan Analytica </b></h1>
       <!-- <a href="http://tutorialzine.com/2015/07/freebie-7-clean-and-responsive-forms/">Download</a> -->
    </header>

    <ul>
<!--        <li><a href="index.html">Basic</a></li>
        <li><a href="form-register.html">Register</a></li>
        <li><a href="form-login.html" class="active">Login</a></li>
        <li><a href="form-mini.html">Mini</a></li>
        <li><a href="form-labels-on-top.html">Labels on Top</a></li>
        <li><a href="form-validation.html">Validation</a></li>
        <li><a href="form-search.html">Search</a></li>-->

        <li> Sales| </li>
        <li> Inventory| </li>
        <li> Customers| </li>
        <li> Suppliers| </li>
        <li> Staff Management| </li>
        <li> Reports| </li>
        <li> Analytics </li>
  

    </ul>


    <div class="main-content">

        <!-- You only need this form and the form-login.css -->
        <form class="form-login" method="post" action="login.html">

            <div class="form-log-in-with-email">

                <div class="form-white-background">

                    <div class="form-title-row">
                        <h1>Log in</h1>
                    </div>
<!--                    <div> ${message} </div>-->
                    <div class="form-row">
                        <label>
                            <span>User Name</span>
                            <input type="text" name="userName">
                        </label>
                    </div>

                    <div class="form-row">
                        <label>
                            <span>Password</span>
                            <input type="password" name="password">
                        </label>
                    </div>

                    <div class="form-row">
                        <button type="submit">Log in</button>
                    </div>

                </div>

                <a href="#" class="form-forgotten-password">Forgotten password &middot;</a>
                <a href="#" class="form-create-an-account">Create an account &rarr;</a>

            </div>

<!--            <div class="form-sign-in-with-social">

                <div class="form-row form-title-row">
                    <span class="form-title">Sign in with</span>
                </div>

                <a href="#" class="form-google-button">Google</a>
                <a href="#" class="form-facebook-button">Facebook</a>
                <a href="#" class="form-twitter-button">Twitter</a>

            </div>-->

        </form>

    </div>     
      
      
    </body>
</html>
