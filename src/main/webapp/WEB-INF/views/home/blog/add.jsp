<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>

<section id="topic-header">
    <div class="container">
        <div class="row">
            <div class="col-md-4">
                <h1>BLOG</h1>
                <p>add</p>
            </div>	<!-- End of /.col-md-4 -->
            <div class="col-md-8 hidden-xs">
                <ol class="breadcrumb pull-right">
                    <li><a href="${pageContext.request.contextPath}/">Home</a></li>
                    <li><a href="${pageContext.request.contextPath}/blog/add">add</a></li>
                    <li class="active">Blog</li>
                </ol>
            </div>	<!-- End of /.col-md-8 -->
        </div>	<!-- End of /.row -->
    </div>	<!-- End of /.container -->
</section>

<br><br>

<s:form class="form-horizontal" modelAttribute="blog" action="${pageContext.request.contextPath}/blog/add" method="post" enctype="multipart/form-data">
    <div class="form-group">
        <label for="title" class="col-sm-2 control-label">Name</label>
        <div class="col-sm-6">
            <s:input path="title" cssClass="form-control" id="title" placeholder = "title" required="required" ></s:input>
        </div>
    </div>	<!-- End of /.form-group -->

    <div class="form-group">
        <label for="content" class="col-sm-2 control-label">Content</label>
        <div class="col-sm-6">
            <s:textarea path="content" cssClass="form-control" id="content"  placeholder = "content" required="required" rows="10"></s:textarea>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">Category</label>
        <div class="col-sm-6">
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
    </div>

    <div class="form-group">
        <label for="image" class="col-sm-2 control-label">Image</label>
        <div class="col-sm-6">
            <input type="file" name="file">
        </div>
    </div>

    <c:if test="${sessionScope.username == null}">
        <br>
            <h2 style="color:red; margin-left: 200px">You need Login .....</h2>

    </c:if>
    <c:if test="${sessionScope.username != null}">
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-primary">Send</button>
        </div>
    </div>
    </c:if>
</s:form>