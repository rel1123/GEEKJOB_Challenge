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
            String data1 = "";
            for(int i = 0; i < 30; i++){
                data1 += "A";
            }
            out.print(data1);
        %>
    </body>
</html>
