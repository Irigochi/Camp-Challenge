/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Kouta
 */
public class Dealer extends Human {
    
    //インスタンス変数
    public ArrayList<Integer> cards = new ArrayList<>();
    public String name;
    public int point;
    public int coin;
    
    //コンストラクタ
    Dealer(String name){
        this.name = name;
        this.point = 0;
        for(int i=0; i<52; i++){
            cards.add(i+1);
            Collections.shuffle(cards);
        }    
    }
    
    
    //山札から2枚を"x"の手札(配列)に追加してリターン
    public ArrayList deal(Human x){
        x.hand.add(cards.get(0));
        cards.remove(0);
        x.hand.add(cards.get(0));
        cards.remove(0);
        return x.hand;
    }
    
    
    //山札から1枚を"x"の手札(配列)に追加してリターン
    public ArrayList hit(Human x){
        x.hand.add(cards.get(0));
        cards.remove(0);
        return x.hand;
    }
    
    
    
    //山札と手札をクリアし、再度山札を作るメソッド
    public void reset(){
        cards.clear();
        hand.clear();
        for(int i=0; i<52; i++){
            cards.add(i+1);
            Collections.shuffle(cards);
        }
    }
    
    
    //数値の合計を計算するメソッド
    public int cardSum(){
        int sum = 0;
        for(int i=0; i<hand.size(); i++){
            sum = sum + Card.cardPoint(Card.cardNumber(hand.get(i)));
        }
        return sum;
    } 
    
    
    //cardSumメソッドをもとに、手札にAがあれば1or11の都合の良い方を選択する
    @Override
    public int open(){
        if((this.hand.contains(1))||(this.hand.contains(14))
                ||(this.hand.contains(27))||(this.hand.contains(33))){
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
