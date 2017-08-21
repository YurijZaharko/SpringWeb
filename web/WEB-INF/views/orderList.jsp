<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="custom" uri="/WEB-INF/custom.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: SC
  Date: 09.02.2017
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-3">
            <div class="row">
                <div class="col-md-offset-2 col-md-8">
                    <form:form action="" cssClass="form-horizontal" method="get" modelAttribute="userOrderFilterForm">
                        <div class="form-group">
                            <label for="orderIdString">Order ID</label>
                            <form:input path="orderIdString" class="form-control" placeHolder="Search by order Id" id="orderIdString"/>
                        </div>
                        <div class="form-group">
                            <label for="phoneNumber">Phone number</label>
                            <form:input path="phoneNumber" class="form-control" placeHolder="(123)123-4567" id="phoneNumber"/>
                        </div>
                        <div class="form-group">
                            <label for="productIdString">Product ID</label>
                            <form:input path="productIdString" class="form-control" placeHolder="Search by product ID in order" id="productIdString"/>
                        </div>
                        <div class="form-group">
                            <label for="orderDelivery">Delivery type</label>
                            <form:select path="orderDelivery"  class="form-control" placeHolder="Search by delivery type" id="orderDelivery">
                                <form:options/>
                            </form:select>
                        </div>
                        <div class="form-group"></div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary">Search</button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
        <div class="col-md-9">
            <div class="row">
                <div class="col-md-1">
                    <a href="/admin/manager/createOrder"class="btn btn-primary">Create order</a>
                </div>
                <div class="col-md-1 col-md-offset-11">
                    <custom:size posibleSizes="1,2,5,10" size="${UserOrder.size}" title="Розмір сторінки"/>
                </div>
            </div>
            <table class="table table-hover">
                <tr>
                    <td>Order ID</td>
                    <td>User Name</td>
                    <td>User Surname</td>
                    <td>User phone number</td>
                    <td>Products</td>
                    <td>Sum</td>
                    <td>Edit</td>

                </tr>
                <c:forEach items="${userOrders.content}" var="userOrder">
                    <tr>
                        <td>${userOrder.id}</td>
                        <td>${userOrder.user.name}</td>
                        <td>${userOrder.user.surname}</td>
                        <td>${userOrder.user.phoneNumber}</td>
                        <td>
                            <table class="table table-hover">
                                <c:forEach items="${userOrder.orderFields}" var="orderField" varStatus="status">
                                    <tr>
                                        <td>${status.count}</td>
                                        <td>${orderField.product.productName}</td>
                                        <td>${orderField.quantity} q</td>
                                        <td>${orderField.outPrice}</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </td>
                        <td>
                            <c:set var="total" value="${0}"/>
                            <c:forEach var="orderField" items="${userOrder.orderFields}">
                                <c:set var="total" value="${total + orderField.outPrice}"/>
                            </c:forEach>
                            ${total}
                        </td>
                        <td><a href="/admin/manager/createOrder/update/${userOrder.id}" class="btn btn-warning">Update order</a> </td>
                    </tr>
                </c:forEach>

            </table>
            <div class="col-md-12 col-md-offset-3">
            <custom:pageable page="${userOrders}" cell="<li></li>" container="<ul class='pagination'></ul>" />
        </div>
        </div>
    </div>

</div>