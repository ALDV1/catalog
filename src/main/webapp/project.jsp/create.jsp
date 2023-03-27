<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Product</title>
</head>
<body>
    <h3>New product</h3>
<form method="post" >
    Name:<br>
    <input name="name" /><br><br>
    Price:<br>
    <input name="price" type="number" min="100" /> <br><br>
    <input type="submit" value="Save" />
</form>
</body>
</html>
