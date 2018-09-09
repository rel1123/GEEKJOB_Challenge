/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author stsno
 */
public class UserData implements Serializable{
public UserData(){}

private String name;
private String password;
private String mail;
private String address;
/* 
 * UserDataからUserDataDTOへ変換を行うメソッド
*/
 public void UD2DTOMapping(UserDataDTO udd){
        udd.setName(this.name);
        udd.setPassword(this.password);
        udd.setMail(this.mail);
        udd.setAddress(this.address);
    }
 
 /*
  * UserDataDTOからUserDataへ変換を行うメソッド
 */
 public void DTO2UDMapping(UserDataDTO udd){
    this.name = udd.getName();
    this.password = udd.getPassword();
    this.mail = udd.getMail();
    this.address = udd.getAddress();
}
 
     public ArrayList<String> chkproperties(){
        ArrayList<String> chkList = new ArrayList<String>();
        if(this.name.equals("")){
            chkList.add("name");
        }
        if(this.password.equals("")){
            chkList.add("password");
        }
        if(this.mail.equals("")){
            chkList.add("mail");
        }
        if(this.address.equals("")){
            chkList.add("address");
        }
        
        return chkList;
    }


public String getName(){return this.name;}
public void setName(String name){this.name = name;}

public String getPassword(){return this.password;}
public void setPassword(String password){this.password = password;}

public String getMail(){return this.mail;}
public void setMail(String mail){this.mail = mail;}

public String getAddress(){return this.address;}
public void setAddress(String address){this.address = address;}

 }
