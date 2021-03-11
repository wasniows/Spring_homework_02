<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <tr>
        <th>Name</th>
        <th>Value</th>
    </tr>
    <tr>
        <c:forEach var="item" items="${cookies}">
    <tr>
        <td>${item.getName()} </td>
        <td>${item.getValue()}</td>

    </tr>
    </c:forEach>

</table>
<br><br>
<table>
    <tr>
        <th>Name</th>
        <th>Value</th>
    </tr>
    <tr>
        <c:forEach var="item" items="${cookieList}">
    <tr>
        <td>${item.getName()} </td>
        <td>${item.getValue()}</td>

    </tr>
    </c:forEach>

</table>



</body>
</html>
