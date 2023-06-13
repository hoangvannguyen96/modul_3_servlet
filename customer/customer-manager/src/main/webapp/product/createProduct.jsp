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
<a href="/productServlet">Come back list product</a>
<form method="post">
    <fieldset style="width: 300px">
        <legend>Add product</legend>
        <table>
            <tr>
                <td>Tên sản phẩm:</td>
                <td><input type="text" name="nameProduct" placeholder="Nhập tên sản phẩm" value="${requestScope.product.getNameProduct()}"></td>
            </tr>
            <tr>
                <td>Mô tả sản phẩm</td>
                <td><input type="text" name="description" placeholder="Nhập mô tả" value="${requestScope.product.getDescription()}"></td>
            </tr>
            <tr>
                <td>Giá sản phẩm:</td>
                <td><input type="text" name="price" placeholder="Nhập giá sản phẩm" value="${requestScope.product.getPrice()}"></td>
            </tr>
            <tr>
                <td>Phân loại:</td>
                <td>
                    <select name="categories">
                        <c:forEach items="${requestScope.categories}" var="cate">
                            <option value="${cate.getIdCategory()}">${cate.getNameCategory()}</option>
                        </c:forEach>
                    </select>
                </td>
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