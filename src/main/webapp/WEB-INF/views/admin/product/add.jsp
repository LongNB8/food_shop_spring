<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="content-header">
    <h1>
        Product Add

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

                <s:form method="post" modelAttribute="product" action="${pageContext.request.contextPath}/admin/product/add">
                    <div class="box-body">
                        <div class="form-group">
                            <label for="name">Product Name</label>
                            <s:input path="name" cssClass="form-control" id="name" required="required"></s:input>
                        </div>

                        <div class="form-group">
                            <label for="price">Product price</label>
                            <s:input type="number" min="0" path="price" cssClass="form-control" id="price" required="required"></s:input>
                        </div>

                        <div class="form-group">
                            <label for="name">Product quantity</label>
                            <s:input type="number" min="0" path="quantity" cssClass="form-control" id="quantity" required="required"></s:input>
                        </div>



                        <div class="form-group">
                            <label for="description">Description</label>
                            <s:textarea  path="description" cssClass="form-control" id="description" ></s:textarea>
                        </div>



                        <div class="checkbox">
                            <label><s:checkbox path="featured"></s:checkbox>Featured</label>
                        </div>

                        <div class="checkbox">
                            <label><s:checkbox path="status"></s:checkbox>Status</label>
                        </div>

                        <div class="form-group">
                            <label >Category</label>
                                <s:select path="category.id"  class="form-control">
                                    <c:forEach var="category" items="${categories}">
                                        <optgroup label="${category.name}"></optgroup>
                                        <c:if test="${!category.categories.isEmpty()}">
                                            <c:forEach var="subcategory" items="${category.categories}">
                                                <s:option value="${subcategory.id}">${subcategory.name}</s:option>

                                            </c:forEach>
                                        </c:if>
                                    </c:forEach>
                                </s:select>
                        </div>

                        <div class="box-footer">
                            <button type="submit" class="btn btn-primary">Save</button>
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

