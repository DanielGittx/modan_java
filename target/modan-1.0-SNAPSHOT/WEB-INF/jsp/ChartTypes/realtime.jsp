<%-- 
    Document   : index
    Created on : Jan 16, 2018, 1:39:56 PM
    Author     : danial
--%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.google.gson.JsonObject"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE HTML>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title></title>

<link href="<c:url value="/assets/css/font-roboto.css" />" rel="stylesheet">
<link href="<c:url value="/assets/bootstrap/bootstrap4-alpha3.min.css"/>" rel="stylesheet">
<link href="<c:url value="/assets/font-awesome/css/font-awesome.min.css" />" rel="stylesheet">
<link href="<c:url value="/assets/web-analytics/style.css" />" rel="stylesheet">


<!-- scripts -->
<script src="<c:url value="/assets/jquery/jquery-3.1.0.min.js" />" type="text/javascript"></script>
<script src="<c:url value="/assets/tether/tether.min.js" />"	type="text/javascript"></script>
<script src="<c:url value="/assets/script/canvasjs.min.js" />"	type="text/javascript"></script>
<script src="<c:url value="/assets/bootstrap/bootstrap4-alpha3.min.js" />" type="text/javascript"></script>
<script src="<c:url value="/assets/web-analytics/real-time.js" />"type="text/javascript"></script>



</head>

<body> 
    
<div class="container-fluid">

			<!-- 1st row -->
			<div class="row m-b-2">
				<div class="col-lg-4">
					<div class="card card-block">
						<h4 class="card-title">Distribution</h4>
						<div id="users-device-doughnut-chart"></div>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="card card-block">
						<h4 class="card-title">Medium </h4>
						<div id="users-medium-pie-chart"></div>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="card card-block">
						<h4 class="card-title">Categories</h4>
						<div id="users-category-pie-chart"></div>
					</div>
				</div>
			</div>
			<!-- /1st row -->

			<!-- 2nd row -->
			<div class="row">
				<div class="col-lg-6">
					<div class="card card-block">
						<h4 class="card-title m-b-2">Sales Per Minute</h4>
						<div id="page-views-per-minute-column-chart"></div>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="card card-block">
						<h4 class="card-title m-b-2">Sales Per Second</h4>
						<div id="page-views-per-second-column-chart"></div>
					</div>
				</div>
			</div>
			<!-- /2nd row -->

			<!-- 3rd row -->
			<div class="row">
				<div class="col-md-12">
					<div class="card card-block">
						<h4 class="card-title">Performance per Location</h4>
						<div id="users-state-bar-chart"></div>
					</div>
				</div>
			</div>
			<!-- /3rd row -->

		</div>
		<!-- /.container-fluid -->



</body>

</html>