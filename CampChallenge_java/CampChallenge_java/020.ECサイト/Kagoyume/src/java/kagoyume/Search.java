/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import API.API;
import API.SearchData;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
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
public class Search extends HttpServlet {

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
        try  {
            /* TODO output your page here. You may use following sample code. */
            //フォームデータ読み込み
            String query = request.getParameter("query");
            HttpSession session = request.getSession();
            
            //エンコード　URLに使用するため
            query = URLEncoder.encode(query, "UTF-8");
            //APIインスタンス作成
            API api = new API();
            //UrlStringの初期値読み込み生成
            String SarchUrlString = api.SearchAPIbaseUrl();
            //検索部分を追加
            SarchUrlString += "&query="+query;
            //URLからJsonNodeを獲得しデータをSearchDataに格納
            //SearchDataのインスタンスを作成
            ArrayList<SearchData> resultDataAll = new ArrayList<SearchData>();
            for(int i = 0; i<10; i++){
                SearchData resultData = new SearchData();
                resultData.SdAPIMapping(api.getJsonNode(SarchUrlString), i);
                resultDataAll.add(resultData);
                System.out.print(resultData.getName());
                System.out.print(resultData.getImageUrl());
            }
            //最後にアクセスしたページを保存
            session.setAttribute("lastPage", "Search");
            session.setAttribute("lastPageQuery", "?query="+query);
            
            
            request.setAttribute("SearchDataAll",resultDataAll);
            
            request.getRequestDispatcher("/search.jsp").forward(request, response);
            
        }catch(Exception e){
            //何らかの理由で失敗したらエラーページにエラー文を渡して表示。想定は不正なアクセスとDBエラー
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
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
