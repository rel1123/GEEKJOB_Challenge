/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import java.util.ArrayList;
import javax.servlet.http.HttpSession;



/**
 *
 * @author stsno
 */
public class Helper {
    //カートへのリンクを定数として設定
    private final String CartURL = "Cart";
    private final String LoginURL = "Login";
    private final String mydataURL = "Mydata";
    
    
    public static Helper getInstance(){
        return new Helper();
    }
    
    //トップへのリンクを返却
    public String home(){
        return "<a href=\""+CartURL+"\">カート</a>";
    }
    
    public String burner(){
        return "<a href=\""+CartURL+"\">カート</a>";       
    }
    public String login(){
        return "<a href=\""+LoginURL+"?loginType=login\">ログイン</a>";
    }
    public String logout(){
        return "<a href=\""+LoginURL+"?loginType=logout\">ログアウト</a>";
    }
    public String mydata(){
        return "<a href="+mydataURL+">会員情報</a>";
    }
    
    public String chkinput(ArrayList<String> chkList){
        String output = "";
        for(String val : chkList){
            if(val.equals("name")){
                output += "ユーザー名";
            }
            if(val.equals("password")){
                output += "パスワード";
            }
            if(val.equals("mail")){
                output += "メールアドレス";
            }
            if(val.equals("address")){
                output += "住所";
            }
            output += "が未入力です<br>";
        }
        return output;
    }
}


