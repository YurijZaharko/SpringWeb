<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: SC
  Date: 20.02.2017
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <form:form action="/admin/manager/createOrder" method="post" modelAttribute="userOrdersForm" class="form-horizontal">
                <div class="form-group">
                    <form:hidden path="orderId"/>Order # ${userOrdersForm.orderId}
                </div>
                <div class="form-group">
                    <div class="form-inline">

                        <form:input path="name"  class="form-control" placeHolder="Name"/>
                        <form:errors path="name"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-inline">

                        <form:input path="surname"  class="form-control" placeHolder="Surname"/>
                        <form:errors path="surname"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-inline">

                        <form:input path="phoneNumber"  class="form-control" placeHolder="Phone number"/>
                        <form:errors path="surname"/>
                    </div>
                </div>
                <div class="form-group">
                    <form:select path="orderDelivery"  class="form-control">
                        <form:options/>
                    </form:select>
                </div>
                <div class="form-group">
                    <form:select path="orderStatus"  class="form-control">
                        <form:options/>
                    </form:select>
                </div>
                <table class="table table-responsive">
                    <tr>
                        <td><form:input path="newProductId" placeHolder="Product ID"/></td>
                        <td><form:input path="quantity" placeHolder="Quantity"/></td>
                        <td><button type="submit" name="addProduct" value="addProduct" class="btn btn-primary">Add product</button></td>
                    </tr>
                    <tr>
                        <td><form:errors path="newProductId"/></td>
                        <td><form:errors path="quantity"/></td>
                        <td></td>
                    </tr>
                </table>
                <table class="table table-condensed">

                    <tr>
                        <td>#</td>
                        <td>Product ID</td>
                        <td>Product name</td>
                        <td>Product part number</td>
                        <td>Quantity</td>
                        <td>IN</td>
                        <td>OUT</td>
                    </tr>
                    <c:forEach items="${userOrdersForm.orderFields}" var="orderField" varStatus="status">
                        <tr>
                            <td>${status.count}</td>
                            <td style="display:none"><input name="orderFields[${status.index}].id" value="${orderField.id}" style="display:none"/></td>
                            <td><input name="orderFields[${status.index}].productID" value="${orderField.productID}" readonly/></td>
                            <td><input name="orderFields[${status.index}].productName" value="${orderField.productName}"/></td>
                            <td><input name="orderFields[${status.index}].partNumber" value="${orderField.partNumber}"/></td>
                            <td><input name="orderFields[${status.index}].quantityString" value="${orderField.quantityString}"/></td>
                            <td><input name="orderFields[${status.index}].inPriceString" value="${orderField.inPriceString}"/></td>
                            <td><input name="orderFields[${status.index}].outPriceString" value="${orderField.outPriceString}"/></td>
                        </tr>
                    </c:forEach>

                </table>
                <button type="submit" name="createOrder" value="createOrder" class="btn btn-primary">Create</button>
            </form:form>
        </div>
    </div>
</div>