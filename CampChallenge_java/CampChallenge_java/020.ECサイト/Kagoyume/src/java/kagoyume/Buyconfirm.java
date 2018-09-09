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
public class Buyconfirm extends HttpServlet {

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
        try{
            /* TODO output your page here. You may use following sample code. */

            HttpSession session = request.getSession();
            if(session.getAttribute("login")!=null){
                if((boolean)session.getAttribute("login")){
                    
                    ArrayList<ItemData> cartItemDatas = new ArrayList<ItemData>();
                    //カートデータ情報があるなら
                    UserDataDTO udd = (UserDataDTO)session.getAttribute("loginUserData");
                    if(session.getAttribute("cartData"+String.valueOf(udd.getUserID())) !=null){
                        ArrayList<String[]> cartData = (ArrayList<String[]>)session.getAttribute("cartData"+String.valueOf(udd.getUserID()));

                        //APIインスタンス作成
                        API api = new API();


                        


                        for(int i = 0; i < cartData.size(); i++){
                            //商品コード読み込み
                            String code = cartData.get(i)[0];

                            //UrlStringの初期値読み込み生成
                            String ItemUrlString = api.ItemAPIbaseUrl();
                            ItemUrlString += "&responsegroup=large";
                            //検索部分を追加
                            ItemUrlString += "&itemcode="+code;
                            System.out.print(ItemUrlString);
                            //URLからJsonNodeを獲得しデータをSearchDataに格納
                            //ItemDataのインスタンスを作成   SdAPIMapping
                            ItemData itemData = new ItemData();
                            itemData.SdAPIMapping(api.getJsonNode(ItemUrlString));

                            System.out.print("テスト"+itemData.getName());
                            cartItemDatas.add(itemData);
                        }
                    }

                    request.setAttribute("cartItemDatas",cartItemDatas);
                    request.getRequestDispatcher("/buyconfirm.jsp").forward(request, response);
                }else{
                    //最後にアクセスしたページを保存
                    request.setAttribute("message", "カートの利用にはログインが必要です。");
                    session.setAttribute("lastPage", "Cart");
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                }
            }else{
                //最後にアクセスしたページを保存
                request.setAttribute("message", "カートの利用にはログインが必要です。");
                session.setAttribute("lastPage", "Cart");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
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
