/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import newpackage.ResultData.*;


/**
 *
 * @author stsno
 */
public class LoginSarvlet extends HttpServlet {

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
    //変数定義
    //フォームデータ格納　IDとPW
    String userID = null;
    String password = null;
    //ログアウト
    Boolean logOut = false;
    String submitType = null;
    //ログイン成功判定
    Boolean login = false;//trueならログイン後ページへ渡す用
    //ログインタイプ
    int loginType = 0;//0=処理なし,1=ログイン成功,2=失敗(ID),3=失敗(PW),4=失敗(DB),5=失敗(sqlエラー),6=失敗(その他のエラー)
    //ログインログ　jspへ送る
    String loginLog = null;
    //セッション取得
    HttpSession hs = request.getSession();
    System.out.print("セッション："+hs.getAttribute("UserID"));
   
    
    //フォームデータ格納
    request.setCharacterEncoding("UTF-8");
    
    userID = request.getParameter("userID");
    password = request.getParameter("password");
    
    
    
    submitType = request.getParameter("submit");
    if(submitType != null){
        logOut = true;
        System.out.print("ログアウト処理をtrue");
    }
    
    
//    switch (submitType){
//        case "ログアウト":
//            logOut = true;
//            System.out.print("ログアウトをトゥルー");
//            break;
//        default:
//    }
//    System.out.print(submitType);
//    if(submitType.equals("ログアウト")){
//        logOut = true;
//        System.out.print("ログアウト処理をtrue");
//    }else
    
        System.out.print("てすと");
    if(logOut){
        userID = request.getParameter("userID");
        System.out.print("userID格納："+ userID);
        password = request.getParameter("password");
    //ログイン判断
    }

    System.out.print(userID);
    System.out.print(password);
    
    LoginJava loginJava = new LoginJava();//インスタンス生成
    loginType = loginJava.loginType(userID, password);
        System.out.print("ログインタイプは"+loginType);
    login = loginJava.login(loginType);
        System.out.print("ログイン判定"+login);
    loginLog = loginJava.loginLog(loginType);
        System.out.print("ログインログは"+loginLog);
        
    if(login){
        hs.setAttribute("UserID", userID);
        hs.setAttribute("Password", password);
    }

    if(logOut){
        loginType = 9;
        loginLog = "ログアウトしました";
    }

//            JSPと連携
//            分岐 rogin 
//            送りたい情報　roginlog
//            jspSuccess = request.getDispatcher(login.jsp);
//            Failure
//            リクエストスコープへセット
            ResultData data= new ResultData();//ジャバビーンズインスタンス生成
            data.setLoginLog(loginLog);
            request.setAttribute("DATA", data);
            System.out.print("テスト１");
            if(login){
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/DbsosaJSP.jsp");
                rd.forward(request, response);
            }else{
                RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
                rd.forward(request, response);
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
