<%-- 
    Document   : login
    Created on : Sep 9, 2015, 11:37:49 AM
    Author     : Olivier Liechti (olivier.liechti@heig-vd.ch)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html lang="en">
    
    <%@include file="includes/header.jsp" %>
    <%@include file="includes/login.jsp" %>

    <title>Login Page</title>
    
    <body>
        <div align="center">
            <h1>Welcome to GaMy</h1>
            <br>
            <br>
                ${nbAccounts} accounts created
            <br>
                ${nbApplications} applications managed
            <br>
            <br>
                ${nbEndUser} users created by applications during the last ${nbLastDays} days
        </div>
        
        
    </body>
  
</html>

