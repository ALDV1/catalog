<%--
  Created by IntelliJ IDEA.
  User: Alexader_Dulskiy
  Date: 22.03.2023
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP</title>
</head>
<body>
    <p>User name: <%=request.getParameter("username")%></p>
    <p>User password: <%=request.getParameter("psw")%></p>
</body>
</html>
