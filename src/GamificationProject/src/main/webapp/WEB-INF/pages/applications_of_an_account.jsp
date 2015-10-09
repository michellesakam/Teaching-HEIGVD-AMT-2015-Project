<%-- 
    Document   : Registration
    Created on : Sept 9, 2015, 11:37:49 AM
    Author     : michelle meguep
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>


<html>
 <head>
       <%@include file="includes/header.jsp" %>
       <%@include file="includes/login.jsp" %>
            <style>
            .butt
            {
            border:1px solid black;
            height:30px;
            width:100px;
            margin-top:8px;
            background-color:green;
            margin-bottom:8px;
            }
            .background
            {
                background-color:red;
                
            }
           </style>
           
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
        <script type="text/javascript">
            var i = 0;
            var bool = false;
            $(function(){
                $(".butt").click(function(){
                    $(this).toggleClass("background");
                    if(!bool){
                    document.getElementById('enabled').innerHTML = "diseabled";
                        bool = true;
                    }
                    else{
                       document.getElementById('enabled').innerHTML = "enabled";  
                       bool = false;
                    }
                
                });
                 
            });
            function addKid()
            {
                    var newRow = document.createElement('tr');
 
                    newRow.innerHTML = '<td>\n\
                    <input type="text" name="Name'+i+'">\n\
                    <td><input type="text" name="Description'+i+'"></td>\n\
                    <td><input type="text" name="ApiKey'+i+'"></td>\n\\n\
                    <td><input type="text" name="Users'+i+'"></td>\n\
                    <td><input type="button" id="edit"/>\n\
                        <input type="button" id="enabled">\n\
                    </td>';
 
                    document.getElementById('kids').appendChild(newRow);
                    i++;
            }
 
            function removeKid(element)
            {
                document.getElementById('kids').removeChild(element.parentNode);
                i--;
            }
 
        </script>
        
    </head>
    
    <body>
        
        <h1 align = "center">Your apps...</h1>
        <h2 align = "center"><button class="btn btn-primary" type="submit">Register New App</button></h2>
        
          <table border="1" id="kids" align = "center">
            <tr>
                <th>Name</th>
                <th>Description</th>
                <th>ApiKey</th>
                <th>Users</th>
            </tr>
            <tbody  >
                <tr >
                    <td  >
                        <input type="text" name="Name">
                    </td>
                    <td>
                        <input type="text" name="Description">
                    </td>
                    <td>
                        <input type="text" name="ApiKey">
                    </td>
                    <td>
                        <input type="text" name="Users">
                    </td>
                    <td>
                         <button id="edit" class="btn btn-primary" type="submit">edit</button>
                         <button id="enabled" class="butt" type="submit">enabled</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </body>
</html>