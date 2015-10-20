<%-- 
    Document   : Registration
    Created on : Sep 9, 2015, 11:37:49 AM
    Author     : Olivier Liechti (olivier.liechti@heig-vd.ch)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html lang="en">


    <%@include file="includes/header.jsp" %>
    <title>Edit your account details</title>
    <body>
        <h1 align="center">Edit your account details</h1>
        
        <form method="POST" class="form-horizontal" name="registerForm">
            <div class="form-group">
                <label class="col-md-3 control-label" for="Email">Email</label>
                <div class="col-md-4">
                    <label>${principal.email}</label>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label" for="First name">First name</label>
                <div class="col-md-4">
                    <input id="FirstName" type="First name" class="form-control" name="First_name" value="${principal.firstName}" required/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label" for="Last name">Last name</label>
                <div class="col-md-4">
                    <input id="LastName" type="Last name" class="form-control" name="Last_name" value="${principal.lastName}" required/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label" for="Password">Password</label>
                <div class="col-md-4">
                    <input id="Password" type="password" class="form-control" name="Password" required/>
                </div> 
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label" for="ConfirmPassword">Confirm Password</label>
                <div class="col-md-4">
                    <input id="ConfirmPassword" type="password" class="form-control" name="Confirm"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-offset-3 col-md-9">
                    <button id="bSignUp" type="submit" class="btn btn-primary">Confirm</button>
                </div>
            </div>
        </form>
    </body>
</html>

