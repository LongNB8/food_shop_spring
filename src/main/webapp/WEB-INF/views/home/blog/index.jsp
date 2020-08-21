<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<section id="topic-header">
    <div class="container">
        <div class="row">
            <div class="col-md-4">
                <h1>BLOG</h1>
                <p>Latest News</p>
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



<section id="blog">
    <div class="container">
        <div class="row">
            <div class="col-md-9 clearfix">
                <ul class="blog-zone">
                    <c:forEach var="blog" items="${blog}">
                    <li>
                        <div class="blog-icon">
                            <i class="fa  fa-pencil"></i>
                        </div>
                        <div class="blog-box">
                            <img src="${pageContext.request.contextPath}/uploads/images/${blog.image}" alt="">

                            <div class="blog-post-body clearfix">
                                <a href="${pageContext.request.contextPath}/blog/details/${blog.id}">
                                    <h2>${blog.title}</h2>
                                </a>
                                <div class="blog-post-tag">
                                    <div class="block">
                                        <i class="fa fa-clock-o"></i>
                                        <p>${blog.create_at}</p>
                                    </div>
                                    <div class="block">
                                        <i class="fa fa-user"></i>
                                        <p>${blog.account.username}</p>
                                    </div>
                                    <div class="block">
                                        <i class="fa fa-tags"></i>
                                        <p>
                                            <a href="">${blog.category.name}</a>,

                                        </p>
                                    </div>
                                    <div class="block">
                                        <i class="fa fa-comments"></i>
                                        <p>3 Comments</p>
                                    </div>
                                </div>
                                <p>${blog.content}</p>
                                <a href="${pageContext.request.contextPath}/blog/details/${blog.id}" class="btn btn-default btn-transparent pull-right" role="button">
                                    <span>Read More</span>
                                </a>
                            </div>
                        </div>	<!-- End of /.blog-box -->
                    </li>
                    </c:forEach>
                </ul>	<!-- End of /.blog-zone -->

                <!-- Pagination -->

            </div>	<!-- End of /.col-md-9 -->

            <div class="col-md-3">
                <div class="blog-sidebar">
                    <div class="block">
                        <h4>Catagories</h4>

                        <c:forEach var="category" items="${category}">


                            <div class="list-group-item"><i class="fa fa-angle-double-right" aria-hidden="true"></i> ${category.name} </div>



                            <div class="dropdown-container	" style="display: none;">
                                <c:forEach var="sub" items="${category.getCategories()}">
                                    <a href="#" class="list-group-item">
                                        <i class="fa fa-hand-o-right"></i>
                                            ${sub.name}
                                    </a>

                                </c:forEach>
                            </div>



                        </c:forEach>

                    </div>
                </div>
                <div class="block">
                    <img src="${pageContext.request.contextPath}/resources/user/images/food-ad.png" alt="">
                </div>
                <div class="block">
                    <h4>Latest Food Items</h4>
                    <ul class="media-list">
                        <c:forEach var="lastestItem" items="${lastestproduct}">
                            <c:set var="photo1" value="${lastestItem.getPhotos().stream().filter(p -> p.isStatus() && p.isMain()).findFirst().get()}"></c:set>
                            <li class="media">
                                <a class="pull-left" href="#">
                                    <img class="media-object" src="${pageContext.request.contextPath}/uploads/images/${photo1.name}" width="72px">
                                </a>
                                <div class="media-body">
                                    <a href="" class="media-heading">

                                        <p>${lastestItem.description}</p>

                                    </a>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>

                <div class="block">
                    <h4>Food Tag</h4>
                    <div class="tag-link">
                        <a href="">BALLET</a>
                        <a href="">CHRISTMAS</a>
                        <a href="">ELEGANCE</a>
                        <a href="">ELEGANT</a>
                        <a href="">SHOPPING</a>
                        <a href="">SHOP</a>
                    </div>
                </div>
            </div>	<!-- End of /.col-md-3 -->
        </div>	<!-- End of /.row -->
    </div>	<!-- End of /.container -->
</section>





