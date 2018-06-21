/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.Serializable;

/**
 *
 * @author stsno
 */
public class ResultData implements Serializable{
    private String loginLog = "";
    private String[][] productData = new String[225][6];
    
    public ResultData(){}
    public String getLoginLog() {
        return this.loginLog;}
    public void setLoginLog(String n){
        this.loginLog = n;}
    
    public String[][] getProductData(){
        return this.productData;
    }
    public void setProductData(String[][] n){
        this.productData = n;
    }
    
}
