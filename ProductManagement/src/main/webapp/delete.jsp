<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 07/06/2023
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<h3>Are you sure?</h3>
<form method="post">
    <fieldset style="width: 300px">
        <legend>Edit product</legend>
        <table>
            <tr>
                <td>Tên sản phẩm:</td>
                <td>${requestScope.product.getNameProduct()}</td>
            </tr>
            <tr>
                <td>Giá sản phẩm:</td>
                <td>${requestScope.product.getPriceProduct()}</td>
            </tr>
            <tr>
                <td>Mô tả sản phẩm</td>
                <td>${requestScope.product.getDescription()}</td>
            </tr>
            <tr>
                <td>Nhà sản xuất</td>
                <td>${requestScope.product.getProducer()}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Xóa"></td>
                <td><a href="/productManagerServlet">Come back list product</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
