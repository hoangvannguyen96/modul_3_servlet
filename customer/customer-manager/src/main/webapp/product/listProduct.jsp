<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
</head>
<body>
<form method="post"></form>
<a href="/productServlet?action=createProduct" class="btn btn-success">Add product</a>
<fieldset>
    <legend class="text-center">Thông tin sản phẩm</legend>
    <table class="table">
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Description</td>
            <td>Price</td>
            <td>Category</td>
            <td>Action</td>
        </tr>
        <c:forEach items="${requestScope.products}" var="product">
            <tr>
                <td>${product.getIdProduct()}</td>
                <td>${product.getNameProduct()}</td>
                <td>${product.getDescription()}</td>
                <td>${product.getPrice()}</td>
                <td>${product.getCategory().getNameCategory()}</td>
                <td>
                    <a href="/productServlet?action=editProduct&id=${product.getIdProduct()}" class="btn btn-primary">Edit</a>
                    <a href="/productServlet?action=deleteProduct&id=${product.getIdProduct()}" class="btn btn-danger">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</fieldset>
</body>
</html>