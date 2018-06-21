<%-- 
    Document   : errorbr8JSP
    Created on : 2018/06/13, 14:36:06
    Author     : stsno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    //変数
    String sName = null;
    
    
    
    //受け取るパラメータの文字コード
    request.setCharacterEncoding("UTF-8");
    //受け取った情報を格納
    sName = request.getParameter("name");
    if(sName != null){
        System.out.print("受け取った情報："+sName);
    }
    
%>



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
    </body>
</html>
