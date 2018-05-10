<%-- 
    Document   : 003sisokuenzan
    Created on : 2018/05/10, 14:20:54
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            final int BASE =120;//定数宣言　BASE　120を格納
            int num = 3;//変数宣言　num　3を格納
            
            int tasu = BASE + num;//変数宣言　tasu　BASE+num
            out.print(tasu+"<br>");//tasuを表示して改行
            
            int hiku = BASE - num;//変数宣言　hiku　BASE-num
            out.print(hiku+"<br>");//hikuを表示して改行
            
            int kake = BASE * num;//変数宣言　kake  BASE*num
            out.print(kake+"<br>");//kakeを表示して改行
            
            int waru = BASE / num;//変数宣言　waru　BASE/num
            out.print(waru+"<br>");//waruを表示して改行
            
            int amari = BASE % num;//変数宣言　amari　BASE/numの余り
            out.print(amari+"<br>");//amariを表示して改行
            
        %>
    </body>
</html>
