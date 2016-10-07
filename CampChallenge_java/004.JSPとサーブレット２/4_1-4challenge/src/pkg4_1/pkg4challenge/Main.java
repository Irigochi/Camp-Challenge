
package pkg4_1.pkg4challenge;

import java.util.ArrayList;

public class Main {

   
    public static void main(String[] args) {
        
        //課題1,4
        for(int i = 0; i < 10; i++){
            Main.profile("john", "1993/10/10", "好きなスポーツはサッカーです");
        }
        
        //課題2
        Main.Even(123);
        
        //課題3
        Main.test(8,9==9);
        
        int id = 123;
        for(int i=1;i< Main.info(id).length;i++){
            System.out.println(Main.info(id)[i]);
        }

        
    }
    
    //課題1,4:自己紹介文を出力し、真偽値を返すメソッド
    public static boolean isProfile(String name, String birth, String text){
        System.out.println("名前："+name);
        System.out.println("生年月日："+birth);
        System.out.println("自己紹介："+text);
        return true;
    }
    
    //課題4:上の真偽値に応じて処理の成否を出力するメソッド
    public static void profile(String name, String birth, String text){
        if(isProfile(name,birth,text)){
            System.out.println("この処理は正しく実行できました");
        }else{
            System.out.println("この処理は実行できませんでした");
        }
        System.out.println("");
    }
    
    //課題2:偶数と奇数を判断するメソッド
    public static void Even(int num){
        System.out.print(num+"は");
        if(num % 2 == 0){
            System.out.println("偶数です");
        }else{
            System.out.println("奇数です");
        }
        System.out.println("");
    }
    
    //課題3
    public static void test(int x, int y, boolean z){
        int num = x * y;
        if(z){
            System.out.println(num *num);
        }else{
            System.out.println(num);
        }
        System.out.println("");
    }
    //上のメソッドの2,3番目の引数のデフォルト値
    public static void test(int x, int y){
        Main.test(x, y, false);
    }
    public static void test(int x, boolean z){
        Main.test(x, 5, z);
    }
    public static void test(int x){
        Main.test(x, 5, false);
    }
    
    
    public static String[] info(int num){
        String id = String.valueOf(num);
        String[] infoA = {"123","A太","1990/1/1","東京"};
        String[] infoB = {"987","B子","2000/12/31","沖縄"};
        String[] infoJ = {"555","John","1930/10/10",null};
        String[] infoNone = {"そのIDは存在しません"};
        
        if(id.equals(infoA[0])){
            return infoA;
        }else if(id.equals(infoB[0])){
            return infoB;
        }else if(id.equals(infoJ[0])){
            return infoJ;
        }else{
            return infoNone;
        }
    }
    
    
}
