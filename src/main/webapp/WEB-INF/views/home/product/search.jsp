<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>
<section id="topic-header">
    <div class="container">
        <div class="row">
            <div class="col-md-4">
                <h1>Shop</h1>
                <p>A Bunch Of Products</p>
            </div>	<!-- End of /.col-md-4 -->
            <div class="col-md-8 hidden-xs">
                <ol class="breadcrumb pull-right">
                    <li><a href="${pageContext.request.contextPath}/home">Home</a></li>
                    <li class="active">Shop</li>
                </ol>
            </div>	<!-- End of /.col-md-8 -->
        </div>	<!-- End of /.row -->
    </div>	<!-- End of /.container -->
</section>


<section id="shop">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="products-heading">
                    <h2>NEW PRODUCTS </h2>
                </div>	<!-- End of /.Products-heading -->
                <div class="product-grid">
                    <ul>
                        <c:forEach var="product" items="${product}">
                            <c:set var="photo" value="${product.getPhotos().stream().filter(p -> p.isStatus() && p.isMain()).findFirst().get()}"></c:set>
                        <li>
                            <div class="products">
                                <a href="#">
                                    <img src="${pageContext.request.contextPath}/uploads/images/${photo.name}" alt="">
                                </a>
                                <a href="#">
                                    <h4>${product.name}</h4>
                                </a>
                                <p class="price">From: £${product.price}</p>
                                <div>
                                    <a class="view-link shutter" href="${pageContext.request.contextPath}/product/buy/${product.id}">
                                        <i class="fa fa-plus-circle"></i>Add To Cart</a>
                                </div>
                            </div>	<!-- End of /.products -->
                        </li>
                        </c:forEach>
                        <!--  ... -->
                    </ul>
                </div>	<!-- End of /.products-grid -->

                <!-- Pagination -->

                <div class="pagination-bottom">
                    <ul class="pagination">
                        <li class="disabled"><a href="#">«</a></li>
                        <li class="active"><a href="#">1 <span class="sr-only"></span></a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">»</a></li>
                    </ul>	<!-- End of /.pagination -->
                </div>
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