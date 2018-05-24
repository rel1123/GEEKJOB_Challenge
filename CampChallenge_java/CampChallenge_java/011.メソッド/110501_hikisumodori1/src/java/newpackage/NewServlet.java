/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author stsno
 */
public class NewServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    //ユーザー定義メソッド
    //引数　文字列型
    ArrayList<String> profile (String ID){
        ArrayList<String>profile1 = new ArrayList<String>();
        profile1.add("000001");
        profile1.add("小泉諒馬");
        profile1.add("東京都");
        ArrayList<String>profile2 = new ArrayList<String>();        
        profile2.add("000002");
        profile2.add("新井茂");
        profile2.add("福岡県");
        ArrayList<String>profile3 = new ArrayList<String>();        
        profile3.add("000003");
        profile3.add("苫井葉加");
        profile3.add("沖縄県");
        ArrayList<String>profilenashi = new ArrayList<String>();        
        profilenashi.add("");
        profilenashi.add("");
        profilenashi.add("");
        
        switch(ID){
            case "000001":
                return profile1;
            case "000002":
                return profile2;
            case "000003":
                return profile3;
            default:
                return profilenashi;
        }
    }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            
            for(int i = 1; i <= 2; i++){
                //profile（i番目）を表示
                //誕生日と住所を表示
                out.print(profile("000001").get(i)+"<br>");
            }
            
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
