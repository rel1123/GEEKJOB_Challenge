/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author stsno
 */


//「2016年1月1日 0時0分0秒」の情報を持つタイムスタンプ（ミリ秒）を生成し，画面に表示してください。

public class Stamp {
    Date d1 = new Date();
    Date d2 = new Date(2016,00,01,00,00,00);
    
    //フォーマット
 
        SimpleDateFormat sdf =
                new SimpleDateFormat("yyyy年MM月dd日 HH時mm分ss秒");
        
    
    
    
    public static void main(String[] args){
        //カレンダーインスタンスの作成
        Calendar c = Calendar.getInstance();
        
        c.set(0, 0);
    }
    
}
