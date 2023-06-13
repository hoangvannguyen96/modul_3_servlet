<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Deleting customer</title>
</head>
<body>
<h1>Delete customer</h1>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <tr>
                <td>Name:</td>
                <td>${requestScope.customer.getName()}</td>
            </tr>
            <tr>
                <td>Email:</td>
                <td>${requestScope.customer.getEmail()}</td>
            </tr>
            <tr>
                <td>Address:</td>
                <td>${requestScope.customer.getAddress()}</td>
            </tr>
            <tr>
                <td>Customer Type:</td>
                <td>
                    <select name="customerTypes">
                        <c:forEach items="${requestScope.customerTypes}" var="ct">
                            <option
                                    <c:if test="${ct.getIdType() == requestScope.customer.getIdType()}">selected</c:if>
                                    value="${ct.getIdType()}">${ct.getNameType()}
                            </option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <button type="submit" value="Delete customer">Delete customer</button>
                </td>
                <td><a href="/customers">Back to customer list</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>