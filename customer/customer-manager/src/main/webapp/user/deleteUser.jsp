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
    <legend>Delete user</legend>
    <table>
      <tr>
        <td>FullName</td>
        <td>${requestScope.user.getFullName()}</td>
      </tr>
      <tr>
        <td>Address</td>
        <td>${requestScope.user.getAddress()}</td>
      </tr>
      <tr>
        <td>Date of birth</td>
        <td>${requestScope.user.getDob()}</td>
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
        <td><input type="submit" value="Delete"></td>
        <td><a href="/userServlet">Come back list user</a></td>
      </tr>
    </table>
  </fieldset>
</form>
</body>
</html>