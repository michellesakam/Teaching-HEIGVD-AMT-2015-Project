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

        <div class="panel panel-danger" >
            <div class="panel-heading">
                ${notSamePassword}
            </div>
        </div>
        
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
                    <!--<input id="Description" type="Description" class="form-control" name="Description" required/>-->
                    <TEXTAREA name="description" rows=4 cols=40 name="Description"></TEXTAREA>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label" for="Key">API Key</label>
                <div class="col-md-4">
                    ${ApiKey}
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label" for="Users">Users</label>
                <div class="col-md-4">
                    <input id="Password" type="password" class="form-control" name="Password" required/>
                </div> 
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label" for="State">State</label>
                <div class="col-md-offset-3 col-md-9">
                    <button class="btn btn-primary" type="submit" style="background-color: #1B4F08">Created</button>
                </div>
            </div>
            <div class="form-group" >

                        <div class="col-md-offset-3 col-md-9">
                           <button class="btn btn-primary" type="submit">Register</button>
                           <button class="btn btn-primary" type="submit">Cancel</button>
                        </div>
            </div>
        </form>
    </body>
</html>

