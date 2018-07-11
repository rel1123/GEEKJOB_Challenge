package jums;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hayashi-s
 */
public class ResultDetail extends HttpServlet {

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
        
        //セッションスタート
        HttpSession session = request.getSession();
        
        try{
            
            request.setCharacterEncoding("UTF-8");//リクエストパラメータの文字コードをUTF-8に変更
            //課題追加箇所３
            //検索するuserIDを取得
            String userID = request.getParameter("id");
            
            //DTOオブジェクトにマッピング。DB専用のパラメータに変換
            UserDataDTO searchData = new UserDataDTO();
            
            //課題追加箇所３
            //userIDを指定して検索
            searchData.setUserID(Integer.valueOf(userID));
            
            UserDataDTO resultData = UserDataDAO .getInstance().searchByID(searchData);
            request.setAttribute("resultData", resultData);
            
            //課題追加箇所５
            //フォーム初期値入力用UDBへ格納
            UserDataBeans udb = new UserDataBeans();
            udb.setName(resultData.getName());
            Date birthday = resultData.getBirthday();
            //バースデイ変換用
            SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
            SimpleDateFormat sdfMonth = new SimpleDateFormat("MM");
            SimpleDateFormat sdfDay = new SimpleDateFormat("dd");
            udb.setYear(sdfYear.format(birthday));
            udb.setMonth(sdfMonth.format(birthday));
            udb.setDay(sdfDay.format(birthday));
            udb.setType(String.valueOf(resultData.getType()));
            udb.setTell(resultData.getTell());
            udb.setComment(resultData.getComment());
            System.out.print("UserDataBeans updated!!");
            

            session.setAttribute("udb", udb);
            session.setAttribute("resultData",resultData);
            session.setAttribute("userID",userID);
            System.out.println("Session updated!!");
            
            
            request.getRequestDispatcher("/resultdetail.jsp").forward(request, response);  
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
