/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Kouta
 */
public class User extends Human {
    
    //インスタンス変数
    public String name;
    public int point;
    public int coin;
    
    //コンストラクタ
    User(String name, int coin){
        this.name = name;
        this.coin = coin;
        this.point = 0;
    }

    
    //枚数を出すメソッド
    public int maisuu(){
        return hand.size();
    }
    
    
    //数値の合計を計算するメソッド
    public int cardSum(){
        int sum = 0;
        for(int i=0; i<hand.size(); i++){
            sum = sum + Card.cardPoint(Card.cardNumber(hand.get(i)));
        }
        return sum;
    }
    
    
    //手札をクリアするメソッド
    public void reset(){
        hand.clear();
    }
    
    
    //cardSumメソッドをもとに、手札にAがあれば1or11の都合の良い方を選択する
    @Override
    public int open(){
        if((this.hand.contains(1))||(this.hand.contains(14))
                ||(this.hand.contains(27))||(this.hand.contains(40))){
            if(cardSum() > 21){
                return cardSum() - 10;
            }else{
                return cardSum();
            }
        
        }else{
            return cardSum();
        }
    }
    
    
    @Override
    public boolean checkSum(){
        if(open() <= 16){
            return true;
        }else{
            return false;
        }
    }
    

    @Override
    public void setCard(ArrayList<Integer> list){
        for(int i=0; i<list.size(); i++){
            myCards.add(list.get(i));
        }
    }
    

}
