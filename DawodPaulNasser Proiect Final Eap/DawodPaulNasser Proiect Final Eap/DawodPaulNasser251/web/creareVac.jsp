<%@ page import="java.sql.Connection" %>
<%@ page import="utils.DbConnection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="repository.locatiiRepository" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="models.locatii" %><%--
  Created by IntelliJ IDEA.
  User: Paul
  Date: 04-Sep-20
  Time: 4:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adaugare Vacanta</title>
</head>
<body>
<center>

    <form method="post" onsubmit="return VerificareData()">
        <label for="idLoc">Alege o locatie:</label>
        <select id="idLoc" name="idLoc">
            <%
                ArrayList<locatii> loc= locatiiRepository.ToateLocatiile();
                for (int i = 0; i < loc.size(); i++) {
                    out.println("<option value=\""+loc.get(i).getIdLocatii()+"\">"+loc.get(i).getNume()+"</option>");
                }
            %>
        </select>
        <br>
        <label for="dataStrt">Data Start:</label>
        <input type="date" id="dataStrt" name="dataStrt" required="required">
        <br>
         <label for="dataStop">Data Final:</label>
         <input type="date" id="dataStop" name="dataStop" required="required">
        <br>
        <label for="bani">Bani General:</label>
        <input type="text" id="bani" name="bani" value="0">
        <br>
          <input type="submit">
</form>

    <p id="demo"></p>
<script>
    function Test()
    {
        alert("hello");
        return false;
    }

    function VerificareData()
    {
        const date_st = document.getElementById('dataStrt');
        const date_sf = document.getElementById('dataStop');



        alert(date_st.getMonth());
        if(new Date().getVarDate<18)
        {
            alert("mic");
            return false;
        }
        else if(date_st.getTime()<date_sf.getTime)
        {
            alert("mare");
          return true;
        }
        else if(date_st.getTime()===date_sf.valueOf())
        {
            alert("egal");
            return true;
        }
        else
        {
            alert("nicuna");
        return  false;
        }
    }

</script>
</center>
</body>
</html>
