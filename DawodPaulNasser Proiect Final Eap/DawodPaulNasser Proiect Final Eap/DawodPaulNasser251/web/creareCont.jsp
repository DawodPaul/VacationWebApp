<%--
  Created by IntelliJ IDEA.
  User: Paul
  Date: 01-Sep-20
  Time: 1:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<center>
    <br>
    <br>
    <br>
    <form method="post" action="/war/creare">
        <label for="user">  user:</label>
        <input type="text" id="user" name="user" required="required" pattern="\S+">
        <br>
        <label for="parola">parola:</label>
        <input type="text" id="parola" name="parola" required="required" pattern="\S+">
        <br>
        <label for="nume">Nume: </label>
        <input type="text" id="nume" name="nume" required="required" pattern="\S+">
        <br>
        <label for="prenume">parola:</label>
        <input type="text" id="prenume" name="prenume" required="required" pattern="\S+">
        <br>
        <input type="submit" value="Creaza Contul">
    </form>
    <%
        if(request.getAttribute("mesajCreareCont")!=null)
        out.print((String)request.getAttribute("mesajCreareCont"));
        out.print("<form action=\"test.jsp\">\n" +
                "      <input type=\"submit\" value=\"Logare\">\n" +
                "\n" +
                "  </form>");
    %>

</center>
</body>
</html>
