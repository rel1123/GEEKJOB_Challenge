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
    
    
//    void myprofile(PrintWriter pw){
//        pw.print("私の名前は小泉です<br>");
//        pw.print("生年月日は1995年11月23日です<br>");
//        pw.print("ゲームやファッションが好きです<br>");
//    }
//    
//    
//    
//    boolean bo1 (PrintWriter pr1){
//        return true;
//    }
//    
  
//    String[] profile (){
//        String pr1 [] = {"a","i"};
//        return pr1;
//    
//    }
      
    
//                  /*　　ArrayList<クラス> 変数名 =
//　　　　　　　　　　new ArrayList<クラス>(); */
//            //JSPでArrayListを利用するにはimportが必要上記
//            //整数を扱う配列の作成
//            ArrayList<Integer> data5 = new ArrayList<Integer>();
//            //文字列を扱う配列の作成
//            ArrayList<String> data6 = new ArrayList<String>();
//            
//        %>
//        <%
//            //配列の操作
//            //配列の作成
//            ArrayList<String>data7 = new ArrayList<String>();
//            //要素の追加
//            data7.add("小泉");
//            //要素の取得　（小泉の表示）
//            out.print(data7.get(0));
//            //要素の更新　小泉→小池
//            data7.set(0,"小池");
//            //要素数取得
//            out.print(data7.size());
//            //要素の削除
//            data7.remove(0);// data7.remove("小池");でも可
            
    //ユーザー定義メソッド
    //引数無し　戻り値：配列ArrayList、String
    ArrayList<String>profile (){
        //ArrayListを宣言（メソッド内）
        ArrayList<String>pr = new ArrayList<String>();
        //データ入力
        pr.add("ID123456");
        pr.add("1995年11月23日");
        pr.add("東京都板橋区");
        //profileへ　戻り値
        return pr;
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
//            for(int i = 0; i < 10; i++){
//                myprofile(out);
//            }
//            
//            if(bo1(out)){
//                out.print("この処理は正しく実行できました");
//            }else{
//                out.print("正しく実行さできませんでした");
//            }
//            out.print(profile());
//
//
//            out.println("</body>");
//            out.println("</html>");

            //for文を使った反復処理int1から2回繰り返し
            for(int i = 1; i <= 2; i++){
                //profile（i番目）を表示
                //誕生日と住所を表示
                out.print(profile().get(i)+"<br>");
            }

            
            
            
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
