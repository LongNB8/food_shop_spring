<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="slider" uri="http://trangcualong.net" %>

<slider:SliderHome/>
<section id="features">
    <div class="container">
        <div class="row">
            <div class="col-md-4">
                <div class="block">
                    <div class="media">
                        <div class="pull-left" href="#">
                            <i class="fa fa-ambulance"></i>
                        </div>
                        <div class="media-body">
                            <h4 class="media-heading">Free Shipping</h4>
                            <p>Lorem ipsum dolor sit amet, consectetur.</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="block">
                    <div class="media">
                        <div class="pull-left" href="#">
                            <i class=" fa fa-foursquare"></i>
                        </div>
                        <div class="media-body">
                            <h4 class="media-heading">Media heading</h4>
                            <p>Lorem ipsum dolor sit amet, consectetur.</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="block">
                    <div class="media">
                        <div class="pull-left" href="#">
                            <i class=" fa fa-phone"></i>
                        </div>
                        <div class="media-body">
                            <h4 class="media-heading">Call Us</h4>
                            <p>Lorem ipsum dolor sit amet, consectetur.</p>
                        </div>	<!-- End of /.media-body -->
                    </div>	<!-- End of /.media -->
                </div>	<!-- End of /.block -->
            </div> <!-- End of /.col-md-4 -->
        </div>	<!-- End of /.row -->
    </div>	<!-- End of /.container -->
</section>

<section id="catagorie">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="block">
                    <div class="block-heading">
                        <h2>OUR FOOD CATEGORIES</h2>
                    </div>
                    <div class="row">
                     <c:forEach var="category" items="${category}">

                        <div class="col-sm-6 col-md-4">
                            <div class="thumbnail">
                                <a class="catagotie-head" href="blog-single.html">

                                    <img src="${pageContext.request.contextPath}/resources/user/images/${pho.name}" alt="...">
                                    <h3>${category.name}</h3>
                                </a>
                                <div class="caption">
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Iste, aut, esse, laborum placeat id illo a expedita aperiam...</p>
                                    <p>
                                        <a href="blog-single.html" class="btn btn-default btn-transparent" role="button">
                                            <span>Check Items</span>
                                        </a>
                                    </p>
                                </div>	<!-- End of /.caption -->
                            </div>	<!-- End of /.thumbnail -->
                        </div>	<!-- End of /.col-sm-6 col-md-4 -->
                        </c:forEach>

                    </div>	<!-- End of /.row -->
                </div>	<!-- End of /.block -->
            </div>	<!-- End of /.col-md-12 -->
        </div>	<!-- End of /.row -->
    </div>	<!-- End of /.container -->
</section>


<section id="products">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="products-heading">
                    <h2>NEW PRODUCTS</h2>
                </div>
            </div>
        </div>
        <div class="row">
            <c:forEach var="product" items="${product}">
                <c:set var="photo" value="${product.getPhotos().stream().filter(p -> p.isStatus() && p.isMain()).findFirst().get()}"></c:set>
            <div class="col-md-3">
                <div class="products">
                    <a href="${pageContext.request.contextPath}/product/details/${product.id}">
                        <img src="${pageContext.request.contextPath}/uploads/images/${photo.name}" alt="">
                    </a>
                    <a href="${pageContext.request.contextPath}/product/details/${product.id}">
                        <h4>${product.name}</h4>
                    </a>
                    <p class="price">From: £${product.price}</p>
                    <a class="view-link shutter" href="${pageContext.request.contextPath}/product/buy/${product.id}">
                        <i class="fa fa-plus-circle"></i>Add To Cart</a>
                </div>	<!-- End of /.products -->
            </div>	<!-- End of /.col-md-3 -->
            </c:forEach>
        </div>	<!-- End of /.row -->
    </div>	<!-- End of /.container -->
</section>

<section id="call-to-area">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="block">
                    <div class="block-heading">
                        <h2>Our Partners</h2>
                    </div>
                </div>	<!-- End of /.block -->
                <div id="owl-example" class="owl-carousel owl-theme" style="opacity: 1; display: none;">
                    <div class="owl-item" style="width: 228px;"><div> <img src="${pageContext.request.contextPath}/resources/user/images/company-1.png" alt=""></div></div><div class="owl-item" style="width: 228px;"><div> <img src="${pageContext.request.contextPath}/resources/user/images/company-2.png" alt=""></div></div><div class="owl-item" style="width: 228px;"><div> <img src="${pageContext.request.contextPath}/resources/user/images/company-3.png" alt=""></div></div><div class="owl-item" style="width: 228px;"><div> <img src="${pageContext.request.contextPath}/resources/user/images/company-4.png" alt=""></div></div><div class="owl-item" style="width: 228px;"><div> <img src="${pageContext.request.contextPath}/resources/user/images/company-5.png" alt=""></div></div><div class="owl-item" style="width: 228px;"><div> <img src="${pageContext.request.contextPath}/resources/user/images/company-6.png" alt=""></div></div><div class="owl-item" style="width: 228px;"><div> <img src="${pageContext.request.contextPath}/resources/user/images/company-8.png" alt=""></div></div><div class="owl-item" style="width: 228px;"><div> <img src="${pageContext.request.contextPath}/resources/user/images/company-9.png" alt=""></div></div></div>


            </div>	<!-- End of /.col-md-12 -->
        </div> <!-- End Of /.Row -->
    </div> <!-- End Of /.Container -->
</section>



