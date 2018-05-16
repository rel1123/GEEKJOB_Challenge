<%-- 
    Document   : 008hairetunosakusei
    Created on : 2018/05/16, 13:00:45
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
        <%@ page import="java.util.ArrayList" %>
        <%
            //ArrayList型変数宣言
            ArrayList<String> st1 = new ArrayList();
            //要素の格納
            st1.add("10");
            st1.add("100");
            st1.add("soeda");
            st1.add("hayashi");
            st1.add("-20");
            st1.add("118");
            st1.add("END");
            //要素の表示
            out.print(st1.get(0));
            out.print(st1.get(1));
            out.print(st1.get(2));
            out.print(st1.get(3));
            out.print(st1.get(4));
            out.print(st1.get(5));
            out.print(st1.get(6));
            
            
            
            
 

            
            
            
            
        %>
    </body>
</html>
