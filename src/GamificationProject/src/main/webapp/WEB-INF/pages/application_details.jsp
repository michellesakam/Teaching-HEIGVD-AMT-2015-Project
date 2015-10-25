<%-- 
    Document   : Registration
    Created on : Sept 9, 2015, 11:37:49 AM
    Author     : michelle meguep
--%>

    <%@include file="includes/header.jsp"%>
    <%@include file="includes/startSideBarWrapper.jsp"%>
 
        <h1 align="center">App Details</h1>

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
                    <TEXTAREA name="description" rows=4 cols=40>${application.description}</TEXTAREA>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label" for="Key">API Key</label>
                <div class="col-md-4">
                    ${application.apiKey.key}
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label" for="Users">Users</label>
                <div class="col-md-4">
                    ${nbEndUsers}
                </div> 
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label" for="State">State</label>
                <div class="col-md-offset-3 col-md-9">
                    
                    <c:choose>
                        
                        <c:when test="${application.isEnable == true}">
                            <button class="btn btn-success" type="button">Enabled</button>
                        </c:when>
                        
                            <c:otherwise>
                            <button class="btn btn-danger" type="button">Disabled</button>
                        </c:otherwise>
                            
                    </c:choose>

                    
                </div>
            </div>
            <div class="form-group" >
                <div class="col-md-offset-3 col-md-9">
                    <button class="btn btn-primary" type="submit">(A FAIRE !!!) Register</button>
                    <button class="btn btn-default" type="button">Cancel</button>
                </div>
            </div>
        </form>    
    <%@include file="includes/endSideBarWrapper.jsp"%>
    <%@include file="includes/footer.jsp"%>
