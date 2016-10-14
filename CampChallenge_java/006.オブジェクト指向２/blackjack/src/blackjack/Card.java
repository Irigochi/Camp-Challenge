/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author Kouta
 */
public class Card {
    
    
    //カードのマークを指定するメソッド
    public static String cardMark(int num){
        if(num <= 13){
            return "スペード";
        }else if(num <= 26){
            return "クラブ";
        }else if(num <= 39){
            return "ハート";
        }else{
            return "ダイヤ";
        }
    }
    
    
    //カードの数字を指定するメソッド
    public static int cardNumber(int num){
        if(num <= 13){
            return num;
        }else if(num <= 26){
            return num - 13;
        }else if(num <= 39){
            return num - 26;
        }else{
            return num - 39;
        }
    }
    
    
    //マーク+数字を表示するメソッド
    public static void cardPrint(int num){
        System.out.println(cardMark(num)+"の"+cardNumber(num));
    }
    
    
    //カードの持つ得点を指定するメソッド
    public static int cardPoint(int num){
        if(num == 1){       
            return 11;        
        }else if(num < 10){
            return num;
        }else{
            return 10;
        }
    }
   
    
}
