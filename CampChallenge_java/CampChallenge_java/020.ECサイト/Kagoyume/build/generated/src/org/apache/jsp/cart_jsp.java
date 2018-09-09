package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import API.ItemData;
import java.util.ArrayList;

public final class cart_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    ArrayList<ItemData> cID = (ArrayList<ItemData>)request.getAttribute("cartItemDatas");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>cart page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
for(int i = 0; i > cID.size(); i++){
      out.write("\n");
      out.write("        ");
 ItemData iD = cID.get(i); 
      out.write("\n");
      out.write("            <table border=\"0\" width=\"80%\" height=\"60\" Align=\"center\">\n");
      out.write("                <tr>\n");
      out.write("                    <td rowspan=\"5\" width=\"100\"><a href=\"Item?code=");
      out.print(iD.getCode());
      out.write("\"><img src=\"");
      out.print(iD.getImageMedium());
      out.write("\"></a></td>\n");
      out.write("                    <td min-width=\"500\"><a href=\"Item?code=");
      out.print(iD.getCode());
      out.write('"');
      out.write('>');
      out.print(iD.getName());
      out.write("</a></td>\n");
      out.write("                    <td rowspan=\"5\" width=\"25%\" max-width=\"140\"><small>出品者：");
      out.print(iD.getStoreName());
      out.write("</small></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><font color=\"red\"><strong>");
      out.print(String.format("%,d",iD.getPrice()));
      out.write("円</strong></font></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><small>");
      out.print(iD.getShippingName());
      out.write("</small></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><small>評価");
      out.print(iD.getReviewRate());
      out.write("/5 (");
      out.print(iD.getReviewCount());
      out.write("件)</small></td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        ");
}
      out.write("\n");
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
