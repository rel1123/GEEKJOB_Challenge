<%-- 
    Document   : test
    Created on : 2018/06/01, 11:49:10
    Author     : stsno
--%>

<%@page import="java.util.ArrayList"%>
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

//http://localhost:8080/160302_QueryString2/test.jsp?1=100&2=200&3=54



            request.setCharacterEncoding("UTF-8");
            //total、count、type情報をint型に変換して格納
            int toi1 = Integer.parseInt(request.getParameter("1"));
            int toi2 = Integer.parseInt(request.getParameter("2"));
            int toi3 = Integer.parseInt(request.getParameter("3"));
            
            
            //変数宣言
            Integer[] sosu = {2,3,5,7};
            //計算途中用割った数
            ArrayList<Integer> keisan = new ArrayList<Integer>();
            //余り
            int amari = 0;
            
            
            amari = toi1;
            for(int i = 0;
                    i < sosu.length;
                    i++){
                //typeの値をもとに、商品種別の日本語情報を表示
                while(amari % sosu[i] == 0){
                    amari= amari / sosu[i];
                    keisan.add(sosu[i]);
                }
            }
            
            //表示
            out.print("例１「"+toi1+"=");
            for(int i = 0; i < keisan.size(); i++){
                if(i != 0){out.print("*");}
                out.print(keisan.get(i));
            }
            if(amari != 1){
                out.print("余り"+amari);
            }    
            out.print("」<br>");
            
            
            // 2問目
            amari = toi2;
            for(int i = 0;
                    i < sosu.length;
                    i++){
                //typeの値をもとに、商品種別の日本語情報を表示
                while(amari % sosu[i] == 0){
                    amari= amari / sosu[i];
                    keisan.add(sosu[i]);
                }
            }
            
            //表示
            out.print("例２「"+toi2+"=");
            for(int i = 0; i < keisan.size(); i++){
                if(i != 0){out.print("*");}
                out.print(keisan.get(i));
            }
            if(amari != 1){
                out.print("余り"+amari);
            }    
            out.print("」<br>");

            //3問目
            amari = toi3;
            for(int i = 0;
                    i < sosu.length;
                    i++){
                //typeの値をもとに、商品種別の日本語情報を表示
                while(amari % sosu[i] == 0){
                    amari= amari / sosu[i];
                    keisan.add(sosu[i]);
                }
            }
            
            //表示
            out.print("例３「"+toi3+"=");
            for(int i = 0; i < keisan.size(); i++){
                if(i != 0){out.print("*");}
                out.print(keisan.get(i));
            }
            if(amari != 1){
                out.print("余り"+amari);
            }    
            out.print("」<br>");


        %>
    </body>
</html>
