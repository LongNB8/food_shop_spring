<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>

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
                    <li>
                        <div class="blog-icon">
                            <i class="fa  fa-pencil"></i>
                        </div>
                        <div class="blog-box">
                            <img src="${pageContext.request.contextPath}/uploads/images/${blog.image}" alt="">

                            <div class="blog-post-body clearfix">
                                <a href="">
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
                                        <p>${countcomment} Comments</p>
                                    </div>
                                </div>
                                <p>${blog.content}</p>
                            </div>
                        </div>
                    </li>
                </ul>	<!-- End of /.blog-zone -->

                <div class="author-id">
                    <div class="media">
                        <h5>About The Author</h5>
                        <img class="media-object pull-left" src="${pageContext.request.contextPath}/uploads/images/${blog.account.image}" alt="...">
                        <div class="media-body">
                            <h6 class="media-heading">${blog.account.username}</h6>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Labore, sequi quibusdam voluptate perferendis veniam eveniet! Lorem ipsum dolor sit amet, consectetur adipisicing elit. Perspiciatis, veritatis.</p>
                        </div>	<!-- End of /.media-body -->
                    </div>	<!-- End of /.media -->
                </div>	<!-- End of /.author-id -->

                <div class="comments-box">
                    <h5>${countcomment} REPSONSES</h5>
                    <c:forEach var="comment" items="${comments}" varStatus="i">
                    <div class="media">
                        <img class="media-object pull-left" src="${pageContext.request.contextPath}/uploads/images/${comment.account.image}" alt="...">
                        <div class="media-body">
                            <h6 class="media-heading">${comment.account.username}<span>${comment.create_at}</span>


                                   <h12313 style="margin-left: 480px"> <a data-toggle="collapse" href="#reply${i.index}"><i class="fa fa-comment-o"></i> Reply</a></h12313>


                            </h6>
                            <p>${comment.content}</p>
                        </div>
                    </div>
                        <c:forEach var="listsubcomment" items="${comment.comments}">
                            <!-- reply -->
                            <div class="media reply">
                                <img class="media-object pull-left" src="${pageContext.request.contextPath}/uploads/images/${listsubcomment.account.image}" alt="...">
                                <div class="media-body">
                                    <h6 class="media-heading">${listsubcomment.account.username} <span>  ${listsubcomment.create_at}</span> <a href=""  class="pull-right"></a></h6>
                                    <p>${listsubcomment.content} </p>
                                </div>
                            </div>
                        </c:forEach>

                        <div id="reply${i.index}" class="card-collapse collapse">
                            <div class="leave-comment">
                                <h5>REPLY COMMENT</h5>
                                <c:if test="${sessionScope.username == null}"><h123131 style="color: red">You need login ...!</h123131></c:if>
                                <c:if test="${sessionScope.username != null}">
                                    <s:form class="form-horizontal" modelAttribute="subcomment" action="${pageContext.request.contextPath}/comment/add/${blog.id}/${comment.id}" role="form" method="post">

                                        <div class="form-group">
                                            <div class="col-sm-offset-1 col-sm-11">
                                                <s:textarea path="content" cssClass="form-control" id="content"  placeholder = "content" required="required" rows="3"></s:textarea>
                                            </div>
                                        </div>	<!-- End of /.form-group -->

                                        <div class="form-group">
                                            <div class="col-sm-offset-1 col-sm-11">
                                                <button type="submit" class="btn btn-primary">Send</button>
                                            </div>
                                        </div>
                                    </s:form>
                                </c:if>
                            </div>
                        </div>

                    </c:forEach>









                </div>	<!-- End of /.comments-box -->

                <%--                subcomment      --%>


                <%--                comment     --%>
                <div class="leave-comment">
                    <h5>LEAVE A COMMENT</h5>
                    <c:if test="${sessionScope.username == null}"><h123131 style="color: red">You need login ...!</h123131></c:if>
                    <c:if test="${sessionScope.username != null}">
                        <s:form class="form-horizontal" modelAttribute="comment" action="${pageContext.request.contextPath}/comment/add/${blog.id}" method="post">

                            <div class="form-group">
                                <div class="col-sm-offset-1 col-sm-11">
                                    <s:textarea path="content" cssClass="form-control" id="content"  placeholder = "content" required="required" rows="3"></s:textarea>
                                </div>
                            </div>	<!-- End of /.form-group -->

                            <div class="form-group">
                                <div class="col-sm-offset-1 col-sm-11">
                                    <button type="submit" class="btn btn-primary">Send</button>
                                </div>
                            </div>

                        </s:form>
                    </c:if>
                </div>	<!-- End of /.leave comments -->
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


