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
    <legend>Delete product</legend>
    <table>
      <tr>
        <td>Tên sản phẩm:</td>
        <td>${requestScope.product.getNameProduct()}</td>
      </tr>
      <tr>
        <td>Mô tả sản phẩm</td>
        <td>${requestScope.product.getDescription()}</td>
      </tr>
      <tr>
        <td>Giá sản phẩm:</td>
        <td>${requestScope.product.getPrice()}</td>
      </tr>
      <tr>
        <td>Phân loại:</td>
        <td>
          <select name="categories">
            <c:forEach items="${requestScope.categories}" var="cate">
              <option value="${cate.getIdCategory()}"
                      <c:if test="${cate.getIdCategory() == requestScope.product.getIdCategory()}">selected</c:if>
              >${cate.getNameCategory()}
              </option>
            </c:forEach>
          </select>
        </td>
      </tr>
      <tr>
        <td><input type="submit" value="Delete"></td>
        <td><a href="/productServlet">Come back list product</a></td>
      </tr>
    </table>
  </fieldset>
</form>
</body>
</html>