<%-- 
    Document   : FormJsp
    Created on : 2018/06/04, 11:41:30
    Author     : stsno
--%>

<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
            String csName = "";
            String csSex = "";
            String csSyumi = "";
            
            String chMen = "";
            String chWomen = "";
            
            //クッキー取得
            Cookie[] cs = request.getCookies();
            
            //フォーム初期値設定
            //デコード、変数に格納
            if(cs != null&&cs.length > 1){
                csName = URLDecoder.decode(cs[0].getValue(),"UTF-8");
                csSex = URLDecoder.decode(cs[1].getValue(),"UTF-8");
                csSyumi = URLDecoder.decode(cs[2].getValue(),"UTF-8");
            
                //radioボタン用
                if(csSex.equals("men")){
                    chMen = "checked";
                }else if(csSex.equals("women")){
                    chWomen = "checked";
                }
            }
        %>
        
        
        <h1 >プロフィール入力フォーム</h1>
        <!--フォーム入力-->
        <form action="ActionJsp.jsp" method="post">
            名前：
            <Input type="text" name="name" value="<%=csName%>"><br>
            性別：
            男<Input type="radio" name="sex" value="men" <%= chMen %>> 
            女<Input type="radio" name="sex" value="women" <%= chWomen %>><br>
            趣味：
            <textarea name="syumi"><% out.print(csSyumi); %></textarea><br>
            
            <Input type="submit" name="submit" value="送信します！">
            

            
            
    </body>
</html>
