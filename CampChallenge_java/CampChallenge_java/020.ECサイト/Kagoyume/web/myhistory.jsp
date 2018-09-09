<%-- 
    Document   : myhistory
    Created on : 2018/09/10, 4:23:41
    Author     : stsno
--%>
<%@page import="API.ItemData"%>
<%@page import="java.util.ArrayList"%>
<%
    
    ArrayList<ItemData> cID = (ArrayList<ItemData>)request.getAttribute("buyItemDatas");
    int total = 0;
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        購入履歴
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
        合計金額 <%=total%>円

        
    </body>
</html>
