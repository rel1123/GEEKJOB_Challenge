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
public class zikkou extends HttpServlet {

    
    
    
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
            /* TODO output your page here. You may use following sample code. */
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>ブラックジャック</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.print("<h1>ブラックジャック</h1>");
            out.print("ゲームスタート<br>");
            

            Dealer dealer = new Dealer();
            User user = new User();
            
            

            out.print("<br>手札を配ります<br>");
            //　はじめの手札配り
            user.setCard(dealer.Dial());
            out.print("・ユーザー<br>"
                    + "　２枚配られました。<br>"
                    + "　手札"+user.myCards+"　計："+user.open()+"<br>");
            
            dealer.setCard(dealer.Dial());
            out.print("・ディーラー<br>"
                    + "　２枚配られました。<br>"
                    + "　手札"+dealer.myCards+"　計："+dealer.open()+"<br>");
            
            out.print("<br>ヒットorスタンド<br>");
            

            //　ユーザーターン

            out.print("・ユーザー<br>");
            while(user.checkSum()){
                user.setCard(dealer.hit());
                out.print("　ヒットしました。<br>"
                        +"　手札"+user.myCards+"　計："+user.open()+"<br>");
            }
            out.print("　スタンドしました。<br>"
                    + "　手札"+user.myCards+"　計："+user.open()+"<br>");
            
            //　ディーラーターン
            out.print("・ディーラー<br>");
            while(dealer.checkSum()){
                dealer.setCard(dealer.hit());
                out.print("　ヒットしました。<br>"
                        +"　手札"+dealer.myCards+"　計："+dealer.open()+"<br>");
            }
            out.print("　スタンドしました。<br>"
                    + "　手札"+dealer.myCards+"　計："+dealer.open()+"<br>");
            
            
            //　結果表示
            out.print("<br>結果発表<br>");
            //ユーザーもしくはディーラーが21を超えている場合
            if(user.open() > 21 || dealer.open() > 21){
                if(user.open() >=21){
                    out.print("ユーザーの負け<br>");
                }else{
                    out.print("ユーザーの勝利<br>");
                }
            }else if(user.open() > dealer.open()){
                out.print("ユーザーの勝利<br>");
            }else if(user.open() < dealer.open()){
                out.print("ユーザーの負け<br>");
            }else{
                out.print("引き分け<br>");
            }
            
            //山札確認用
            out.print("<br>余った山札は"+dealer.cards.size()+"枚です<br>");

            
            
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
