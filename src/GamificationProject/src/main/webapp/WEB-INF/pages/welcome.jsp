<%-- 
    Document   : login
    Created on : Sep 9, 2015, 11:37:49 AM
    Author     : Olivier Liechti (olivier.liechti@heig-vd.ch)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html lang="en">
    
    <%@include file="includes/header.jsp" %>

  <body>
      <%@include file="includes/login.jsp" %>

    <div class="container">

      <form method="POST" action="auth" class="form-signin">
         <!--ajout de ma part -->
         <div class = "container">
             <div class ="row">
                <div class ="col-md-3" id="button_edito">
                    <form method = "post"> 
                        <label for="login" class="sr-only">Email address</label> 
                        <input type="hidden" name="action" value="login">
                        <input type="login" name="email" id="login" class="form-control" placeholder="Enter your login" required autofocus>
                         <label for="inputPassword" class="sr-only">Password</label>
                        <input type="password" name ="password" id="inputPassword" class="form-control" placeholder="Password" required>
                    </form>
                    <div class ="col-md-3">
                       <button id="blogin" class="btn btn-lg btn-primary btn-block" type="submit" style = 'width: 200px; heigth:50px'>Login</button>
                                       <!--Demander à liechti si OK-->
                        <form method="POST" action="pages/accountRegistration" class="form-signin">
                            <button id="bcreatAccount" class="btn btn-lg btn-primary btn-block" type="submit" style = 'width: 200px; heigth:50px'>Create account</button>
                        </form>
                    </div>
                    
                </div>
            </div>
             
             <br/>
             <br/>
         <h2 class="form-signin-heading">Welcome to GamY</h2>
         <br/>
         <br/>
         
         </div>
         
        <!--fin de l'ajout-->
      </form>

    </div> <!-- /container -->
	
  </body>
  
</html>

