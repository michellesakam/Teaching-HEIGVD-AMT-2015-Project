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
            <h1>Welcome to the Gamification Demo</h1>
            <p>Type an API Key and an EndUser Number to show some widgets</p>

            <div class="form-horizontal">
                <label>Api Key : </label>
                <input type="text" />

                <label>End User Number : </label>
                <input type="text" />                
                            
                <button class="btn btn-primary">Show Widgets</button>
            </div>
            
        </div>
        
    </body>
</html>
