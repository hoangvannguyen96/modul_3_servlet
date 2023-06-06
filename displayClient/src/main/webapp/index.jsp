<%@ page import="java.util.List" %>
<%@ page import="com.example.displayclient.Client" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
</head>
<body>
<h1 class="text-center"><%= "DANH SÁCH KHÁCH HÀNG" %>
</h1>
<br/>
<form>
    <%
        List<Client> clients = new ArrayList<>();
    clients.add(new Client("Mai Văn Hoàn","20/08/83","Hà Nội","https://media-cdn-v2.laodong.vn/Storage/NewsPortal/2020/8/17/828712/Lay-Danh-Nghia-Nguoi-05.jpg"));
    clients.add(new Client("Nguyễn Văn Nam","20/08/83","Hà Nội","https://media-cdn-v2.laodong.vn/Storage/NewsPortal/2020/8/17/828712/Lay-Danh-Nghia-Nguoi-05.jpg"));
    %>
    <table class="table">
        <tr>
            <th>Tên</th>
            <th>Ngày Sinh</th>
            <th>Địa chỉ</th>
            <th>Ảnh</th>
        </tr>
        <%  for (Client client : clients){%>
        <tr>
            <td><%=client.getName()%></td>
            <td><%=client.getDate()%></td>
            <td><%=client.getAddress()%></td>
            <td>
                <img style="width: 50px; height: 50px" src="<%=client.getImg()%>">
            </td>
        </tr>
        <%} %>
    </table>
</form>
</body>
</html>