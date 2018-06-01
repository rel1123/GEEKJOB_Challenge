<%-- 
    Document   : test
    Created on : 2018/06/01, 11:49:10
    Author     : stsno
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
//            ■処理内容 
//1. type の値を元に，商品種別の日本語情報を表示してください。 
//2. 商品の単価を求め，画面に表示してください。 
//3. 商品購入総額に応じてポイントを計算し，その値を画面に表示してください。なお，ポイントの計算は，商品購入総額を基準にして，以下の要領で行います。 
//3000 円未満 ... 0% 
//3000 円以上で5000円未満 ... 購入総額の 4% 
//5000 円以上 ... 購入総額の 5% -->
            request.setCharacterEncoding("UTF-8");
            //total、count、type情報をint型に変換して格納
            int total = Integer.parseInt(request.getParameter("total"));
            int count = Integer.parseInt(request.getParameter("count"));
            int type = Integer.parseInt(request.getParameter("type"));
            //typeの値をもとに、商品種別の日本語情報を表示
            out.print("商品種別：");
            switch(type) {
                case 1:
                    out.print("雑貨");
                    break;
                case 2:
                    out.print("生鮮食品");
                    break;
                case 3:
                    out.print("その他");
                    break;
                default:
                    out.print("商品種別が選択されていません");
                    break;
            }
            out.print("<br>");
            
            //商品単価
            out.print("商品単価："+total / count+"<br>");
            //ポイント計算
            out.print("獲得ポイント：");
            if(total >= 5000){
                out.print(total * 0.05 + "p");
            }else if(total >=3000){
                out.print(total * 0.04 + "p");
            }else{
                out.print("ポイントの獲得はありません");
            }

        %>
    </body>
</html>
