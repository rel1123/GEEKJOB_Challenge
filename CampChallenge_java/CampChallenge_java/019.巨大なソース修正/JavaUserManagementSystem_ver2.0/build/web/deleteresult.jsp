
<%@page import="jums.UserDataBeans"%>
<%@page import="jums.JumsHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    UserDataBeans udb = (UserDataBeans)request.getAttribute("searchFormData");
%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>削除結果画面</title>
    </head>
    <body>
    <h1>削除確認</h1>
    削除しました。<br>
    </body>
    <form action="SearchResult" method="POST">
        <input type="hidden" name="name" value="<%=udb.getName()%>">
        <input type="hidden" name="year" value="<%=udb.getYear()%>">
        <input type="hidden" name="type" value="<%=udb.getType()%>">
        <input type="submit" name="btnSubmit2" value="検索結果画面に戻る">
    </form><br>
    <%=jh.home()%>
</html>
