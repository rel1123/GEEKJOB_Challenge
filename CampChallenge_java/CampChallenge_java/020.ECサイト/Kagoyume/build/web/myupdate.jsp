<%-- 
    Document   : myupdate
    Created on : 2018/09/10, 4:23:53
    Author     : stsno
--%>

<%@page import="kagoyume.UserDataDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession hs = request.getSession();
    UserDataDTO udd = (UserDataDTO)hs.getAttribute("loginUserData");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        会員情報 - 変更画面
        <form action="Myupdateresult" method="get">
            ユーザー名　<input type="text" name="name" value="<%=udd.getName()%>"><br>
            パスワード　<input type="password" name="password" value="<%=udd.getPassword()%>"><br>
            メールアドレス　<input type="text" name="mail" value="<%=udd.getMail()%>"><br>
            住所　<input type="text" name="address" value="<%=udd.getAddress()%>"><br>
            <input type="submit" name="submit" value="変更">
        </form>

    </body>
</html>
