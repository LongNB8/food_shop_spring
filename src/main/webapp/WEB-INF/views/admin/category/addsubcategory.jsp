<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>

<section class="content-header">
    <h1>
        Category sub Add to ${cateogory.name}

    </h1>
    <ol class="breadcrumb">
        <li><a href="${pageContext.request.contextPath}/admin/dashboard"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/category">Category</a></li>

    </ol>
</section>


<section class="content">
    <div class="row">
        <!-- left column -->
        <div class="col-md-12">
            <!-- general form elements -->
            <div class="box box-primary">

                <s:form method="post" modelAttribute="category" action="${pageContext.request.contextPath}/admin/category/addsubcategory">
                    <div class="box-body">
                        <div class="form-group">
                            <label for="name">Category Name</label>
                            <s:input path="name" cssClass="form-control" id="name" required="required"></s:input>
                        </div>
                    <!-- /.box-body -->

                        <div class="checkbox">
                            <label><s:checkbox path="status"></s:checkbox>Status</label>
                        </div>

                        <div class="box-footer">
                            <button type="submit" class="btn btn-primary">Save</button>
                            <s:hidden path="category.id"></s:hidden>
                            <s:hidden path="id"></s:hidden>
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

