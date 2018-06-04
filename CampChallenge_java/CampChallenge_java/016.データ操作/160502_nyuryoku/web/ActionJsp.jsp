<%-- 
    Document   : ActionJsp
    Created on : 2018/06/04, 10:15:53
    Author     : stsno
--%>

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
            String name = "";
            String sex = "";
            String syumi = "";
            
            String enName = "";
            String enSex = "";
            String enSyumi = "";
            
            
            
            
            request.setCharacterEncoding("UTF-8");
            //inputデータを変数に格納
            name = request.getParameter("name");
            sex = request.getParameter("sex");
            syumi = request.getParameter("syumi");
            
            
            //imputデータをクッキーへ
            
            //encode
            if(name != null){
                enName = URLEncoder.encode(name,"UTF-8");
            }
            if(sex != null){
                enSex = URLEncoder.encode(sex,"UTF-8");
            }
            if(syumi != null){
                enSyumi = URLEncoder.encode(syumi,"UTF-8");
            }

            //Cookie作成
            Cookie cName = new Cookie("name",enName);
            Cookie cSex = new Cookie("sex",enSex);
            Cookie cSyumi = new Cookie("syumi",enSyumi);
            //格納
            response.addCookie(cName);
            response.addCookie(cSex);
            response.addCookie(cSyumi);
            

            
            
            
            
            //inputデータの表示
            out.print("名前：");
            if(name != null){
                out.print(name);
            }
            out.print("<br>");
            
            out.print("性別：");
            if(sex != null){
                if(sex.equals("men")){
                    out.print("男");
                }else if(sex.equals("women")){
                    out.print("女");
                }
            }
            out.print("<br>");
            
            out.print("趣味：");
            if(syumi != null){
                out.print(syumi);
            }
            out.print("<br>");
        %>
    </body>
</html>
