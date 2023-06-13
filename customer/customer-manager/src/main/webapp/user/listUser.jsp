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
<a href="/userServlet?action=createUser" class="btn btn-success">Add user</a>
<fieldset>
    <legend class="text-center">Thông tin sản phẩm</legend>
    <table class="table">
        <tr>
            <td>ID</td>
            <td>FullName</td>
            <td>Address</td>
            <td>Date of birth</td>
            <td>Access rights</td>
            <td>Action</td>
        </tr>
        <c:forEach items="${requestScope.users}" var="user">
            <tr>
                <td>${user.getIdUser()}</td>
                <td>${user.getFullName()}</td>
                <td>${user.getAddress()}</td>
                <td>${user.getDob()}</td>
                <td>${user.getRole()}</td>
                <td>
                    <a href="/userServlet?action=editUser&id=${user.getIdUser()}" class="btn btn-primary">Edit</a>
                    <a href="/userServlet?action=deleteUser&id=${user.getIdUser()}" class="btn btn-danger">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</fieldset>
</body>
</html>