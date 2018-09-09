<%-- 
    Document   : registration
    Created on : 2018/07/13, 11:26:49
    Author     : stsno
--%>

<%@page import="kagoyume.UserData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession hs = request.getSession();
    UserData ud = new UserData();
    if(hs.getAttribute("formUserData") != null){
        ud = (UserData)hs.getAttribute("formUserData");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>会員登録 - 入力画面</title>
    </head>
    <body>
        会員登録 - 入力画面
        <form action="Registrationconfirm" method="get">
            ユーザー名　<input type="text" name="name" value="<%=ud.getName()%>"><br>
            パスワード　<input type="password" name="password" value="<%=ud.getPassword()%>"><br>
            メールアドレス　<input type="text" name="mail" value="<%=ud.getMail()%>"><br>
            住所　<input type="text" name="address" value="<%=ud.getAddress()%>"><br>
            <input type="submit" name="submit" value="登録">
        </form>
    </body>
</html>
