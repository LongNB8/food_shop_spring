<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>

<section class="content-header">
    <h1>
        Admin Profile
        <small>Preview</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="${pageContext.request.contextPath}/admin/dashboard"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/profile">Profile</a></li>

    </ol>
</section>


<section class="content">
    <div class="row">
        <!-- left column -->
        <div class="col-md-12">
            <!-- general form elements -->
            <div class="box box-primary">

                <s:form method="post" modelAttribute="account" action="${pageContext.request.contextPath}/admin/profile">
                    <div class="box-body">
                        <div class="form-group">
                            <label for="username">Username</label>
                            <s:input path="username" cssClass="form-control" id="username" required="required"></s:input>

                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                            <s:password path="password" cssClass="form-control" id="password"></s:password>

                        </div>

                        <div class="form-group">
                            <label for="fullname">FullName</label>
                            <s:input path="fullname" cssClass="form-control" id="fullname" required="required"></s:input>

                        </div>

                        <div class="form-group">
                            <label for="address">Address</label>
                            <s:input path="address" cssClass="form-control" id="address" ></s:input>
                        </div>

                        <div class="form-group">
                            <label for="email">Email</label>
                            <s:input path="email" cssClass="form-control" id="email" required="required" ></s:input>
                        </div>

                        <div class="form-group">
                            <label for="phone">Phone</label>
                            <s:input path="phone" cssClass="form-control" id="phone" required="required"></s:input>
                        </div>

                    </div>
                    <!-- /.box-body -->

                    <div class="box-footer">
                        <button type="submit" class="btn btn-primary">Save</button>
                        <s:hidden path="id"></s:hidden>
                    </div>
                </s:form>
            </div>
            <!-- /.box -->



        </div>
        <!--/.col (left) -->
        <!-- right column -->

        <!--/.col (right) -->
    </div>
    <!-- /.row -->
</section>

