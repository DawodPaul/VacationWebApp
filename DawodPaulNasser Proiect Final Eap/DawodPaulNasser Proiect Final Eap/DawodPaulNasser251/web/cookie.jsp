<%--
  Created by IntelliJ IDEA.
  User: Paul
  Date: 31-Aug-20
  Time: 9:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <meta http-equiv="refresh" >
</head>
<body>
<%
    Cookie cookie = null;
    Cookie[] cookies = null;

    // Get an array of Cookies associated with the this domain
    cookies = request.getCookies();

    if( cookies != null ) {
        out.println("<h2> Found Cookies Name and Value</h2>");

        for (int i = 0; i < cookies.length; i++) {
            cookie = cookies[i];
            out.print("Name : " + cookie.getName() + ",  ");
            out.print("Value: " + cookie.getValue( )+" <br/>");
        }
    } else {
        out.println("<h2>No cookies founds</h2>");
    }
%>
</body>
</body>
</html>
