<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Success Page</title>
    <style>
        table {
            border-collapse: collapse;
            width: 80%;
            margin: 20px auto;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h1>Welcome <%= session.getAttribute("userName") %>!</h1>

    <h2> Orders:</h2>
    <table>
        <thead>
            <tr>
                <th>Order ID</th>
                <th>Item Name</th>
                <th>Purchase Date</th>
                <th>Amount</th>
            </tr>
        </thead>
        <tbody>
        <% 
            Object ordersObj = session.getAttribute("orders");
            if (ordersObj instanceof java.util.List) {
                java.util.List<?> orders = (java.util.List<?>) ordersObj;
                if (!orders.isEmpty()) {
                    for (Object orderObj : orders) {
                        if (orderObj instanceof String[]) {
                            String[] order = (String[]) orderObj;
        %>
            <tr>
                <td><%= order[0] %></td>
                <td><%= order[1] %></td>
                <td><%= order[2] %></td>
                <td><%= order[3] %></td>
            </tr>
        <% 
                        }
                    }
                } else { 
        %>
            <tr>
                <td colspan="4">No orders found.</td>
            </tr>
        <% 
                }
            } else { 
        %>
            <tr>
                <td colspan="4">No orders found.</td>
            </tr>
        <% 
            }
        %>
        </tbody>
    </table>
</body>
</html>
