package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import API.SearchData;

public final class search_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    ArrayList<SearchData> sdall = new ArrayList<>();
    sdall = (ArrayList)request.getAttribute("SearchDataAll");
    SearchData sd = new SearchData();

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        かごゆめショッピングサイト<br>\n");
      out.write("        <form action=\"http://localhost:8080/Kagoyume/Serch\" method=\"get\">\n");
      out.write("            <input type=\"text\" name=\"query\" placeholder=\"なにかお探しですか？\" size=\"60\"><input type=\"submit\" name=\"submit\" value=\"検索する\"><br>\n");
      out.write("        </form>\n");
      out.write("        ");
for(int i = 0; i<10; i++){
      out.write("\n");
      out.write("        ");
 sd = sdall.get(i); 
      out.write("\n");
      out.write("        \n");
      out.write("        <table border=\"0\" width=\"700\" height=\"60\">\n");
      out.write("            <tr>\n");
      out.write("                <td rowspan=\"5\" width=\"100\">画像</td>\n");
      out.write("                <td><a href=\"Item?code=");
      out.print(sd.getCode());
      out.write('"');
      out.write('>');
      out.print(sd.getName());
      out.write("</a></td>\n");
      out.write("                <td rowspan=\"5\" width=\"140\">出品者：");
      out.print(sd.getStoreName());
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print(sd.getPrice());
      out.write("円</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print(sd.getShippingName());
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>評価");
      out.print(sd.getReviewRate());
      out.write("/5 (");
      out.print(sd.getReviewCount());
      out.write("件)</td>\n");
      out.write("            </tr>\n");
      out.write("        </table>    \n");
      out.write("\n");
      out.write("            <br>\n");
      out.write("        ");
}
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
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
