<%-- 
    Document   : 014whilebun
    Created on : 2018/05/18, 11:41:38
    Author     : stsno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            int nam = 1000;
            
            while(nam > 100){
                nam /= 2;
            }
            
            out.print(nam);
        %>
    </body>
</html>
