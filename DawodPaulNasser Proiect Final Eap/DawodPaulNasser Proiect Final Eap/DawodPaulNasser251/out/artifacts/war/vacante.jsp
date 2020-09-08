<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="models.vacante" %><%--
  Created by IntelliJ IDEA.
  User: Paul
  Date: 02-Sep-20
  Time: 7:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pagina Vacante</title>
</head>
<body>
<%
    Cookie killMyCookie = new Cookie("idV", null);
    killMyCookie.setMaxAge(0);
    killMyCookie.setPath("/war");
    response.addCookie(killMyCookie);
%>
<center>
    <br>
    <br>
    <br>
    <h3> Adaugare vacante </h3>
    <form method="post" action="/war/creareVac.jsp">
<button>Adauga Vacanta</button>
    </form>

<%
    ArrayList<vacante> resultSet= (ArrayList<vacante>) request.getAttribute("listVac");

    if(resultSet.size()!=0) {
        out.print("<h3>Istoricul Vacantelor</h3>");
        out.print("<form method = \"post\" action=\"/war/tempVac\" id=\"sub\">");

        for (int i = 0; i < resultSet.size(); i++) {
            out.print("<button name=\"idVT\" type=\"submit\" value=\""+resultSet.get(i).getIdVacante()+"\">" + resultSet.get(i).getIdVacante() + " " + resultSet.get(i).getData_St() + "</button><br>");

        }

out.print("</form >");

    }
    else
    {
        out.print("Nu ai vacante inregistrate");
    }


%>
</center>
</body>
</html>
