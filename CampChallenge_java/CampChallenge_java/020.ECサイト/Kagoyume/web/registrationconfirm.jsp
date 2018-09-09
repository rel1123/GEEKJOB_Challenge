<%-- 
    Document   : registrationconfirm
    Created on : 2018/07/13, 11:27:17
    Author     : stsno
--%>

<%@page import="kagoyume.Helper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kagoyume.UserData"%>
<%
    UserData ud = (UserData)request.getAttribute("userData");
    ArrayList<String> chkList = ud.chkproperties();
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
        <%if(chkList.size()==0){%>
            <h1>登録確認</h1><br>
            ユーザー名：<%= ud.getName()%><br>
            パスワード：<%= ud.getPassword()%><br>
            メールアドレス：<%= ud.getMail()%><br>
            住所：<%= ud.getAddress()%><br>
            上記の内容で登録します。よろしいですか？
            <form action="Registrationcomplete" method="POST">
                <input type="submit" name="yes" value="はい">
            </form>
        <%}else{%>
            <h1>入力が不完全です</h1>
            <%=hp.chkinput(chkList)%>
        <%}%>
        <form action="registration.jsp" method="POST">
                <input type="submit" name="no" value="登録画面に戻る">
            </form>
    </body>
</html>
