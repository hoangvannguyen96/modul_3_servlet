<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new customer</title>
    <style>
        .message {
            color: green;
        }
    </style>
</head>
<body>
<h1>Create new customer</h1>
<p>
    <a href="/customers">Back to customer list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Customer information</legend>
        <c:if test="${requestScope.errors != null}">
            <div class="alert alert-danger text-center">
                <ul>
                    <c:forEach items="${requestScope.errors}" var="error">
                        <li>${error}</li>
                    </c:forEach>
                </ul>
            </div>
        </c:if>
        <c:if test='${requestScope["message"] != null}'>
            <div class="alert alert-success text-center">
                <span class="message">${requestScope["message"]}</span>
            </div>
        </c:if>
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" value="${requestScope.customer.getName()}"></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="text" name="email" value="${requestScope.customer.getEmail()}"></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><input type="text" name="address" value="${requestScope.customer.getAddress()}"></td>
            </tr>
            <tr>
                <td>Customer Type</td>
                <td>
                    <select name="customerTypes">
                        <c:forEach items="${requestScope.customerTypes}" var="ct">
                            <option value="${ct.getIdType()}">${ct.getNameType()}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <button type="submit" value="Create customer">Create customer</button>
                </td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>