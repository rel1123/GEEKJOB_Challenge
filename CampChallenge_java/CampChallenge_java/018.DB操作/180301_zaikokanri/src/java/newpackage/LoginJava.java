/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.sql.*;
/**
 *
 * @author stsno
 */
public class LoginJava {
    
    //変数等定義
    Connection db_con = null;
    PreparedStatement db_st = null;
    ResultSet db_data = null;

    
    
    
    public LoginJava(){
//    db_con = null;
//    db_st = null;
//    db_data = null;
    
    }
    //ログインの判定
    //IDとPWを入力し1=ログイン成功,2=失敗(ID),3=失敗(PW),4=失敗(DB),5=失敗(sqlエラー),6=失敗(その他のエラー)を返す
    public int loginType(String ID,String PW){
        String aPassword = null;
        Boolean dbError = false;

        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/InventoryControl?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","rel1123","19951123a");
            System.out.println("ログイン用 DB接続成功");
            
            //ID検索
            db_st = db_con.prepareStatement("select * from User where usID = ?");
            db_st.setString(1, ID);
            db_data = db_st.executeQuery();
            System.out.println(db_data);
            
            //
            while(db_data.next()){
                int n =1;
                if(n != 1){
                    dbError = true;
                }else{
                aPassword = db_data.getString("password");
                System.out.println("正解パスワード格納");
                }
                n++;
            }
            db_data.close();
            db_st.close();
            db_con.close();
            
            
            if(!dbError){
                if(aPassword != null){
                    System.out.println("ID一致");
                    if(PW.equals(aPassword)){
                        System.out.println("ログイン成功");
                        return 1;

                    }else{
                        System.out.println("パスワードが不正です");
                        return 3;
                    }

                }else{
                    System.out.print("IDが不正です");
                    return 2;
                }
            }else{
                System.out.println("データベースが不正です");
                return 4;
            }
//            db_data.close();
//            db_st.close();
//            db_con.close();
            
            
        }catch(SQLException e_sql){
            System.out.println("DB接続失敗（SQL）<br>" + e_sql);
            return 5;
        }catch(Exception e){
            System.out.println("DB接続失敗（通常）<br>" + e);
            return 6;
        }

        
    }
    
    public boolean login (int loginType){
        if(loginType == 1){
            return true;
        }else{
            return false;
        }
    }
    public String loginLog(int loginType){
        switch(loginType){
            case 0:
                return "プログラムエラー（loginTypeにデータが格納されていません）";
            case 1:
                return "ログインに成功しました";
            case 2:
                return "ユーザー名が間違っています";
            case 3:
                return "パスワードが間違っています";
            case 4:
                return "データベースエラー(ユーザー重複登録)";
            case 5:
                return "データベースエラー(mysqlへ接続できません)";
            case 6:
                return "プログラミングエラー(データベース接続処理のコード)";
            default:
                return "プログラムエラー(loginTypeが間違っています)";
        }            
    } 
    

}
