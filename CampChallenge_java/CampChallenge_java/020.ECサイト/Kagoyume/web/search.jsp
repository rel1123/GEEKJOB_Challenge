<%-- 
    Document   : search
    Created on : 2018/07/13, 11:25:24
    Author     : stsno
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="API.SearchData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    System.out.print("search.jsp実行");
    ArrayList<SearchData> sdall = new ArrayList<SearchData>();
    sdall = (ArrayList)request.getAttribute("SearchDataAll");
    SearchData sd = new SearchData();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        かごゆめショッピングサイト<br>
        <form action="http://localhost:8080/Kagoyume/Search" method="get" >
            <input type="text" name="query" placeholder="なにかお探しですか？" size="60"><input type="submit" name="submit" value="検索する"><br>
        </form>
        <br>
        <%for(int i = 0; i<10; i++){%>
        <% sd = sdall.get(i); %>
        
        <table border="0" width="80%" height="60" Align="center">
            <tr>
                <td rowspan="5" width="100"><a href="Item?code=<%=sd.getCode()%>"><img src="<%=sd.getImageUrl()%>"></a></td>
                <td min-width="500"><a href="Item?code=<%=sd.getCode()%>"><%=sd.getName()%></a></td>
                <td rowspan="5" width="25%" max-width="140"><small>出品者：<%=sd.getStoreName()%></small></td>
            </tr>
            <tr>
                <td><font color="red"><strong><%=String.format("%,d",sd.getPrice())%>円</strong></font></td>
            </tr>
            <tr>
                <td></td>
            </tr>
            <tr>
                <td><small><%=sd.getShippingName()%></small></td>
            </tr>
            <tr>
                <td><small>評価<%=sd.getReviewRate()%>/5 (<%=sd.getReviewCount()%>件)</small></td>
            </tr>
        </table>
        <Hr width="80%" align="center">

        <%}%>
        
        
    </body>
</html>
