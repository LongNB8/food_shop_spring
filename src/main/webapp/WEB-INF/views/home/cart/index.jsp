<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="span9">
    <ul class="breadcrumb">
        <li><a href="${pageContext.request.contextPath}/">Home</a> <span class="divider">/</span></li>
        <li class="active"> SHOPPING CART</li>
    </ul>
    <h3>  SHOPPING CART [ <small>${countItem} Item(s) </small>]<a href="${pageContext.request.contextPath}/" class="btn btn-large pull-right"><i class="icon-arrow-left"></i> Continue Shopping </a></h3>
    <hr class="soft">


    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Action</th>
            <th>Product</th>
            <th>Name</th>
            <th>Description</th>
            <th>Quantity/Update</th>
            <th>Price</th>
            <th>Total</th>
        </tr>
        </thead>

            <tbody>
            <c:forEach var="item" items="${sessionScope.cart}" varStatus="i">

                <tr>
                    <td><a class="btn btn-danger" href="${pageContext.request.contextPath}/cart/remove/${i.index}"><i class="icon-remove icon-white"></i></a></td>
                    <td> <img width="60" src="${pageContext.request.contextPath}/uploads/images/${item.photo.name}" alt=""></td>
                    <td>${item.product.name}</td>
                    <td>${item.product.description}</td>
                    <td>

                            <input class="span1" style="width:60px" placeholder="1" name="quantities" size="16" type="number" value="${item.quantity}">

                    </td>

                    <td>$${item.product.price}</td>

                    <td>$${item.product.price * item.quantity}</td>

                </tr>
            </c:forEach>

                <tr>
                    <td colspan="6" style="text-align:right"><strong>TOTAL =</strong></td>
                    <td class="label label-important" style="display:block"> <strong> $${total} </strong></td>
                </tr>

            </tbody>

    </table>


    <table class="table table-bordered">
        <tbody>
        <tr>
            <td>
                <form class="form-horizontal">
                    <div class="control-group">
                        <label class="control-label"><strong> VOUCHERS CODE: </strong> </label>
                        <div class="controls">
                            <input type="text" class="input-medium" placeholder="CODE">
                            <button type="submit" class="btn"> ADD </button>
                        </div>
                    </div>
                </form>
            </td>
        </tr>

        </tbody>
    </table>


    <a href="products.html" class="btn btn-large"><i class="icon-arrow-left"></i> Continue Shopping </a>
    <a href="login.html" class="btn btn-large pull-right">Next <i class="icon-arrow-right"></i></a>

</div>