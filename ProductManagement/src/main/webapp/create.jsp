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
    <title>Title</title>
</head>
<body>
<c:if test="${requestScope.message != null}">
    <h4>Thêm thành công</h4>
</c:if>
<a href="/productManagerServlet">Come back list product</a>
<form method="post">
    <fieldset style="width: 300px">
        <legend>Add product</legend>
        <table>
            <tr>
                <td>Tên sản phẩm:</td>
                <td><input type="text" name="name" placeholder="Nhập tên sản phẩm"></td>
            </tr>
            <tr>
                <td>Giá sản phẩm:</td>
                <td><input type="text" name="price" placeholder="Nhập giá sản phẩm"></td>
            </tr>
            <tr>
                <td>Mô tả sản phẩm</td>
                <td><input type="text" name="description" placeholder="Nhập mô tả"></td>
            </tr>
            <tr>
                <td>Nhà sản xuất</td>
                <td><input type="text" name="producer" placeholder="Nhập nhà sản xuất"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Thêm mới"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>