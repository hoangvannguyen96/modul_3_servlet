<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h2>SIMPLE CALCULATOR</h2>
<form action="calculator" method="post">
    <fieldset style="width:300px">
        <legend><h3>CALCULATOR</h3></legend>
        <table>
            <tr>
                <td><h4>First operand</h4></td>
                <td><input type="text" name="num1" placeholder="Nhập số thứ nhất"></td>
            </tr>
            <tr>
                <td><h4>Operater</h4></td>
                <td><select name="operator">
                    <option value="+">Add</option>
                    <option value="-">Sub</option>
                    <option value="*">Mul</option>
                    <option value="/">Div</option>
                </select>
                </td>
            </tr>
            <tr>
                <td><h4>Second operand</h4></td>
                <td><input type="text" name="num2" placeholder="Nhập số thứ hai"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Caculate"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>