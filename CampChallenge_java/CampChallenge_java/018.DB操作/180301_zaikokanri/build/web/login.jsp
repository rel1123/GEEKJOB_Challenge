<%-- 
    Document   : login
    Created on : 2018/06/15, 11:58:53
    Author     : stsno
--%>
<%@page import="newpackage.ResultData"%>
<%@page import="newpackage.ResultData.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    boolean bo1 = false;
    String loginLog = null;
    
    ResultData data = (ResultData)request.getAttribute("DATA");
    try{
        loginLog = data.getLoginLog();
        bo1 = true;
    }catch(Exception e){
        out.print("初回アクセス<br>");
    }
%>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p>在庫管理システムログイン画面</p>
        <%
            if(bo1){
                out.print(loginLog+"<br>");
            }
        %>
        <form action="/180301_zaikokanri/LoginSarvlet" method="post">
            ユーザーID：<input type="text" name="userID"><br>
            パスワード：<input type="password" name="password"><br>
            <input type="submit" name="loginsubmit" value="ログイン"><br>
        </form>
    </body>
</html>

