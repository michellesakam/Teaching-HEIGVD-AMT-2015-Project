<%-- 
    Document   : errors.jsp
    Created on : 12 oct. 2015, 15:28:44
    Author     : Raphaël Racine
--%>
<c:forEach var="error" items="${errors}">
    <div class="panel panel-danger" >
        <div class="panel-heading">
            ${error}
        </div>
    </div>
</c:forEach>
