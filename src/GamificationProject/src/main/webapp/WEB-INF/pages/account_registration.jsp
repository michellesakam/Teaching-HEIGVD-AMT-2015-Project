<%-- 
    Document   : Registration
    Created on : Sep 19, 2015, 11:37:49 AM
    Author     : michelle meguep
--%>

<%@include file="includes/header.jsp" %>

<c:if test="${edit != null}">
    <%@include file="includes/startSideBarWrapper.jsp" %>
</c:if>
<link href="static/css/presentation.css" rel="stylesheet">
<h1 align="center">${title}</h1>

<form method="POST" class="form-horizontal" name="registerForm">

    <input type="hidden" value="${edit != null ? "true" : "false"}" name="edit">

    <div class="form-group">
        <label class="col-md-3 control-label" for="Email">Email</label>
        <div class="col-md-4">

            <c:choose>
                <c:when test="${edit != null}">
                    <label>${principal.email}</label>
                </c:when>
                <c:otherwise>
                    <input id="Email" type="email" class="form-control" name="Email" value="${accountForm.email}" required/>
                </c:otherwise>
            </c:choose>

        </div>
    </div>
    <div class="form-group">
        <label class="col-md-3 control-label" for="First name">First name</label>
        <div class="col-md-4">
            <input id="FirstName" type="First name" class="form-control" name="First_name" value="${accountForm.firstName}" required/>
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-3 control-label" for="Last name">Last name</label>
        <div class="col-md-4">
            <input id="LastName" type="Last name" class="form-control" name="Last_name" value="${accountForm.lastName}" required/>
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-3 control-label" for="Password">Password</label>
        <div class="col-md-4">
            <input id="Password" type="password" class="form-control" name="Password" value="${accountForm.password}" required/>
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
            <a href="pages/yourApps"><button id="bCancel" type="button" class="btn btn-default">Cancel</button></a>
            <button id="bSignUp" type="submit" class="btn btn-primary">Confirm</button>
        </div>
    </div>
</form>
<%@include file="includes/footer.jsp"%>

<c:if test="${edit != null}">
    <%@include file="includes/endSideBarWrapper.jsp" %>
</c:if>
