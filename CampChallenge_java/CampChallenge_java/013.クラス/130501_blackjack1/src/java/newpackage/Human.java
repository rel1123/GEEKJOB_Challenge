/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.util.ArrayList;

/**
 *
 * @author stsno
 */
// 抽象クラスHuman作成
abstract class Human {
    // 抽象メソッドopen
    abstract public int open ();
    //　抽象メソッドsetCard　引数ArrayList
//    メモ用：abstract public ArrayList<String> setCard();//戻り値がArrayListの場合
    abstract public void setCard (ArrayList<String> card);
    //checkSum
    abstract public boolean checkSum ();
    
    // myCards　変数定義（ArrayList）
    ArrayList<String>myCards = new ArrayList<String>();
}
