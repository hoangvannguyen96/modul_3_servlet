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
<a href="/userServlet">Come back list user</a>
<form method="post">
    <fieldset style="width: 300px">
        <legend>Edit product</legend>
        <table>
            <tr>
                <td>FullName</td>
                <td><input type="text" name="fullName" placeholder="FullName"
                           value="${requestScope.user.getFullName()}"></td>
            </tr>
            <tr>
                <td>Address</td>
                <td><input type="text" name="address" placeholder="Address" value="${requestScope.user.getAddress()}">
                </td>
            </tr>
            <tr>
                <td>Date of birth</td>
                <td><input type="text" name="dob" placeholder="Date of birth" value="${requestScope.user.getDob()}">
                </td>
            </tr>
            <tr>
                <td>Access rights</td>
                <td>
                    <select name="role">
                        <c:forEach items="${requestScope.roles}" var="role">
                            <option value="${role}"
                                    <c:if test="${requestScope.user.getRole()==role}">selected</c:if>
                            >${role}</option>
                        </c:forEach>
                    </select>
                </td>
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