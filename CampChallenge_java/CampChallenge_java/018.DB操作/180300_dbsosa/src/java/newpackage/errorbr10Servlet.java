package newpackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.text.SimpleDateFormat.*;
import java.util.Date;

/**
 *
 * @author stsno
 */
public class errorbr10Servlet extends HttpServlet {

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
            out.println("<title>Servlet errorbr3Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            //変数定義
            Connection db_con = null;
            PreparedStatement db_st = null;
            ResultSet db_data = null;
            
            String sName = null;
            
            
            String n2ProfilesID = null;
            String n2Name = null;
            String n2Tel = null;
            String n2Age = null;
            String n2Birthday = null;
            
            String d2ProfilesID = null;
            
            
            int nProfilesID = 0;
            String nName = null;
            String nTel = null;
            int nAge = 0;
            String nBirthday = null;
            
            int dProfilesID = 0;
            
            
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd");
            SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
            
            //htmlから情報を受け取る
            //受け取るパラメータの文字コード
            response.setContentType("text/html; charset=Windows-31J");
            request.setCharacterEncoding("UTF-8");
            //一度格納
            n2ProfilesID = request.getParameter("nProfilesID");
            System.out.println("フォームデータ格納 n2ProfilesID："+n2ProfilesID);
            n2Name = request.getParameter("nName");
            System.out.println("フォームデータ格納 n2Name："+n2Name);
            n2Tel = request.getParameter("nTel");
            System.out.println("フォームデータ格納 n2Tel："+n2Tel);
            n2Age = request.getParameter("nAge");
            System.out.println("フォームデータ格納 n2Age："+n2Age);
            n2Birthday = request.getParameter("nBirthday");
            System.out.println("フォームデータ格納 n2Birthday："+n2Birthday);
            
            d2ProfilesID = request.getParameter("dProfilesID");
            System.out.println("フォームデータ格納 dProfilesID："+d2ProfilesID);
            
            
            
            
            
//            sName = request.getParameter("name");
//            System.out.print("フォームデータName："+sName);
            if(n2ProfilesID != null){
                if(!(n2ProfilesID.equals(""))){
                nProfilesID = Integer.valueOf(n2ProfilesID);
                System.out.println("フォームデータnProfilesID："+nProfilesID);
                }

                if(!(n2Name.equals(""))){
                nName = n2Name;
                System.out.println("フォームデータnName："+nName);
                }

                if(!(n2Tel.equals(""))){
                nTel = n2Tel;
                System.out.println("フォームデータnTel："+nTel);
                }

                if(!(n2Age.equals(""))){
                nAge = Integer.valueOf(n2Age);
                System.out.println("フォームデータnAge："+nAge);
                }

                if(!(n2Birthday.equals(""))){
                nBirthday = n2Birthday;

    //            nBirthday = dateFormat2.parse(request.getParameter("nBirthday"));
    //            nBirthday = request.getParameter("nBirthday");
                System.out.println("フォームデータnBirthday："+nBirthday);
                }
            }
            
            if(d2ProfilesID != null){
                if(!(d2ProfilesID.equals(""))){
                    dProfilesID = Integer.valueOf(d2ProfilesID);
                    System.out.println("フォームデータ格納 dProfilesID"+dProfilesID);
                }
            }
            
            
            try{
                Class.forName("com.mysql.jdbc.Driver").newInstance();
//                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db","root","");
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","rel1123","19951123a");
                System.out.println("MySQLに接続できました");
                
                //レコードの追加
                if(n2ProfilesID != null){
                    if(!((n2ProfilesID.equals(""))) && !(n2Name.equals("")) && !(n2Tel.equals("")) && !(n2Age.equals("")) && !(n2Birthday.equals(""))){
                        db_st = db_con.prepareStatement("INSERT INTO profiles values(?,?,?,?,?)");
                        db_st.setInt(1,nProfilesID);
                        db_st.setString(2,nName);
                        db_st.setString(3,nTel);
                        db_st.setInt(4,nAge);
                        db_st.setDate(5,new java.sql.Date(dateFormat2.parse(nBirthday).getTime()));
        //                db_st.setDate(5,new java.sql.Date(dateFormat .parse("1988年04月01日").getTime()));

                        int i = db_st.executeUpdate();
                        System.out.println("結果："+i);
        //                db_con.commit();
                    }
                }
                
                //レコードの削除
                if(d2ProfilesID != null){
                    if(!(d2ProfilesID.equals(""))){
                        db_st = db_con.prepareStatement("DELETE FROM profiles WHERE profilesID =" + dProfilesID);
                        int i2 = db_st.executeUpdate();
                        System.out.println("結果："+i2);
                    }
                }
//                //特定レコードの更新
//                db_st = db_con.prepareStatement("UPDATE profiles SET name = '明日 晴', tel = '222-2222-2222', age = 25, birthday = '1999-11-11' WHERE profilesID = 1");
//                int i3 = db_st.executeUpdate();
//                System.out.println("結果："+i3);

                //データの取得
                //フォームデータから検索
//                db_st = db_con.prepareStatement("select * from profiles where name like '%"+sName+"%'");
                db_st = db_con.prepareStatement("select * from profiles");
//                db_st.setInt(1, 33);               
                
                db_data = db_st.executeQuery();
                while(db_data.next()){
                    out.print("プロフィールID："+db_data.getInt("profilesID")+" ");
                    out.print("名前："+db_data.getString("name")+" ");
                    out.print("電話番号："+db_data.getString("tel")+" ");
                    out.print("年齢："+db_data.getInt("age")+" ");
                    out.print("誕生日："+db_data.getDate("birthday")+"<br>");

                }
                db_data.close();
                db_st.close();
                db_con.close();
            } catch(SQLException e_sql) {
                out.println("接続時にエラーが発生しました"+e_sql.toString());
            } catch (Exception e) {
                out.println("接続時にエラーが発生しました"+e.toString());
            } finally {
                if (db_con != null){
                    try {
                        db_con.close();
                    } catch (Exception e_con) {
                        System.out.println(e_con.getMessage());
                    }
                }
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

    private int valueOf(String parameter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
