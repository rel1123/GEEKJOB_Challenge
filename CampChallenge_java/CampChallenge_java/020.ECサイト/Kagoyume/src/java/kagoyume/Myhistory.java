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
public class Myhistory extends HttpServlet {

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
        HttpSession session = request.getSession();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            UserDataDTO udd = (UserDataDTO)session.getAttribute("loginUserData");
            try{
                
            
            ArrayList<ItemData> buyItemDatas = new ArrayList<ItemData>();
            ArrayList<String[]> buyData = UserDataDAO.getInstance().buySearchByUserID(udd);
            
            for(int i = 0; i < buyData.size(); i++){
                //商品コード読み込み
                String code = buyData.get(i)[0];

                API api = new API();
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
                buyItemDatas.add(itemData);
                
                request.setAttribute("buyItemDatas", buyItemDatas);
            }
            }catch(Exception e){
                
            }
            request.getRequestDispatcher("/myhistory.jsp").forward(request, response);
            
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
