<%-- 
    Document   : myupdateresult
    Created on : 2018/09/10, 4:24:08
    Author     : stsno
--%>

<%@page import="kagoyume.UserData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    UserData ud = (UserData)request.getAttribute("resultData");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>会員情報 - 更新完了画面</h1><br>
        ユーザー名：<%= ud.getName()%><br>
        パスワード：<%= ud.getPassword()%><br>
        メールアドレス：<%= ud.getMail()%><br>
        住所：<%= ud.getAddress()%><br>
        以上の内容で更新しました。<br>
        
        <form action="top.jsp" method="POST">
            <input type="submit" name="top" value="トップページへ戻る">
        </form>
    </body>
</html>
