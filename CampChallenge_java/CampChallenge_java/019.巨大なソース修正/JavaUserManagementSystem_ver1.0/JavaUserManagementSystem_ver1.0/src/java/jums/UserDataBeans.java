package jums;

import java.io.Serializable;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author stsno
 */
//ユーザーデータJavaBeans
//シリアライズ可能
public class UserDataBeans implements Serializable {
    //publicで引数無しのコンストラクタ
    public UserDataBeans(){}
    //隠匿フィールド
    private String test = null;
    
    private String name = "";
    private String year = "0000";
    private String month = "00";
    private String day = "00";
    private String tell = "";
    private String type = "0";
    private String comment = "";

    
    
    public String getName() {   
        return name;
    }
    public void setName(String name) {
        if(!name.equals("")){
            this.name = name;
        }
    }

    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        //引数が空白の場合処理しない
        //これにより空白が入れられることを防げるintへの変換も大丈夫
        if(!year.equals("")){
            this.year = year;
        }
    }
    
    public String getMonth() {
        return month;
    }
    public void setMonth(String month) {
        //引数が空白の場合処理しない
        if(!month.equals("")){
            this.month = month;
        }
    }
    
    public String getDay() {
        return day;
    }
    public void setDay(String day) {
        //引数が空白の場合処理しない
        if(!day.equals("")){
            this.day = day;
        }
    }
    
    public String getTell() {
        return tell;
    }
    public void setTell(String tell) {
        if(!tell.equals("")){
            this.tell = tell;
        }
    }
    
    public String getType() {
        return type;
    }
    public void setType(String type) {
        if(!type.equals("")){
            this.type = type;
        }
    }
    
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        if(!comment.equals("")){
            this.comment = comment;
        }
    }
    
    
}
