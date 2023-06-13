<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<form method="post"></form>
<h1>Customers</h1>
<p>
    <a href="/customers?action=create">Create new customer</a>
</p>
<table>
    <tr>
        <td>Name</td>
        <td>Email</td>
        <td>Address</td>
        <td>Type</td>
        <td>Action</td>
    </tr>
    <c:forEach items='${requestScope.customers}' var="customer">
        <tr>
            <td><a href="/customers?action=view&id=${customer.getIdCustomer()}">${customer.getName()}</a></td>
            <td>${customer.getEmail()}</td>
            <td>${customer.getAddress()}</td>
            <td>${customer.getCustomerType().getNameType()}</td>
            <td><a href="/customers?action=edit&id=${customer.getIdCustomer()}">edit</a></td>
            <td><a href="/customers?action=delete&id=${customer.getIdCustomer()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>