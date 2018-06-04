<%-- 
    Document   : test
    Created on : 2018/06/04, 11:07:16
    Author     : stsno
--%>

<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            
                        Date now = new Date();
            
            String value = URLEncoder.encode(now.toString(),"UTF-8");         
            Cookie c = new Cookie("LastLogin",value);
            
            response.addCookie(c);

//            Cookie[] cs = request.getCookies();
//            if(cs != null){
//                for(int i = 0; i <cs.length; i++){
//                    if(cs[i].getName().equals("LastLogin")){
//                        String aaa = cs[i].getValue();
//                        String value2 = URLDecoder.decode(aaa, "UTF-8");
//                        out.print(value2);
//                        break;
//                
//                    }
//                }
//            }


        %>
    </body>
</html>
