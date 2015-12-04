<%-- 
    Document   : index.jsp
    Created on : 29 nov. 2015, 08:49:17
    Author     : Raphaël Racine
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to the Gamification Demo</title>

        <link href="static/css/bootstrap.min.css" rel="stylesheet">
        <script src="static/js/jquery.min.js"></script>
        <script src="static/js/bootstrap.min.js"></script>

        <!--Including script for angular modules-->
        <script src="static/js/Chart.js"></script>
        <script src="static/js/angular.js"></script>
        <script src="static/js/angular-chart.js"></script>
        <script src="static/js/angular-ui-router.js"></script>
        <script src="static/js/gamification_angular_app.js"></script>


    </head>
    <body>
        <div class="container">
            <div ng-app="gamification_app">
                <div ng-controller="MainController">
                    <div ui-view=""></div>       
                </div>
            </div>
        </div>
    </body>
</html>
