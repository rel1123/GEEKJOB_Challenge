package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;

public final class test_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

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
            
            out.print(request.getContentLength());
            
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
            
            out.print("」");

        
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
