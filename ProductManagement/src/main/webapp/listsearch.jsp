<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 07/06/2023
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
</head>
<body>
<a href="/productManagerServlet">Come back list product</a>
<form method="post">
    <fieldset>
        <legend class="text-center">Thông tin sản phẩm</legend>
        <table class="table">
            <tr>
                <td>ID</td>
                <td>Name</td>
                <td>Price</td>
                <td>Description</td>
                <td>Producer</td>
            </tr>
            <c:forEach items="${requestScope.products}" var="product">
                <tr>
                    <td>${product.getId()}</td>
                    <td>${product.getNameProduct()}</td>
                    <td>${product.getPriceProduct()}</td>
                    <td>${product.getDescription()}</td>
                    <td>${product.getProducer()}</td>
                </tr>
            </c:forEach>
        </table>
    </fieldset>
</form>
</body>
</html>
