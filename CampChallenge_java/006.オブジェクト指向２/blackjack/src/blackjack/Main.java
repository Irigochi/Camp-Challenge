/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.io.*;

/**
 *
 * @author Kouta
 */
public class Main {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
         
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        
        
        //ディーラーとプレイヤーのインスタンス作成
        Dealer dealer = new Dealer("ディーラー");
        User user = new User("プレイヤー",500);//プレイヤーにはコインのインスタンス変数を入れる
        
        System.out.println("1ゲーム50コイン、ディーラーは16以下の時必ずヒットします");
        
        
      while(user.coin > 0){  //コインが0になったらゲームオーバー
        user.coin = user.coin-50;
        System.out.println("ベット：50、残りコイン："+user.coin);
        
        stop();
        
        
        //ディーラーとプレイヤーに２枚ずつカードを配る
        dealer.deal(dealer);
        dealer.deal(user);
        
        
        //ディーラーの１枚目のカードを表示
        System.out.println("ディーラー");
        System.out.print("1枚目：");
        Card.cardPrint(dealer.hand.get(0));
        System.out.println("");
        
        stop();
        
        
        //プレイヤー側のカードと合計を表示
        System.out.println("プレイヤー");
        System.out.print("1枚目：");
        Card.cardPrint(user.hand.get(0));
        stop();
        System.out.print("2枚目：");
        Card.cardPrint(user.hand.get(1));
        stop();
        System.out.print("合計：");
        System.out.println(user.open());
        
        stop();
        
        //21であればblackjackと表示、以下の処理をスキップ
        if(user.open()==21){
            System.out.println("Blackjack!");
            
            
            
        }else{   
            //21未満のとき、ヒットかスタンドか選択する
            int j = 2;
            OUTER:
            while (user.open() < 21) {
                System.out.println("ヒットなら「h」、スタンドなら「s」を入力してください");
                String choice = br.readLine();
                switch (choice) {
                    case "h":
                        System.out.println("ヒット");
                        dealer.setCard(dealer.hit(user));
                        stop();
                        System.out.print((j+1)+"枚目：");
                        Card.cardPrint(user.hand.get(j));
                        stop();
                        System.out.print("合計：");
                        System.out.println(user.open());
                        j++;    
                        break;
                    case "s":
                        System.out.println("スタンド");
                        break OUTER;
                    default:
                        System.out.println(user.open());
                        break;
                }
            }  
        }
        
        stop();
        
        //21を超えたら負け
        if(user.open() > 21){
            System.out.println("Bust");
            System.out.println("あなたの負けです");
        //21以下ならディーラーのターンへ    
        }else{
            //ディーラーの２枚目と合計を表示
            System.out.println("");
            System.out.println("ディーラー");
            System.out.print("1枚目：");
            Card.cardPrint(dealer.hand.get(0));
            stop();
            System.out.print("2枚目：");
            Card.cardPrint(dealer.hand.get(1));
            stop();
            System.out.print("合計：");
            System.out.println(dealer.open());
            stop();
            
        
            //この時点でディーラーが21だった場合
            if(dealer.open()==21){
                
                //プレイヤーがナチュラルブラックジャック(枚数2枚)であれば引き分け
                if((user.open()==21)&&(user.maisuu()==2)){
                    System.out.println("引き分けです");
                    
                //そうでなければ負け    
                }else{
                    System.out.println("あなたの負けです");  
                }
            //ディーラーが21でなく、プレイヤーがナチュラルブラックジャックであれば勝ち    
            }else if((user.open()==21)&&(user.maisuu()==2)){
                System.out.println("あなたの勝ちです");
                user.coin = user.coin+100;
                
            }else{
                //ディーラーは16以下の時ヒットを続ける
                int n = 2;
                while(dealer.checkSum()){
                    dealer.setCard(dealer.hit(dealer));
                    System.out.print((n+1)+"枚目：");
                    Card.cardPrint(dealer.hand.get(n));
                    n++;
                    stop();
                    System.out.print("合計：");
                    System.out.println(dealer.open());
                    stop();
                }
                
                //judgeメソッドで数値を比較&勝敗によってコイン数を変える
                switch (judge(user.open(),dealer.open())) {
                    case 0:
                        user.coin = user.coin + 100;
                        break;
                    case 1:
                        user.coin = user.coin + 50;
                        break;
                    default:
                        break;
                }
                stop();
            }
        }
        
        //ゲームの続行か終了か選択する
        System.out.println("qで終了、それ以外は続行");
        String conti = br.readLine();
        if(conti.equals("q")){
            break;
        }
        
        //続行の場合は手札、山札をリセット
        user.hand.clear();
        dealer.reset();
    
      }
        System.out.println("GameOver");
        System.exit(0); 
        
    }
    
    
    
    //ジャッジのメソッド
    public static int judge(int p, int d){
        if(d>21){
            System.out.println("ディーラーBust");
            System.out.println("あなたの勝ちです");
            return 0;
        }else if(d>p){
            System.out.println("あなたの負けです");
            return 2;
        }else if(d==p){
            System.out.println("引き分けです");
            return 1;
        }else{
            System.out.println("あなたの勝ちです");
            return 0;
        }
    }
    
    //処理を1秒止めるメソッド
    public static void stop(){
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
        }
    }
    

}
