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
<c:if test="${requestScope.message != null}">
    <h4>Cập nhật thành công</h4>
</c:if>
<a href="/productManagerServlet">Come back list product</a>
<form method="post">
    <fieldset style="width: 300px">
        <legend>Edit product</legend>
        <table>
            <tr>
                <td>Tên sản phẩm:</td>
                <td><input type="text" name="name" placeholder="Nhập tên sản phẩm" value="${requestScope.product.getNameProduct()}"></td>
            </tr>
            <tr>
                <td>Giá sản phẩm:</td>
                <td><input type="text" name="price" placeholder="Nhập giá sản phẩm" value="${requestScope.product.getPriceProduct()}"></td>
            </tr>
            <tr>
                <td>Mô tả sản phẩm</td>
                <td><input type="text" name="description" placeholder="Nhập mô tả" value="${requestScope.product.getDescription()}"></td>
            </tr>
            <tr>
                <td>Nhà sản xuất</td>
                <td><input type="text" name="producer" placeholder="Nhập nhà sản xuất" value="${requestScope.product.getProducer()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Cập nhật"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
