<%-- 
    Document   : DbsosaJSP
    Created on : 2018/06/15, 15:26:10
    Author     : stsno
--%>
<%@page import="newpackage.ResultData"%>
<%@page import="newpackage.ResultData.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    boolean bo1 = false;
    String loginLog = null;
    String[][] productData = new String[225][6];
    
    ResultData data = (ResultData)request.getAttribute("DATA");
    ResultData data2 = (ResultData)request.getAttribute("ProductData");
    try{
        loginLog = data.getLoginLog();
        bo1 = true;
        productData = data2.getProductData();
    }catch(Exception e){
        out.print("初回アクセス<br>");
    }
%>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if(bo1){
                out.print(loginLog+"<br>");
            }
        %>
        <form action="/180301_zaikokanri/LoginSarvlet" method="post">
            <input type="submit" name="submit" value="ログアウト">
        </form>
        
        <form action="/180301_zaikokanri/dbSarvlet" method="post">
            <p>商品情報登録機能</p>
            商品登録ID　<input type="number" name="iPrID"><br>
            商品名　　　<input type="text" name="iPrName"><br>
            販売価格　　<input type="number" name="iSePrice"><br>
            仕入れ価格　<input type="number" name="iPuPrice"><br>
            商品分類　　<input type="text" name="iPrType"><br>
            仕入れ先　　<input type="text" name="iPuType"><br>
            <input type="submit" name="submit" value="商品登録します！"><br>
        </form>
        
        <form action="/180301_zaikokanri/dbSarvlet" method="post">
            <p>商品情報一覧表示機能</p>
            <input type="submit" name="submit" value="一覧表示します！"><br>
        </form>
        
        <%
//            for(int i = 0; i < productData.length; i++){
//                if(productData[i][0] != null){
//                    if(i != 0){out.print("<br>");}
//                    for(int i2 = 0; i2 < productData[i].length; i2++){
//                        out.print(productData[i][i2]+"　");
//                    }
//                }
//            }
                    for(int i = 0; i < productData.length; i++){
                if(productData[i][0] != null){
                    if(i != 0){out.print("<br>");}
                    for(int i2 = 0; i2 < productData[i].length; i2++){
                        out.print(productData[i][i2]+"　");
                    }
                }
            }


        %>
    </body>
</html>
