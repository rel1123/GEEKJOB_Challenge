package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.net.URLDecoder;
import java.net.URLEncoder;

public final class FormJsp_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        ");

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
        
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <h1 >プロフィール入力フォーム</h1>\n");
      out.write("        <!--フォーム入力-->\n");
      out.write("        <form action=\"ActionJsp.jsp\" method=\"post\">\n");
      out.write("            名前：\n");
      out.write("            <Input type=\"text\" name=\"name\" value=\"");
      out.print(csName);
      out.write("\"><br>\n");
      out.write("            性別：\n");
      out.write("            男<Input type=\"radio\" name=\"sex\" value=\"men\" ");
      out.print( chMen );
      out.write("> \n");
      out.write("            女<Input type=\"radio\" name=\"sex\" value=\"women\" ");
      out.print( chWomen );
      out.write("><br>\n");
      out.write("            趣味：\n");
      out.write("            <textarea name=\"syumi\">");
 out.print(csSyumi); 
      out.write("</textarea><br>\n");
      out.write("            \n");
      out.write("            <Input type=\"submit\" name=\"submit\" value=\"送信します！\">\n");
      out.write("            \n");
      out.write("\n");
      out.write("            \n");
      out.write("            \n");
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
