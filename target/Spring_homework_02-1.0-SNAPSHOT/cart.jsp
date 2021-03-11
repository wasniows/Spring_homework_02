<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>

    <style>
        table, th, td {
            border-collapse: collapse;
            border: solid grey 2px;
            font-size: x-large;
            padding: 6px;
        }

        th {
            background-color: #F2F2F2;
        }

        td {
            text-align: right;
        }

        a, form, input {
            font-size: xx-large;
        }
        .sum{
            border-collapse: unset;
        }
    </style>

</head>
<body>

<%! double sum = 0;%>
<table>
    <tr>
        <th>Produkt</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Amount</th>
    </tr>
    <tr>
        <c:forEach var="item" items='${sessionScope.cartItems}'>
    <tr>
        <td>${item.product.name}</td>
        <td>${item.product.price}</td>
        <td>${item.quantity}</td>
        <td>${item.product.price * item.quantity}</td>
        <td><a href="/update?quantity=1&name=${item.product.name}">+1</a></td>
        <td><a href="/update?quantity=-1&name=${item.product.name}">-1</a></td>
        <td><a href="/update?quantity=0&name=${item.product.name}">usuń</a></td>
    </tr>
    </c:forEach>
                <td><td></td><td class="sum">Total</td><td>${sessionScope.sum}</td>

</table>


<br>


<form method="post" action="/addtocart">
    <label>Product</label>
    <input type="text" name="name">
    <label>Price</label>
    <input type="number" step="0.01" name="price">
    <label>Quantity</label>
    <input type="number" name="quantity">
    <input type="submit" value="Dodaj do koszyka">
</form>

</body>
</html>
