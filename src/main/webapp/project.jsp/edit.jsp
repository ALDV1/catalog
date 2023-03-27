<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<h3>Edit product</h3>

<form method="post">
    <input type="hidden" value="${product.id}" name="id" />
    Name:<br>
    <input name="name" value="${product.name}"/><br><br>
    Price:<br>
    <input name="price" value="${product.price}" type="number" min="100"/> ${product.price} <br><br>
    <input type="submit" value="Send">
</form>
</body>
</html>
