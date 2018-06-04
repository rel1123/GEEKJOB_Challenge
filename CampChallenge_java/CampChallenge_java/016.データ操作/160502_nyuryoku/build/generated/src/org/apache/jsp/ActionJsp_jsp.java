package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.net.URLEncoder;

public final class ActionJsp_jsp extends org.apache.jasper.runtime.HttpJspBase
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
