/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author stsno
 */
public class DbClass {
    Connection db_con = null;
    PreparedStatement db_st = null;
    ResultSet db_data = null;
    
    //表示用
    //["prID","prName","sePrice","puPrice","prType","puType"]
    String[] producKarma = {"prID","prName","sePrice","puPrice","prType","puType"};
    String[][] productData = new String[225][6];
    
  
//int array[][];
//array = new int[2][3];
//array[0][0] = 0;
//array[0][1] = 1;
    //全件検索
    //引数：無し 戻り値：無し
    
    
     public void allSearch(){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/InventoryControl?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","rel1123","19951123a");
                System.out.println("ログイン用 DB接続成功");
            
            //ID検索
            db_st = db_con.prepareStatement("select * from Product");
            db_data = db_st.executeQuery();
                System.out.println(db_data);
            
            //
            
            int i = 0;
            while(db_data.next()){
                for(int i2 = 0; i2 < 6; i2++){
                    productData[i][i2] = db_data.getString(producKarma[i2]);
                    System.out.print("商品データ情報格納["+ i +"]["+ i2 +"]"+ productData[i][i2]);
                }
                i++;
            }
            db_data.close();
            db_st.close();
            db_con.close();
        }catch(SQLException e_sql){
            System.out.println("DB接続失敗（SQL）<br>" + e_sql);
        }catch(Exception e){
            System.out.println("DB接続失敗（通常）<br>" + e);
        }
    }
     
//     {"prID","prName","sePrice","puPrice","prType","puType"};
     public void Insert(int prID, String prName, int sePrice, int puPrice, String prType,String puType){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/InventoryControl?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","rel1123","19951123a");
                System.out.println("ログイン用 DB接続成功");
            
            //レコード追加
            db_st = db_con.prepareStatement("insert into Product Values (?,?,?,?,?,?)");
            db_st.setInt(1, prID);
            db_st.setString(2, prName);
            db_st.setInt(3, sePrice);
            db_st.setInt(4, puPrice);
            db_st.setString(5, prType);
            db_st.setString(6, puType);
            
            int ii = db_st.executeUpdate();
                System.out.println("レコード追加："+ii);
            
            db_st.close();
            db_con.close();
        }catch(SQLException e_sql){
            System.out.println("DB接続失敗（SQL）<br>" + e_sql);
        }catch(Exception e){
            System.out.println("DB接続失敗（通常）<br>" + e);
        }
    }
            
            
            
}
