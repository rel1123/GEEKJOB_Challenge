<%-- 
    Document   : buyconfirm
    Created on : 2018/09/10, 3:07:52
    Author     : stsno
--%>

<%@page import="API.ItemData"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    
    ArrayList<ItemData> cID = (ArrayList<ItemData>)request.getAttribute("cartItemDatas");
    int total = 0;
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        購入確認画面
        <table border="1" width="80%" height="60" Align="center">
            <tr>
                <td colspan="2">商品名</td>
                <td>価格（税込み）</td>
                <td>数量</td>
            </tr>
        <% for(int i = 0; i < cID.size(); i++){%>
        <% ItemData iD = cID.get(i); %>
        <% total += iD.getPrice();%>

            <tr>
                <td><img src="<%=iD.getImageSmall()%>"></td>
                <td><%=iD.getName()%></td>
                <td><font color="red"><strong><%=String.format("%,d",iD.getPrice())%>円</td>
                <td>1
            </tr>
            <%}%></table><br>
        合計金額 <%=total%>円　　<form action="Buycomplete" method="POST"><input type="submit" name="sub" value="上記の内容で購入する"></form><br>
        <a href="Cart">カートへ戻る</a>

        
    </body>
</html>
