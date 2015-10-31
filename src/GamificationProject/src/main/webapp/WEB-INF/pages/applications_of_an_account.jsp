<%-- 
    Document   : Registration
    Created on : Sept 9, 2015, 11:37:49 AM
    Author     : michelle meguep
--%>


<script type="text/javascript">
    function enableOrDisableApplication(id, enable) {

        var action = enable ? "enableApplication" : "disableApplication";
        var newState = enable ? "Enabled" : "Disabled";
        var newStyle = enable ? "btn btn-success" : "btn btn-danger";

        var buttonClicked = $("#btnEnable" + id);

        $.ajax({
            type: "POST",
            data: "action=" + action + "&idApplication=" + id,
            
            url: "applicationsAjax",
            
            beforeSend: function () {
                buttonClicked.html("En cours...");
                buttonClicked.attr('class', 'btn btn-warning');
            },
            success: function () {
                buttonClicked.html(newState);
                buttonClicked.attr('class', newStyle);
                buttonClicked.attr('onClick', enable ? "enableOrDisableApplication(" + id + ", false)" : "enableOrDisableApplication(" + id + ", true)");
            },
            error: function () {
                buttonClicked.html("Erreur :(");
            }

        });
    }
</script>

    <%@include file="includes/header.jsp" %>
    <%@include file="includes/startSideBarWrapper.jsp" %>
    <%@include file="includes/login.jsp" %>

        <h1 align = "center">Your apps...</h1>
        <form method="GET" action="pages/application?edit=false">
            <h2 align = "center"><button id="bregisternewapp" class="btn btn-primary" type="submit">Register New App</button></h2>
        </form>

        <table class="table">
            <tr>
                <th>Name</th>
                <th>Description</th>
                <th>ApiKey</th>
                <th>#End users</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="appli" items="${applications}">
                <tr>
                    <td id="Name">${appli[0].name}</td>
                    <td id="Description">${appli[0].description}</td>
                    <td>${appli[0].apiKey.key}</td>
                    <td>                        
                            <c:choose>
                                <c:when test="${appli[1] > 0}">
                                    <a id="linkEndUsers${appli[0].id}" href="pages/listUsersApp?idApplication=${appli[0].id}">${appli[1]}</a>
                                </c:when>

                                <c:otherwise>
                                    no user
                                </c:otherwise>
                            </c:choose>
                    </td>

                    <td>                        
                        <form method="GET" action="pages/application">
                            <input type="hidden" name="edit" value="true">
                            <input type="hidden" name="idApplication" value=${appli[0].id}>
                            <button id="edit${appli[0].id}" class="btn btn-default" type="submit">Edit</button>
                        </form>                    
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${appli[0].isEnable == true}">
                                <button id="btnEnable${appli[0].id}" class="btn btn-success" onclick="enableOrDisableApplication(${appli[0].id}, false)">Enabled</button>
                            </c:when>

                            <c:otherwise>
                                <button id="btnEnable${appli[0].id}" class="btn btn-danger" onclick="enableOrDisableApplication(${appli[0].id}, true)">Disabled</button>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <%@include file="includes/endSideBarWrapper.jsp" %>
        <%@include file="includes/footer.jsp"%>
