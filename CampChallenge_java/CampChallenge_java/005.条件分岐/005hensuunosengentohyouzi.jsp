<%-- 
    Document   : 004hensuunosengentohyouzi
    Created on : 2018/05/11, 16:03:37
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
            int NUM = 1;
            
            if(NUM == 1){
                out.print("１です！");
            } else if(NUM == 2) {
                out.print("プログラミングキャンプ！");
            } else
                out.print("その他です！");
        %>
    </body>
</html>
