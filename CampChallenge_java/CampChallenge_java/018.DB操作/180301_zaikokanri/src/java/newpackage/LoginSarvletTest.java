/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author stsno
 */
@WebServlet(name = "loginSarvlet", urlPatterns = {"/loginSarvlet"})
public class LoginSarvletTest extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            
            System.out.println("テスト");
            Connection db_con = null;
            
            response.setCharacterEncoding("UTF-8");
            if(request.getParameter("userID") != null && !(request.getParameter("userID").equals(""))){
                if(request.getParameter("password") != null && !(request.getParameter("password").equals(""))){
                    String userID =request.getParameter("userID");
                    String password = request.getParameter("password");
                    try{                       
                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", userID ,password);
                        System.out.println("DB接続成功");
                        out.println("接続成功");
                    }catch(SQLException e_sql){
                        System.out.println("DB接続失敗（SQL）<br>" + e_sql);
                        out.println("DB接続失敗（SQL）<br>" + e_sql);
                    }catch(Exception e){
                        System.out.println("DB接続失敗（通常）<br>" + e);
                        out.println("DB接続失敗（通常）<br>" + e);
                    }
                }else{
                    out.println("パスワードを入力してください");
                }

            }else if(request.getParameter("password") != null && !(request.getParameter("password").equals(""))){
                out.println("ユーザー名を入力してください");
                }else{
                    out.println("ユーザー名とパスワードを入力してください");
                }
            
            
            
                    
            
            
            
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet loginSarvlet</title>");            
            out.println("</head>");
            out.println("<body>");

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
