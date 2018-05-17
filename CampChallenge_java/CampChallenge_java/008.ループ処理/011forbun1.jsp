<%-- 
    Document   : 011forbun1
    Created on : 2018/05/17, 11:42:59
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
            long nam = 1;
            for(int i = 0; i < 20; i++){
                nam *= 8;
            }
            out.print(nam);
        %>
    </body>
</html>
