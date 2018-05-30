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
    Date d2 = new Date(116,00,01,00,00,00);
    Date d3 = new Date(116,10,04,10,00,00);
    
    Date d4 = new Date(115,00,01,00,00,00);
    Date d5 = new Date(115,11,31,23,59,59);
    
    Date d6 = new Date(115,00,01,00,00,00);
    Date d7 = new Date(115,00,02,00,00,00);
    
    
    //フォーマット１
    SimpleDateFormat sdf =
            new SimpleDateFormat("yyyy年MM月dd日 HH時mm分ss秒");
        
    //フォーマット２
    SimpleDateFormat sdf2 =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    public long sa(){
        long i = 0;
        i = (long)d5.getTime() - (long)d4.getTime();
        return i;
    }
    
        public long sa2(){
        long i = 0;
        i = (long)d7.getTime() - (long)d6.getTime();
        return i;
    }
    
    
}
