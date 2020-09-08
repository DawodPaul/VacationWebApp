<%--
  Created by IntelliJ IDEA.
  User: Paul
  Date: 01-Sep-20
  Time: 12:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pagina Principala</title>
</head>
<body>
<%
    Cookie killMyCookie = new Cookie("idU", null);
    killMyCookie.setMaxAge(0);
    killMyCookie.setPath("/war");
    response.addCookie(killMyCookie);
%>
<center>
    <br>
    <br>
  Cea mai nou aplicatie de Vacanta de pe piata
    <br>
    <br>
    <br>
  <form action="logare.jsp">
      <input type="submit" value="Logare">

  </form>
    <form action="creareCont.jsp">
        <input type="submit" value="Creare Cont">
    </form>
</center>
</body>
</html>
