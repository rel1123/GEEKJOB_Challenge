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
        profile1.add(null);
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
            
            
            ArrayList<String> IDs = new ArrayList<String>();
            IDs.add("000001");
            IDs.add("000002");
            IDs.add("000003");
            
            //繰り返し用変数宣言
            //limit繰り返し回数に使用
            int limit = 2;
            //ID取得、ｎ-１人目のプロフィールに使用
            int i1 = 0;
            
            //繰り返し処理１
            //ｎ人のプロフィール表示（limitで表示回数管理）
            while(limit != 0){
                //ｎ－１人目のプロフィールを表示
                out.print(i1+1 + "人目のプロフィール<br>");
                
                //繰り返し処理２
                //プロフィール表示処理（名前、住所）
                for(int i2 = 1; i2 <= 2; i2++){
                    //profile（i番目）を表示
                    //誕生日と住所を表示
                    //メソッド呼び出し
                    //nullが入ってる場合スキップ
                    if(profile(IDs.get(i1)).get(i2) == null){
                        continue;
                    }
                    out.print(profile(IDs.get(i1)).get(i2)+"<br>");
            }
                //limitをー１
                //i1をプラス１
                limit--;
                i1++;
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
