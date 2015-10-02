<%-- 
    Document   : Registration
    Created on : Sep 9, 2015, 11:37:49 AM
    Author     : Olivier Liechti (olivier.liechti@heig-vd.ch)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <base href="${pageContext.request.contextPath}/">

    <title>Registration Page</title>

    <!-- Bootstrap core CSS -->
    <link href="static/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="static/css/signin.css" rel="stylesheet">

    <!-- for alignment of blocks  -->
    <link href="static/css/alignement.css" rel="stylesheet">
  </head>

   <body class="my_background">
    <div ng-app="sample" class = label>
     <form class="form-horizontal" name="registerForm">
     <div class="form-group">
        <label class="col-md-3 control-label" for="Email">Email</label>
        <div class="col-md-4">
            <input id="Email" type="email" class="form-control" name="Email" ng-model="Email" />
        </div>
     </div>
     <div class="form-group">
        <label class="col-md-3 control-label" for="First name">First name</label>
        <div class="col-md-4">
            <input id="Email" type="First name" class="form-control" name="First name" ng-model="First name" />
        </div>
     </div>
      <div class="form-group">
        <label class="col-md-3 control-label" for="Last name">Last name</label>
        <div class="col-md-4">
          <input id="Email" type="Last name" class="form-control" name="Last name" ng-model="Last name" />
        </div>
     </div>
     <div class="form-group">
        <label class="col-md-3 control-label" for="Password">Password</label>
        <div class="col-md-4">
            <input id="Password" type="password" class="form-control" name="Password" ng-model="Password" />
        </div> 
     </div>
     <div class="form-group">
        <label class="col-md-3 control-label" for="ConfirmPassword">Confirm Password</label>
        <div class="col-md-4">
            <input id="ConfirmPassword" type="password" class="form-control" name="ConfirmPassword" ng-model="ConfirmPassword" />
        </div>
     </div>
     <div class="form-group">
        <div class="col-md-offset-3 col-md-9">
            <input type="submit" class="btn btn-default" value="Sign Up" />
        </div>
     </div>
     </form>
  </div>
</body>
</html>

