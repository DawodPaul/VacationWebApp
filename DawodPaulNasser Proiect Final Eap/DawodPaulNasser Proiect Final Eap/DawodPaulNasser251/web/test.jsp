<%--
  Created by IntelliJ IDEA.
  User: Paul
  Date: 31-Aug-20
  Time: 6:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" action="/war/log">
    <label for="user">user: </label>
    <input type="text" id="user" name="user">
    <br>
    <label for="parola">parola:</label>
    <input type="text" id="parola" name="parola">
    <br>
    <input type="submit" value="Buton">
</form>
<%
    Cookie[] totalCookies=request.getCookies();
    for (int i = 0; i < totalCookies.length ; i++) {
        if(totalCookies[i].getName()=="idU")
        {
            int id_u=Integer.parseInt(totalCookies[i].getValue());
            out.print("id_user="+id_u);
        }
    }
%>
</body>
</html>
