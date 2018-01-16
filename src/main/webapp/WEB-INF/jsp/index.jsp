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
<script src="<c:url value="/assets/web-analytics/overview.js" />"type="text/javascript"></script>

</head>

<body> 

<div class="container-fluid">

			<!-- 1st row -->
			<div class="row m-b-1">
				<div class="col-md-12">
					<div class="card card-block">
						<h4 class="card-title m-b-2">Revenue - 2015 <span class="tag m-l-1" id="revenue-tag">$2,781,450</span></h4>
						<div id="revenue-spline-area-chart"></div>
					</div>
				</div>
			</div>
			<!-- /1st row -->

			<!-- 2nd row -->
			<div class="row m-b-1">
				<div class="col-md-12">
					<div class="card card-block">
						<h4 class="card-title m-b-2">Revenue By Category</h4>
						<span class="tag custom-tag hidden-sm-down">Try clicking on any segment</span>
						<div class="row">
							<div class="col-md-4">
								<div id="annual-revenue-by-category-pie-chart"></div>
							</div>
							<div class="col-md-8 hidden-sm-down">
								<div id="monthly-revenue-by-category-column-chart"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /2nd row -->

			<!-- 3rd row -->
			<div class="row">
				<div class="col-xl-6">
					<div class="card card-block">
						<h4 class="card-title m-b-2">
							<span id="visitors-chart-heading">New vs Returning Visitors </span>
							<button class="btn pull-right invisible" type="button" id="visitors-chart-back-button"><i class="fa fa-angle-left fa-lg" aria-hidden="true"></i> Back</button>
						</h4>
						<span class="tag custom-tag" id="visitors-chart-tag">Try clicking on any segment</span>
						<div id="visitors-chart"></div>
					</div>
				</div>
				<div class="col-xl-6">
					<div class="card card-block">
						<h4 class="card-title m-b-2">Users</h4>
						<div id="users-spline-chart"></div>
					</div>
				</div>
			</div>
			<!-- /3rd row -->

		</div>
		<!-- /.container-fluid -->



<body

</html>