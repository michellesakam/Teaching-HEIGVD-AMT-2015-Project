<%-- 
    Document   : Registration
    Created on : Sept 9, 2015, 11:37:49 AM
    Author     : michelle meguep
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html lang="en">


    <%@include file="includes/header.jsp"%>

    <body>
        <h1 align="center">Register new app </h1>
        
        <form method="POST" class="form-horizontal" name="registerForm">
            <div class="form-group">
                <label class="col-md-3 control-label" for="Name" required>Name</label>
                <div class="col-md-4">
                    <input id="Name" type="Name" class="form-control" name="Name" required/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label" for="Description">Description</label>
                <div class="col-md-4">
                    <TEXTAREA name="description" rows=4 cols=40 name="Description"></TEXTAREA>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label" for="Key">API Key</label>
                <div class="col-md-4">
                    The ApiKey will be generated after the creation of application
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label" for="Users">Users</label>
                <div class="col-md-4">
                    0
                </div> 
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label" for="State">State</label>
                <div class="col-md-offset-3 col-md-9">
                    <span class="btn-primary" style="background-color: #1B4F08; border-radius: 5px">Created</span>
                </div>
            </div>
            <div class="form-group" >
                <div class="col-md-offset-3 col-md-9">
                    <button class="btn btn-primary" type="submit">Register</button>
                    <button class="btn btn-default" type="button">Cancel</button>
                </div>
            </div>
        </form>
    </body>
</html>

