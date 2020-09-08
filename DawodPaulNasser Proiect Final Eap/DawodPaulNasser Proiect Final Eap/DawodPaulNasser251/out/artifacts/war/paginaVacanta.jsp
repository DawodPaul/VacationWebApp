<%@ page import="models.vacante" %>
<%@ page import="repository.vacanteRepository" %>
<%@ page import="models.vacUserFriendly" %>
<%@ page import="repository.rapoarteRepository" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="repository.atractiiRepository" %>
<%@ page import="java.sql.Array" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="models.atractii_user" %>
<%@ page import="models.atractii" %><%--
  Created by IntelliJ IDEA.
  User: Paul
  Date: 04-Sep-20
  Time: 9:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pagina Vacanta</title>
</head>
<link rel="stylesheet" type="text/css" href="style.css">
<body>
<center>
<%
    if(request.getAttribute("id_v")!=null) {
        Integer i = (Integer) request.getAttribute("id_v");
        vacante Vac = null;
        vacUserFriendly vuf = null;
        try {
            vuf = rapoarteRepository.friendlyVacation(i);
            assert vuf != null;
            out.println("Locatie:" + vuf.getNume());
            out.print("<br>");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            Vac = vacanteRepository.getVac(i);
            out.println("Data Start:" + Vac.getData_St());  out.print("<br>");
            out.println("Data Final:" + Vac.getData_Sf());  out.print("<br>");
            out.println("Bani General:" + Vac.getBaniV());  out.print("<br>");
            Cookie cookieU = new Cookie("idV", Vac.getIdVacante().toString());
            response.addCookie(cookieU);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    else
    {
        Cookie[] cookies = request.getCookies();
        int i = -1;
        for (int j = 0; j < cookies.length; j++) {
            if (cookies[j].getName().equals("idV")) {
                i = Integer.parseInt(cookies[j].getValue());
            }
        }
        vacante Vac = null;
        vacUserFriendly vuf = null;
        try {
            vuf = rapoarteRepository.friendlyVacation(i);
            assert vuf != null;
            out.println("Locatie:" + vuf.getNume());
            out.print("<br>");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            Vac = vacanteRepository.getVac(i);
            assert Vac != null;
            out.println("Data Start:" + Vac.getData_St());  out.print("<br>");
            out.println("Data Final:" + Vac.getData_Sf());  out.print("<br>");
            out.println("Bani General:" + Vac.getBaniV());  out.print("<br>");
            Cookie cookieU = new Cookie("idV", Vac.getIdVacante().toString());
            response.addCookie(cookieU);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

%>
    <button onclick="vizAtr()">Atractii Vizitate</button> <br>
    <div id="atVac">
       <%
           Cookie[] cookies = request.getCookies();
           int i = -1;
           for (int j = 0; j < cookies.length; j++) {
               if (cookies[j].getName().equals("idV")) {
                   i = Integer.parseInt(cookies[j].getValue());
               }}
           ArrayList<atractii_user> atractiiU = null;
           try {
               atractiiU = atractiiRepository.listaAtractiiByVac(i);
               if(atractiiU.size()==0) {
                   out.print("Nu ai vizitat atractii!");
               }
               else {
                   for (int k = 0; k < atractiiU.size(); k++) {
                       out.print(atractiiU.get(k).toString());
                       out.print("<br>");
                   }
               }
           } catch (SQLException throwables) {
               throwables.printStackTrace();
           }



       %>

    </div>
    <button onclick="addAtr()">Adaugare Atractie</button> <br>
    <div id="adAtr">
        <form method="post" action="/war/adUsAtr" >
            <label for="idAtr">Alege o atractie:</label>
            <select id="idAtr" name="idAtr">
                <%
                    for (int j = 0; j < cookies.length; j++) {
                        if (cookies[j].getName().equals("idV")) {
                            i = Integer.parseInt(cookies[j].getValue());
                        }
                    }
                    try {
                        vacante tempV= vacanteRepository.getVac(i);
                        try {
                            assert tempV != null;
                            ArrayList<atractii> atr= atractiiRepository.atractiiByLoc(tempV.getID_L());
                            for (int o = 0; o < atr.size(); o++) {
                                out.println("<option value=\""+atr.get(o).getIdAtractii()+"\">"+atr.get(o).getNumeAtractie()+"</option>");
                            }
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }



                %>
            </select>
            <br>
            <label for="bani">Bani Cheltuiti la atractie:</label>
            <input type="text" id="bani" name="bani" value="0">
            <br>
            <div class="rate" style="text-align: center;">

            <input type="radio" id="star1" name="rate" value="1" />
            <label for="star1" title="text">1 star</label>
            <input type="radio" id="star2" name="rate" value="2" />
            <label for="star2" title="text">2 stars</label>
            <input type="radio" id="star3" name="rate" value="3" />
            <label for="star3" title="text">3 stars</label>
            <input type="radio" id="star4" name="rate" value="4" />
            <label for="star4" title="text">4 stars</label>
            <input type="radio" id="star5" name="rate" value="5" />
            <label for="star5" title="text">5 stars</label>
            </div>
            <br>
            <label for="com">Comments</label><br>
            <input type="text" id="com" name="com" value="  "> <br>
            <input type="submit">

        </form>
    </div>
    <button onclick="Update()">Update Vacanta</button>
    <div id="upVac">
        <h5>Update</h5>
        <form method="post" action="/war/updateVacanta">

            <br>
            <%
                if(request.getAttribute("id_v")!=null) {
                    Integer m = (Integer) request.getAttribute("id_v");
                    vacante Vac = null;
                    vacUserFriendly vuf = null;
                    try {
                        vuf = rapoarteRepository.friendlyVacation(m);
                        assert vuf != null;
                        out.println("Locatie:" + vuf.getNume());
                        out.print("<br>");
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    try {
                        Vac = vacanteRepository.getVac(m);
                        out.print(" <label for=\"dataStrt\">Data Start:</label>");
                        assert Vac != null;
                        out.print(" <input type=\"date\" id=\"dataStrt\" name=\"dataStrt\" required=\"required\" value=" + Vac.getData_St() + ">");
                        out.print("<br>");
                        out.print(" <label for=\"dataStop\">Data Start:</label>");
                        out.print(" <input type=\"date\" id=\"dataStop\" name=\"dataStop\" required=\"required\" value=" + Vac.getData_Sf() + ">");
                        out.print("<br>");
                        out.print("<label for=\"bani\">Bani General:</label>");
                        out.print(" <input type=\"text\" id=\"bani\" name=\"bani\" value=\"" + Vac.getBaniV() + "\">");
                        out.print("<br>");
                        out.print("<input type=\"submit\">");


                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
                else {
                    Cookie[] cookies2 = request.getCookies();
                    int l = -1;
                    for (int j = 0; j < cookies2.length; j++) {
                        if (cookies2[j].getName().equals("idV")) {
                            l = Integer.parseInt(cookies[j].getValue());
                        }
                    }

                    vacante Vac = null;
                    vacUserFriendly vuf = null;
                    try {
                        vuf = rapoarteRepository.friendlyVacation(l);
                        assert vuf != null;
                        out.println("Locatie:" + vuf.getNume());
                        out.print("<br>");
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    try {
                        Vac = vacanteRepository.getVac(i);
                        out.print(" <label for=\"dataStrt\">Data Start:</label>");
                        assert Vac != null;
                        out.print(" <input type=\"date\" id=\"dataStrt\" name=\"dataStrt\" required=\"required\" value=" + Vac.getData_St() + ">");
                        out.print("<br>");
                        out.print(" <label for=\"dataStop\">Data Start:</label>");
                        out.print(" <input type=\"date\" id=\"dataStop\" name=\"dataStop\" required=\"required\" value=" + Vac.getData_Sf() + ">");
                        out.print("<br>");
                        out.print("<label for=\"bani\">Bani General:</label>");
                        out.print(" <input type=\"text\" id=\"bani\" name=\"bani\" value=\"" + Vac.getBaniV() + "\">");
                        out.print("<br>");
                        out.print("<input type=\"submit\">");


                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }

            %>

        </form>
        <script>

            var x=document.getElementById("upVac")
            x.style.display="none"
             x=document.getElementById("adAtr")
            x.style.display="none"
            x=document.getElementById("atVac")
            x.style.display="none"
        </script>
        <script>
            document.getElementById('com').style.height="60px";
            document.getElementById('textboxid').style.fontSize="10pt";
        </script>
    </div>
        <form method="post" action="/war/deleteVac">
            <button type="submit" onclick="myFunction()">Stergere Vacanta</button>
        </form>


    <script>
        function myFunction() {
            Alert("Ai sters vacanta!");

        }
        function Update()
        {
            var x=document.getElementById("upVac");
            if(x.style.display==="none")
            {
            x.style.display="block";
            }
            else
            {
                x.style.display="none";
            }
        }
        function addAtr()
        {
            var x=document.getElementById("adAtr");
            if(x.style.display==="none")
            {
                x.style.display="block";
            }
            else
            {
                x.style.display="none";
            }
        }
        function vizAtr()
        {
            var x=document.getElementById("atVac");
            if(x.style.display==="none")
            {
                x.style.display="block";
            }
            else
            {
                x.style.display="none";
            }
        }
    </script>

</center>
</body>
</html>
