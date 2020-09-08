<%--
  Created by IntelliJ IDEA.
  User: Paul
  Date: 31-Aug-20
  Time: 7:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>RapoarteUser</title>
</head>
<body>
<center>

    <button onclick="hideAll();myFunction()">Cea mai lunga vacanta</button><br><br>
    <button onclick="hideAll();myFunction2()">Cele mai multe atractii vizitate</button><br><br>
    <button onclick="hideAll();myFunction3()">Cea mai scumpa vacanta</button><br><br>

    <div id="rap">
        <%
            out.print(request.getAttribute("lungVac"));
        %>
        <script>
            var x = document.getElementById("rap");
            x.style.display = "none";
        </script>
    </div>
    <div id="rap2">
        <%
            if(request.getAttribute("multeAtrac")==null)
                out.print("Nu ai vizitat atractii");
            else
                out.print(request.getAttribute("multeAtrac"));
        %>
        <script>
            var y = document.getElementById("rap2");
            y.style.display = "none";
        </script>
    </div>

    <div id="rap3">
        <%
            if(request.getAttribute("scumpVac")!=null)
                out.print(request.getAttribute("scumpVac"));
            else
                out.print("Nu ai vacante");
        %>
        <script>
            var y = document.getElementById("rap3");
            y.style.display = "none";
        </script>
    </div>

    <script>
        function myFunction() {
            var x = document.getElementById("rap");
            if (x.style.display === "none") {
                x.style.display = "block";
            } else {
                x.style.display = "none";
            }
        }
        function myFunction2() {
            var y = document.getElementById("rap2");
            if (y.style.display === "none") {
                y.style.display = "block";
            } else {
                y.style.display = "none";
            }
        }
        function myFunction3() {
            var y = document.getElementById("rap3");
            if (y.style.display === "none") {
                y.style.display = "block";
            } else {
                y.style.display = "none";
            }
        }
        function hideAll()
        {
            var x = document.getElementById("rap");
            x.style.display="none";
            var x = document.getElementById("rap2");
            x.style.display="none";
            var x = document.getElementById("rap3");
            x.style.display="none";
        }
    </script>
</center>


</body>
</html>

