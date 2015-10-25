<%-- 
    Document   : list_user_of_application
    Created on : 26 sept. 2015, 08:48:42
    Author     : Raphaël Racine
--%>


    <%@include file="includes/header.jsp" %>


        <%@include file="includes/startSideBarWrapper.jsp" %>
        <%@include file="includes/login.jsp" %>

        <h1>List of users for "${application.name}"</h1>

        ${nbEndUsersPerPage} results per page
        <br>
        <br>
        
        <table class="table">
            <tr>
                <th>User Id</th>
                <th>Creation Date</th>
            </tr>
            
            <c:forEach items="${endUsersPaginated}" var="e">
                <tr>
                    <td>${e.userID}</td>
                    <td>${e.regDate}</td>
                </tr>
            </c:forEach>

        </table>
        
        Page ${numPage} / ${nbPages} 
        <a href="pages/listUsersApp?idApplication=${application.id}&currentNumPage=1&nbEndUsersPerPage=${nbEndUsersPerPage}">First Page</a>
        <a href="pages/listUsersApp?idApplication=${application.id}&currentNumPage=${numPage - 1}&nbEndUsersPerPage=${nbEndUsersPerPage}">Previous Page</a>
        <a href="pages/listUsersApp?idApplication=${application.id}&currentNumPage=${numPage + 1}&nbEndUsersPerPage=${nbEndUsersPerPage}">Next Page</a>
        <a href="pages/listUsersApp?idApplication=${application.id}&currentNumPage=${nbPages}&nbEndUsersPerPage=${nbEndUsersPerPage}">Last Page</a>

        <%@include file="includes/endSideBarWrapper.jsp" %>
        <%@include file="includes/footer.jsp"%>