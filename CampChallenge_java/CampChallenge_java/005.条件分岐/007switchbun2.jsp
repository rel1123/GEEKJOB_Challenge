<%-- 
    Document   : 006 switchbun1
    Created on : 2018/05/11, 17:19:10
    Author     : guest1Day
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
            char  gengo = 'あ';
            switch(gengo){
                case 'a':
                    out.print("英語");
                    break;
                case 'あ':
                    out.print("日本語");
                    break;
            }
            
            
        %>
    </body>
</html>
