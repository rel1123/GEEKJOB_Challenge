<%-- 
    Document   : item
    Created on : 2018/07/13, 11:25:38
    Author     : stsno
--%>

<%@page import="API.ItemData"%>
<%
    System.out.print("item.jsp実行");
    ItemData iD = new ItemData();
    iD = (ItemData)request.getAttribute("itemData");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="0" width="800" height="60" Align="center">
            <tr>
                <td colspan="2"><%=iD.getStoreName()%>  ストア評価：<%=iD.getStoreRatingsDetailRate()%></tr>
            <tr>
                <td rowspan="10" width="400"><img src="<%=iD.getImageMedium()%>"></td>
                <td min-width="500"><%=iD.getName()%></td>
            </tr>
            <tr>
                <td><font color="red"><strong><%=String.format("%,d",iD.getPrice())%>円</strong></font></td>
            </tr>
            <tr>
                <td><a href="Add?code=<%=iD.getCode()%>">カートに入れる</a></td>
            </tr>
        </table>
        <Hr width="800" align="center">
    </body>
</html>
