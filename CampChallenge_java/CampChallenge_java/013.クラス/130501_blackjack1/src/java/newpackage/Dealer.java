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
class Dealer extends Human {
    //　cardsフィールド
    ArrayList<String>cards = new ArrayList<String>();
    
    //　インスタンス作成時に実行（初期処理/コンストラクタ）
    public Dealer(){
        //　カードの初期設定
        //　１～Kを４回セット
        for(int i = 0;
                i < 4;
                i++){
            cards.add("A");
            cards.add("2");
            cards.add("3");
            cards.add("4");
            cards.add("5");
            cards.add("6");
            cards.add("7");
            cards.add("8");
            cards.add("9");
            cards.add("10");
            cards.add("J");
            cards.add("Q");
            cards.add("K");
            }
    }
    
    //　deal（公開メソッド）
    //　ランダムで２枚のカードを変えす処理
    public ArrayList<String> Dial(){
        Random rand = new Random();
        ArrayList<String>dial = new ArrayList<String>();
        
        //　cardsからランダムで１枚のカードを拾う
        Integer indexA = rand.nextInt(cards.size());
        //　一時格納
        dial.add(cards.get(indexA));
        //　int型へ変換
        int iA = indexA;
        //　山札削除
        this.cards.remove(iA);
        
        //　cardsからランダムで１枚のカードを拾う
        Integer indexB = rand.nextInt(cards.size());
        //　一時格納
        dial.add(cards.get(indexB));
        //　int型へ変換
        int iB = indexB;
        //　山札削除
        this.cards.remove(iB);

        //　戻り値設定
        return dial;
        
    }
    
    //　hit（公開メソッド）
    //　ランダムで１枚のカードを返す処理
    public ArrayList<String> hit(){
        Random rand = new Random();
        //　cardsからランダムで1枚のカードを拾う
        Integer indexA = rand.nextInt(cards.size());
        //　配列dialに一度格納
        ArrayList<String>i1 = new ArrayList<String>();
        i1.add(cards.get(indexA));
        //　int型へ変換
        int iA = indexA;
        //　山札削除
        this.cards.remove(iA);        
        //　戻り値設定
        return i1;        
    }
    
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

