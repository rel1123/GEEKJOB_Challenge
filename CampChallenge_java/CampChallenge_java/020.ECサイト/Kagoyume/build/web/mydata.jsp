<%-- 
    Document   : mydata
    Created on : 2018/09/10, 4:23:24
    Author     : stsno
--%>
<%@page import="kagoyume.UserDataDTO"%>
<%
    HttpSession hs = request.getSession();
    UserDataDTO udd = (UserDataDTO)hs.getAttribute("loginUserData");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>会員情報 - 閲覧画面</h1><br>
        名前：<%=udd.getName()%><br>
        メールアドレス：<%=udd.getMail()%><br>
        住所：<%=udd.getAddress()%><br>
        合計購入金額：<%=udd.getTotal()%>円 <br>
        登録日：<%=udd.getNewDate()%><br>
        <br>
        <a href="Myhistory">購入履歴</a><br>
        <a href="Myupdate">登録情報を更新する</a><br>
        <a href="Mydelete">登録情報を削除する</a><br>
    </body>
</html>
