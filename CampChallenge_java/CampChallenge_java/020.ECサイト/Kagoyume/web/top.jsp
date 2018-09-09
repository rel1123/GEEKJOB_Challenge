<%-- 
    Document   : top
    Created on : 2018/07/13, 11:24:41
    Author     : stsno
--%>
<%@page import="kagoyume.Helper"%>
<%
    Helper hp = new Helper();
    HttpSession hs = request.getSession();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        かごゆめショッピングサイト<br>
        <%= hp.burner()%>
        <%  if(hs.getAttribute("login") != null){
                if((String.valueOf(hs.getAttribute("login")).equals("true"))){
                    out.print(hp.mydata()+"　");
                    out.print(hp.logout());
                }else{
                    out.print(hp.login());
                }
                
            }else{
                out.print(hp.login());
            }%> 
        <form action="/Kagoyume/Search" method="get">
            <input type="text" name="query" placeholder="なにかお探しですか？" size="60"><input type="submit" name="submit" value="検索する"><br>
        </form>
        
        
    </body>
</html>
