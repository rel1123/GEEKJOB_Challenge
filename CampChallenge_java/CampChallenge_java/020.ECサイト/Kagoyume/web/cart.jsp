<%-- 
    Document   : cart
    Created on : 2018/07/13, 11:27:57
    Author     : stsno
--%>
<%@page import="API.ItemData"%>
<%@page import="java.util.ArrayList"%>
<%
    
    ArrayList<ItemData> cID = (ArrayList<ItemData>)request.getAttribute("cartItemDatas");
    int total = 0;
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>cart page</title>
    </head>
    <body>
        ショッピングカート
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
                <td><a href="Item?code=<%=iD.getCode()%>"><img src="<%=iD.getImageSmall()%>"></a></td>
                <td><a href="Item?code=<%=iD.getCode()%>"><%=iD.getName()%></a></td>
                <td><font color="red"><strong><%=String.format("%,d",iD.getPrice())%>円</td>
                <td>1
                    <form action="Cart" method="POST">
                        <input type="hidden" name="type" value="delete">
                        <input type="hidden" name="deleteNum" value="<%=String.valueOf(i)%>">
                        <input type="submit" name="delete" value="削除"></form></td>
            </tr>
        <%}%>
            <tr>
                <td colspan="4">合計金額 <%=total%>円　　<form action="Buyconfirm" method="POST"><input type="submit" name="sub" value="購入"></form></td>
            </tr>
        </table>
        
    </body>
</html>
