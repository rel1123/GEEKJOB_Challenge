/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author stsno
 */
class User extends Human {
  
      //　引いたカードを手札にセット
    public void setCard (ArrayList<String> cards){
        for(int i = 0;
                i<cards.size ();
                i++ )
        myCards.add(cards.get(i));
    }
    
    //　引いた数の合計が17未満ならtrue、以上ならfalse

    public boolean checkSum(){
        int sum = 0;
        int i2 = 0;
        //　点数になおして格納
        
        for(int i = 0;
        i < myCards.size ();
        i++ ){
            switch(myCards.get(i)){
                case "A": i2 = 1; break;
                case "2": i2 = 2; break;
                case "3": i2 = 3; break;
                case "4": i2 = 4; break;
                case "5": i2 = 5; break;
                case "6": i2 = 6; break;
                case "7": i2 = 7; break;
                case "8": i2 = 8; break;
                case "9": i2 = 9; break;
                case "10": i2 = 10; break;
                case "J": i2 = 10; break;
                case "Q": i2 = 10; break;
                case "K": i2 = 10; break;
            }
        sum += i2;
        }
        if(sum < 17){
            return true;
        }else{
            return false;
        }
    }

    public int open(){
        int sum = 0;
        int i2 = 0;
        //　点数になおして格納
        
        for(int i = 0;
        i < myCards.size ();
        i++ ){
            switch(myCards.get(i)){
                case "A": i2 = 1; break;
                case "2": i2 = 2; break;
                case "3": i2 = 3; break;
                case "4": i2 = 4; break;
                case "5": i2 = 5; break;
                case "6": i2 = 6; break;
                case "7": i2 = 7; break;
                case "8": i2 = 8; break;
                case "9": i2 = 9; break;
                case "10": i2 = 10; break;
                case "J": i2 = 10; break;
                case "Q": i2 = 10; break;
                case "K": i2 = 10; break;
            }
        sum += i2;
        }
        return sum;
    }
}

