<%-- 
    Document   : login
    Created on : 2018/07/13, 11:26:20
    Author     : stsno
--%>

<%
    HttpSession hs = request.getSession();
    String message = (String)request.getAttribute("message");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ログインページ</title>
    </head>
    <body>
        <h1>ログインページ</h1>
        <%if(message!=null){out.print(message+"<br>");}%>
        <form action="Login" method="post">
            ユーザー名　<input type="text" name="name" size="12"><br>
            パスワード　<input type="password" name="password" size="12"><br>
            <input type="hidden" name="loginType" value="loginTry">
            <input type="submit" name="loginTry" value="ログイン"><br>
        </form>
        <br>
        <form action="Registration" method="post">
            <input type="submit" name="registration" value="新規会員登録">
        </form>
    </body>
</html>
