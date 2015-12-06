<%-- 
    Document   : login
    Created on : Sep 19, 2015, 11:37:49 AM
    Author     : michelle meguep
--%>

<%@include file="includes/header.jsp" %>
<%@include file="includes/login.jsp" %>

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
<%@include file="includes/footer.jsp"%>
