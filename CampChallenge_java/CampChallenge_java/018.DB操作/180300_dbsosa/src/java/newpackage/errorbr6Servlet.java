/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.text.SimpleDateFormat;

/**
 *
 * @author stsno
 */
public class errorbr6Servlet extends HttpServlet {

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
            
            
            Connection db_con = null;
            PreparedStatement db_st = null;
            ResultSet db_data = null;
            
            
            try{
                Class.forName("com.mysql.jdbc.Driver").newInstance();
//                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db","root","");
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","rel1123","19951123a");
                System.out.println("MySQLに接続できました");

//                db_st = db_con.prepareStatement("INSERT INTO profiles values(?,?,?,?,?)");
//                db_st.setInt(1,8);
//                db_st.setString(2,"小泉諒馬");
//                db_st.setString(3,"000-0000-0000");
//                db_st.setInt(4,22);
//                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd");
//                db_st.setDate(5,new java.sql.Date(dateFormat .parse("1988年04月01日").getTime()));
//                
//                int i = db_st.executeUpdate();
//                System.out.println("結果："+i);
//                db_con.commit();
                db_st = db_con.prepareStatement("DELETE FROM profiles WHERE profilesID = 6");
                int i2 = db_st.executeUpdate();
                System.out.println("結果："+i2);
                
                
                //データの取得
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

}
