<%-- 
    Document   : Registration
    Created on : Sept 9, 2015, 11:37:49 AM
    Author     : michelle meguep
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<title>Your Apps</title>
<html>
        <%@include file="includes/header.jsp" %>
        <%@include file="includes/login.jsp" %>


    <body>

        <h1 align = "center">Your apps...</h1>
        <form method="GET" action="pages/applicationRegistration">
            <h2 align = "center"><button id="bregisternewapp" class="btn btn-primary" type="submit">Register New App</button></h2>
        </form>

        <table class="table">
            <tr>
                <th>Name</th>
                <th>Description</th>
                <th>ApiKey</th>
                <th>#End users</th>
                <th></th>
            </tr>
            <c:forEach var="appli" items="${applications}">
                <tr>
                    <td>${appli[0].name}</td>
                    <td>${appli[0].description}</td>
                    <td>${appli[0].apiKey.key}</td>
                    <td>${appli[1]}</td>
                    
                    <td>                        
                        <form method="GET" action="pages/applicationDetails?idApplication=${appli[0].name}">
                            <button id="edit" class="btn">edit</button>
                        </form>                    
                    </td>
                    
                    <td>
                        <!-- voir pour les actions des boutons-->
                        <button id="edit" class="btn">edit</button>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>