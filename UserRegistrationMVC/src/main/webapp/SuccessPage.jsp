<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Success Page</title>
    <!-- Include Bootstrap CSS file -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        h1, h2 {
            text-align: center;
            color: orange;
        }
        table {
            width: 80% !important;
            margin: 20px auto;
        }
    </style>
</head>
<body>
    <h1>Welcome, ${sessionScope.firstName}!</h1>

    <h2>Order Details</h2>
    <table class="table table-striped">
        <thead>
            <tr>
                <th>Order ID</th>
                <th>Item Name</th>
                <th>Purchase Date</th>
                <th>Amount</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="order" items="${sessionScope.orderList}">
                <tr>
                    <td>${order.orderID}</td>
                    <td>${order.itemName}</td>
                    <td>${order.purchaseDate}</td>
                    <td>${order.amount}</td>
                </tr>
            </c:forEach>
            <c:if test="${empty sessionScope.orderList}">
                <tr>
                    <td colspan="4" class="text-center">No orders found.</td>
                </tr>
            </c:if>
        </tbody>
    </table>
</body>
</html>
