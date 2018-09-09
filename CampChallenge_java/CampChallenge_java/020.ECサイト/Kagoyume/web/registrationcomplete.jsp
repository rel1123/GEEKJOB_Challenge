<%-- 
    Document   : registrationcomplete
    Created on : 2018/07/13, 11:27:45
    Author     : stsno
--%>
<%@page import="kagoyume.Helper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kagoyume.UserData"%>
<%
    HttpSession hs = request.getSession();
    UserData ud = (UserData)hs.getAttribute("formUserData");
    Helper hp = new Helper();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            <h1>登録確認</h1><br>
            ユーザー名：<%= ud.getName()%><br>
            パスワード：<%= ud.getPassword()%><br>
            メールアドレス：<%= ud.getMail()%><br>
            住所：<%= ud.getAddress()%><br>
            以上の内容で登録しました。
        <form action="top.jsp" method="POST">
                <input type="submit" name="top" value="トップページへ戻る">
            </form>
    </body>
</html>
