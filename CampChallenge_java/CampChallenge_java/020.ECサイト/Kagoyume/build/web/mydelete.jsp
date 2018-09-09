<%-- 
    Document   : mydelete
    Created on : 2018/09/10, 4:24:23
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
        <h1>会員情報 - 削除画面</h1><br>
        名前：<%=udd.getName()%><br>
        メールアドレス：<%=udd.getMail()%><br>
        住所：<%=udd.getAddress()%><br>
        合計購入金額：<%=udd.getTotal()%>円 <br>
        登録日：<%=udd.getNewDate()%><br>
        <br>
        このユーザーをマジで削除しますか？
        <a href="Mydeleteresult">はい</a>　<a href="Mydata">いいえ</a><br>
    </body>
</html>
