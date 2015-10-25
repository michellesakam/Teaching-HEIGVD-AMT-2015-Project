<%-- 
    Document   : Registration
    Created on : Sep 9, 2015, 11:37:49 AM
    Author     : michelle meguep
--%>

    <%@include file="includes/header.jsp" %>
 
        <h1 align="center">Registration</h1>
        
        <form method="POST" class="form-horizontal" name="registerForm">
            <div class="form-group">
                <label class="col-md-3 control-label" for="Email">Email</label>
                <div class="col-md-4">
                    <input id="Email" type="email" class="form-control" name="Email" value="${accountDTO.email}" required/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label" for="First name">First name</label>
                <div class="col-md-4">
                    <input id="FirstName" type="First name" class="form-control" name="First_name" value="${accountDTO.firstName}" required/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label" for="Last name">Last name</label>
                <div class="col-md-4">
                    <input id="LastName" type="Last name" class="form-control" name="Last_name" value="${accountDTO.lastName}" required/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label" for="Password">Password</label>
                <div class="col-md-4">
                    <input id="Password" type="password" class="form-control" name="Password" value="${accountDTO.password}" required/>
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
                    <button id="bSignUp" type="submit" class="btn btn-primary">Sign up</button>
                </div>
            </div>
        </form>
    <%@include file="includes/footer.jsp"%>
