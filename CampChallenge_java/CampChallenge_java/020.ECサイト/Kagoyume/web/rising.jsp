<%-- 
    Document   : rising
    Created on : 2018/09/09, 18:51:41
    Author     : stsno
--%>
<%
    HttpSession hs = request.getSession();
    String url = "/top.jsp";
    if(hs.getAttribute("lastPage") != null){
        url = (String)hs.getAttribute("lastPage");
        if(hs.getAttribute("lastPageQuery")!=null){
            url += String.valueOf(hs.getAttribute("lastPageQuery"));
        }
    }
    
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <meta http-equiv="refresh" content="0;URL=<%=url%>">
    </body>
</html>
