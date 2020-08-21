<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>


<section id="topic-header">
    <div class="container">
        <div class="row">
            <div class="col-md-4">
                <h1>Products Details</h1>
                <p></p>
            </div>	<!-- /.col-md-4 -->
            <div class="col-md-8 hidden-xs">
                <ol class="breadcrumb pull-right">
                    <li><a href="${pageContext.request.contextPath}/home">Home</a></li>
                    <li><a href="${pageContext.request.contextPath}/product">Products</a></li>
                    <li class="active">Single Products</li>
                </ol>
            </div> <!-- /.col-md-8 -->
        </div>	<!-- /.row -->
    </div>	<!-- /.container-->
</section>

<section id="single-product">
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <div class="single-product-img">
                    <img src="${pageContext.request.contextPath}/uploads/images/${photo.name}" alt="">
                </div>

            </div> <!-- End of /.col-md-5 -->
            <div class="col-md-4">
                <div class="block">
                    <div class="product-des">
                        <h4>${product.name}</h4>
                        <p class="price">$${product.price}</p>
                        <p>${product.description}</p>
                        <br>
                        <br>
                        <a class="view-link" href="${pageContext.request.contextPath}/product/buy/${product.id}"><i class="fa fa-plus-circle"></i>Add To Cart</a>
                    </div>	<!-- End of /.product-des -->
                </div> <!-- End of /.block -->
            </div>	<!-- End of /.col-md-4 -->

        </div>	<!-- End of /.row -->
        <div class="row">
            <div class="col-md-12">
                <!-- Nav tabs -->
                <ul class="nav nav-tabs">
                    <li class="active"><a href="#home" data-toggle="tab">More Info</a></li>
                    <li class=""><a href="#profile" data-toggle="tab">Comments</a></li>
                </ul>

                <!-- Tab panes -->
                <div class="tab-content">
                    <div class="tab-pane active" id="home">
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Delectus eligendi quidem vel sit expedita nam sint non explicabo magni totam?</p>
                    </div>
                    <div class="tab-pane" id="profile">
                        <p>No customer comments for the moment.</p>
                    </div>
                </div>
            </div>	<!-- End of /.col-md-9 -->
            <div class="col-md-3">
                <div class="blog-sidebar">
                    <div class="block">
                        <img src="images/food-ad.png" alt="">
                    </div> <!-- End of /.block -->
                </div>	<!-- End of /.blog-sidebar -->
            </div>	<!-- End of /.col-md-3 -->
        </div>	<!-- End of /.row -->
    </div>	<!-- End of /.Container -->
</section>