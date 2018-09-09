/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import API.API;
import API.ItemData;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author stsno
 */
public class Add extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        try {
            String id = request.getParameter("code");
            //カート情報をアレイリストに保存
            //アレイリストを宣言
            ArrayList<String[]> cartData = new ArrayList<String[]>();;
            
            if(session.getAttribute("login")!=null){
                if((boolean)session.getAttribute("login")){
                    UserDataDTO udd = (UserDataDTO)session.getAttribute("loginUserData");
                    try{
                        //カート情報の読み込み
                        if(session.getAttribute("cartData"+String.valueOf(udd.getUserID()))!=null){
                            cartData = (ArrayList<String[]>)session.getAttribute("cartData"+String.valueOf(udd.getUserID()));
                        }else{
                            System.out.print("セッションにカート情報がありません。");
                        }
                    }catch(Error e){
                        System.out.print("カート情報の読み込み中にエラーが発生しました。エラーコードは"+e);
                    }
                    //個数を指定してカートに追加（現在は１のみ）
                    String[] addData = {id,"1"};
                    cartData.add(addData);
                    //カート情報をセッションに保存
                    session.setAttribute("cartData"+String.valueOf(udd.getUserID()), cartData);
                }else{
                    try{
                        //カート情報の読み込み
                        if(session.getAttribute("cartData")!=null){
                            cartData = (ArrayList<String[]>)session.getAttribute("cartData");
                        }else{
                            System.out.print("セッションにカート情報がありません。");
                        }
                    }catch(Error e){
                        System.out.print("カート情報の読み込み中にエラーが発生しました。エラーコードは"+e);
                    }
                    //個数を指定してカートに追加（現在は１のみ）
                    String[] addData = {id,"1"};
                    cartData.add(addData);
                    //カート情報をセッションに保存
                    session.setAttribute("cartData", cartData);
                    
                }
                
            }else{
                try{
                    //カート情報の読み込み
                    if(session.getAttribute("cartData")!=null){
                        cartData = (ArrayList<String[]>)session.getAttribute("cartData");
                    }else{
                        System.out.print("セッションにカート情報がありません。");
                    }
                }catch(Error e){
                    System.out.print("カート情報の読み込み中にエラーが発生しました。エラーコードは"+e);
                }
                //個数を指定してカートに追加（現在は１のみ）
                String[] addData = {id,"1"};
                cartData.add(addData);
                //カート情報をセッションに保存
                session.setAttribute("cartData", cartData);
                
            }
            
            UserDataDTO udd = (UserDataDTO)session.getAttribute("loginUserData");
            
            request.getRequestDispatcher("/add.jsp").forward(request,response);
            
        }catch(Error e){
            
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
