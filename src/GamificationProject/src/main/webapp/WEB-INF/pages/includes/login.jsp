<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
    <%if (session.getAttribute("principal") != null) { %>

    <form method="POST" action="./auth?action=logout" class="form-signin">
        Logged as ${principal.email}
        <div class="container">            
            <div class ="col-md-3">
                <button class="btn btn-lg btn-primary btn-block" type="submit" style = 'width: 200px; heigth:50px'>Logout</button>
            </div>
        </div>

</div>

<!--fin de l'ajout-->
</form>

<% } else { %>

<form method="POST" action="auth" class="form-signin">
    
    ${ERROR_CANT_LOGIN}
    
    <div class="container">
        <div class ="col-md-3" id="button_edito">
            <form method = "post"> 
                <label for="login" class="sr-only">Email address</label> 
                <input type="hidden" name="action" value="login">
                <input type="login" name="email" id="login" class="form-control" placeholder="Enter your login" required autofocus>
                <label for="inputPassword" class="sr-only">Password</label>
                <input type="password" name ="password" id="inputPassword" class="form-control" placeholder="Password" required>
            </form>
            <div class ="col-md-3">
                <button class="btn btn-lg btn-primary btn-block" type="submit" style = 'width: 200px; heigth:50px'>Login</button>
            </div>
        </div>

    </div>

    <!--fin de l'ajout-->
</form>

<form method="GET" action="pages/accountRegistration" class="form-signin">
    <button type="submit" class="btn-primary">Create account</button>
</form>


<% }%>
</div> <!--container-->

