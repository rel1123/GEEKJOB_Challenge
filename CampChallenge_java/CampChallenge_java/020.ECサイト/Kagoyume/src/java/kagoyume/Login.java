/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author stsno
 */
public class Login extends HttpServlet {

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
        try {
            //セッション生成
            HttpSession session = request.getSession();
            //フォームデータ取得
            request.setCharacterEncoding("UTF-8");
            //遷移先
            String senni = "/top.jsp";
            //遷移先に渡す文
            String message = "";
            //フォームデータを保存　ログインタイプ
            String loginType = request.getParameter("loginType");
            
            
            //ログアウトの場合ログアウト処理
            if(loginType.equals("logout")){
                session.setAttribute("login",false);
                session.removeAttribute("loginUserData");

                senni = "/top.jsp";
            }else if(loginType.equals("loginTry")){//ログイントライ
                //ログイン判断
                //フォームデータ（name,password）を格納
                String loginName = request.getParameter("name");
                String loginPassword = request.getParameter("password");
                if(loginName != null && !loginName.equals("")
                        && loginPassword != null && !loginPassword.equals("")){
                    //ユーザー名・パスワードが入力されていた場合
                    //ログイン判断
                    try{
                        //フォームデータをUserDataに保存
                        UserData loginFormData = new UserData();
                        loginFormData.setName(loginName);
                        loginFormData.setPassword(loginPassword);

                        UserDataDTO loginUDO = new UserDataDTO();
                        loginFormData.UD2DTOMapping(loginUDO);
                        UserDataDTO resultDTO = UserDataDAO.getInstance().searchByNamePassword(loginUDO);
                        int loginID = resultDTO.getUserID();
                        if(loginID != 0){
                            session.setAttribute("login", true);
                            session.setAttribute("loginUserData", resultDTO);
                            if(session.getAttribute("lastPage")!=null){
                                senni = "/rising.jsp";
                                //カートデータの引継ぎ処理
                                if(String.valueOf(session.getAttribute("lastPage")).equals("Cart")){
                                    if(session.getAttribute("cartData") != null){
                                        //カートデータがある場合そのデータを『cartDataユーザーID』の形で保存　例　cartData1
                                        session.setAttribute("cartData"+String.valueOf(resultDTO.getUserID()), session.getAttribute("cartData"));
                                        session.removeAttribute("cartData");
                                    }
                                }
                                
                                senni = "/rising.jsp";
                                    
                                
                            }else{
                                senni = "/top.jsp";
                            }
                            message = "ログインに成功しました。";
                        }else{
                            session.setAttribute("login", false);
                            senni = "/login.jsp";
                            message = "ログインに失敗しました。";
                        }
                    }catch(Exception e){
                        System.out.print(e);
                        senni = "/login.jsp";
                        message = "『ユーザー名』または『パスワード』が違います。";
                    }
                }else{//ユーザー名またはパスワードが入力されていない場合
                    if(loginName == null || loginName.equals("")){
                        message += "『ユーザー名』";
                    }
                    if(loginPassword == null || loginPassword.equals("")){
                        message += "『パスワード』";
                    }
                    session.setAttribute("login", false);
                    senni = "/login.jsp";
                    message += "を入力してください。";
                }
            }else{
                session.setAttribute("login", false);
                senni = "/login.jsp";
            }
            


            //ログインの場合はlogin.jspへ
            request.setAttribute("message", message);
            request.getRequestDispatcher(senni).forward(request, response);
       
            
        }catch(Error e){
            System.out.print(e);
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
