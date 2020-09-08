<%@ page import="models.user" %><%--
  Created by IntelliJ IDEA.
  User: Paul
  Date: 01-Sep-20
  Time: 4:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logare</title>
</head>
<body>

<center>
<form method="post" action="/war/log">
    <label for="user">user: </label>
    <input type="text" id="user" name="user" required="required" pattern="\S+">
    <br>
    <label for="parola">parola:</label>
    <input type="text" id="parola" name="parola" required="required" pattern="\S+">
    <br>
    <input type="submit" value="Buton">
</form>
<%
    if(request.getAttribute("user")!=null) {
        user U= (user)request.getAttribute("user");
        request.getRequestDispatcher("paginaUser.jsp").forward(request,response);
    }
    else if (request.getAttribute("return")=="1")
        out.print("Combinatia user-parola este gresita sau userul nu exista");
%>
</center>
</body>
</html>
