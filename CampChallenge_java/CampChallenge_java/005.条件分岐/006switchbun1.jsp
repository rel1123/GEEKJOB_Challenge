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
            int nam = 3;
            switch(nam){
                case 1 :
                    out.print("one");
                    break;                    
                case 2 :
                    out.print("two");
                    break;
                default:
                    out.print("想定外");
            }
        %>
    </body>
</html>
