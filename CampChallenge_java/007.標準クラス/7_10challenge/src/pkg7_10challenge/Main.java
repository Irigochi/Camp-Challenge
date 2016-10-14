/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg7_10challenge;

import java.io.*;
import java.util.*;
import java.text.*;

/**
 *
 * @author Kouta
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        //課題１０
        
        //dateに現在時刻を入れる
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String sdate = sdf.format(date);
        
        //log.txtに開始時刻を記入
        File log = new File("log.txt");
        FileWriter fw = new FileWriter(log);
        FileWriter fwa = new FileWriter(log, true);
        fw.write(sdate + "開始\n");
        fw.close();
        
        //Mathクラス
        double num = -10.5;
        int x = 5;
        int y = 8;
       
        //abs:絶対値を求める
        double abs_num = Math.abs(num);
        System.out.println(num + "の絶対値は" + abs_num);
        
        stop();
       
        //max,min:どちらが大きいか,小さいか求める
        int num_max = Math.max(x, y);
        int num_min = Math.min(x, y);
        System.out.println(x + "と" + y + "は" + num_max + "のほうが大きく" + num_min + "のほうが小さい");
        
        stop();
        
        //pow:累乗した値を求める
        double num_pow = Math.pow(x,y);
        System.out.println(x + "の" + y + "乗は" + num_pow);
        
        stop();
        
        //ceil/floor/round:切り上げ/切り捨て/四捨五入
        System.out.println(num + "の切り上げ：" + Math.ceil(num));
        System.out.println(num + "の切り捨て：" + Math.floor(num));
        System.out.println(num + "の四捨五入：" + Math.round(num));
        
        stop();
        
        //log.txtに終了時刻記入
        Date endDate = new Date();
        sdate = sdf.format(endDate);
        fwa.write(sdate + "終了");
        fwa.close();
        
        //log.txtを読み込んで表示
        FileReader fr = new FileReader(log);
        BufferedReader br = new BufferedReader(fr);
        String str;
        while((str = br.readLine()) != null){
            System.out.println(str);
        }
        br.close();
        
        
    }
    
    //処理を1秒停止するメソッド
    public static void stop(){
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
        }
    }
    
}
