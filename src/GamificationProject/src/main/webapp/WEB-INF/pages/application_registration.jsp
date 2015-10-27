<%-- 
    Document   : Registration
    Created on : Sept 9, 2015, 11:37:49 AM
    Author     : michelle meguep
--%>

<script type="text/javascript">
    function enableOrDisableApplication() {
        if($('#isEnable').attr("value") === "true") {
            $('#isEnable').attr("value", "false");
            $('#btnIsEnable').attr("class", "btn btn-danger");
            $('#btnIsEnable').html("Disabled");
        }
        else
        {
            $('#isEnable').attr("value", "true");
            $('#btnIsEnable').attr("class", "btn btn-success");
            $('#btnIsEnable').html("Enabled");
        }
    }
</script>

<%@include file="includes/header.jsp"%>
<%@include file="includes/startSideBarWrapper.jsp"%>
<h1 align="center">${title}</h1>

<form method="POST" class="form-horizontal" name="registerForm">
    <div class="form-group">
        <label class="col-md-3 control-label" for="Name" required>Name</label>
        <div class="col-md-4">
            <input id="Name" type="Name" class="form-control" name="Name" value="${application.name}" required/>
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-3 control-label" for="Description">Description</label>
        <div class="col-md-4">
            <TEXTAREA id="Description" name="description" rows=4 cols=40>${application.description}</TEXTAREA>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label" for="Key">API Key</label>
                <div class="col-md-4">
            <c:choose>
                <c:when test="${edit != null}">
                    ${application.apiKey.key}
                </c:when>
                <c:otherwise>
                    The ApiKey will be generated after the creation of application
                </c:otherwise>
            </c:choose>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label" for="Users">Users</label>
                <div class="col-md-4">
            <c:choose>
                <c:when test="${edit != null}">
                    ${nbEndUsers}
                </c:when>
                <c:otherwise>
                    0
                </c:otherwise>
            </c:choose>
                </div> 
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label" for="State">State</label>
                <div class="col-md-offset-3 col-md-9">
                    <input id="isEnable" type="hidden" name="isEnable" value="${application.isEnable == null ? true : application.isEnable}"/>                    
                    <input type="hidden" name="idApplication" value="${application.id}" />
            <c:choose>
                <c:when test="${application.isEnable == false}">
                    <button id="btnIsEnable" type="button" onclick="enableOrDisableApplication()" class="btn btn-danger">Disabled</button>
                </c:when>
                <c:otherwise>
                    <button id="btnIsEnable" type="button" onclick="enableOrDisableApplication()" class="btn btn-success">Enabled</button>
                </c:otherwise>
            </c:choose> 
                </div>
            </div>
            <div class="form-group" >
                <div class="col-md-offset-3 col-md-9">
                    <a href="pages/yourApps"><button id ="bcancel" class="btn btn-default" type="button">Cancel</button></a>
                    <button id="bregister" class="btn btn-primary" type="submit">Register</button>
                </div>
            </div>
        </form>
                    
<%@include file="includes/endSideBarWrapper.jsp"%>
<%@include file="includes/footer.jsp"%>
