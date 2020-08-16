<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="content-header">
    <h1>
        Photo Add to ${photo.product.name}

    </h1>
    <ol class="breadcrumb">
        <li><a href="${pageContext.request.contextPath}/admin/dashboard"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/product">Product</a></li>

    </ol>
</section>


<section class="content">
    <div class="row">
        <!-- left column -->
        <div class="col-md-12">
            <!-- general form elements -->
            <div class="box box-primary">

                <s:form method="post" modelAttribute="photo" action="${pageContext.request.contextPath}/admin/product/addphoto" enctype="multipart/form-data">
                    <div class="box-body">

                        <div class="form-group">
                            <label for="name"></label>
                            <input type="file" name="file">
                        </div>

                        <div class="checkbox">
                            <label><s:checkbox path="main"></s:checkbox>Main</label>
                        </div>

                        <div class="checkbox">
                            <label><s:checkbox path="status"></s:checkbox>Status</label>
                        </div>



                        <div class="box-footer">
                            <button type="submit" class="btn btn-primary">Save</button>
                            <s:hidden path="product.id"></s:hidden>
                        </div>
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

