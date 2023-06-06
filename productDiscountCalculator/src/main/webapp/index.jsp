<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<head>
    <title>Simple Dictionary</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h2>Product Discount Calculator</h2>
<form action="productDiscountCalculator" method="post">
    <p>Description product</p>
    <input type="text" name="description" placeholder="Enter your description"/>
    <br>
    <p>Price product</p>
    <input type = "text" placeholder="Giá sản phẩm" name="price"/>
    <br>
    <p>Discount</p>
    <input type = "text" placeholder="% chiết khấu" name="Discount"/>
    <br>
    <br>
    <input type = "submit" id = "submit" value = "Tính toán"/>
</form>
</body>
</html>