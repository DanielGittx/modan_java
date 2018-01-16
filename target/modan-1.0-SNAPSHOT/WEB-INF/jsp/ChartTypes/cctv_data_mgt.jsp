<%-- 
    Document   : cctv_data_mgt
    Created on : Jan 5, 2018, 2:46:14 PM
    Author     : danial
--%>

<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<%@ page import="com.engine.modanengine.services.CctvService" %>--%>

<!DOCTYPE html>
<html>
    <head>
          <title></title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1> </h1>
        <p> The size of this file is:<b> ${filesize}  </b> bytes </p>
        <P> There are <b>${number_of_files_in_folder} </b> items in content folder</P>
        <p> The content folder is <b>${content_folder_capacity}</b> bytes</p>
            
        
        
    </body>
</html>
