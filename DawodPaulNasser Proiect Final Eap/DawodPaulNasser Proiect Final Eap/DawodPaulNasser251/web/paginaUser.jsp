<%@ page import="models.user" %><%--
  Created by IntelliJ IDEA.
  User: Paul
  Date: 01-Sep-20
  Time: 4:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>paginaUser</title>
</head>

<body>
<%
    Cookie killMyCookie = new Cookie("idV", null);
    killMyCookie.setMaxAge(0);
    killMyCookie.setPath("/war");
    response.addCookie(killMyCookie);
%>
<div style="text-align: center;">
    <br>
    <br>

        <form method="post" action="/war/vacanta">
            <button >Vacante</button>
        </form>
        <form action="test.jsp">
            <button>abc</button>
        </form>
<form action="/war/rapoarte" method="post">
    <button>Rapoarte</button>
</form>

    <br><br>
    <button onclick="myFunction()">Stergere Cont</button>

    <script>
        function myFunction() {
            if(confirm("Esti sigur ca vrei sa stergi contul?"))
            {

                window.location.replace("/war/delete")

            }

        }
    </script>

</div>
</body>
</html>
