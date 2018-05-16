<%-- 
    Document   : 010rensouhairetunosakusei
    Created on : 2018/05/16, 14:07:22
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
        <%@page import = "java.util.HashMap" %>
        <%
            //連想配列をHashMapで宣言
            HashMap<String,String>data1 =
                        new HashMap<String,String>();
            //data1にデータを格納
            data1.put("1","AAA");
            data1.put("hello", "world");
            data1.put("soeda", "33");
            data1.put("20", "20");
            
            //表示の練習
            //データを呼び出し表示
            out.print(data1.get("1"));
            out.print(data1.get("hello"));
            out.print(data1.get("soeda"));
            out.print(data1.get("20"));
            
        %>
    </body>
</html>
