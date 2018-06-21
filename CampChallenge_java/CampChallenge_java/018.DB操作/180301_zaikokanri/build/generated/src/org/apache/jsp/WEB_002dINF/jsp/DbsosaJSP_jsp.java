package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import newpackage.ResultData;
import newpackage.ResultData.*;

public final class DbsosaJSP_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");

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

            if(bo1){
                out.print(loginLog+"<br>");
            }
        
      out.write("\n");
      out.write("        <form action=\"/180301_zaikokanri/dbSarvlet\" method=\"post\">\n");
      out.write("            <p>商品情報登録機能</p>\n");
      out.write("            商品登録ID　<input type=\"number\" name=\"iPrID\"><br>\n");
      out.write("            商品名　　　<input type=\"text\" name=\"iPrName\"><br>\n");
      out.write("            販売価格　　<input type=\"number\" name=\"iSePrice\"><br>\n");
      out.write("            仕入れ価格　<input type=\"number\" name=\"iPuPrice\"><br>\n");
      out.write("            商品分類　　<input type=\"text\" name=\"iPrType\"><br>\n");
      out.write("            仕入れ先　　<input type=\"text\" name=\"iPuType\"><br>\n");
      out.write("            <input type=\"submit\" name=\"submite\" value=\"商品登録します！\"><br>\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("        <form action=\"/180301_zaikokanri/dbSarvlet\" method=\"post\">\n");
      out.write("            <p>商品情報一覧表示機能</p>\n");
      out.write("            <input type=\"submit\" name=\"submit\" value=\"一覧表示します！\"><br>\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("        ");

            for(int i = 0; i < productData.length; i++){
                if(productData[i][0] != null){
                    if(i != 0){out.print("<br>");}
                    for(int i2 = 0; i2 < productData[i].length; i2++){
                        out.print(productData[i][i2]+"　");
                    }
                }
            }
        
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
