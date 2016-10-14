/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg7_challenge;

import java.util.*;
import java.text.*;
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
        // TODO code application logic here
        
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int y = cal.get(Calendar.YEAR);
        int m = cal.get(Calendar.MONTH)+1;
        int d = cal.get(Calendar.DAY_OF_MONTH);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String simpleDate = sdf.format(date);
        
        
        //課題2
        System.out.println("課題2");
        
        System.out.println(simpleDate);
        
        System.out.println("");
        
        
        //課題1
        System.out.println("課題1");
        
        cal.set(2016, 0, 1, 0, 0, 0);
        Date calDate = cal.getTime();
        System.out.println(calDate.getTime());
        
        System.out.println("");
        
        
        //課題３
        System.out.println("課題3");
        
        cal.set(2016, 10, 4, 10, 0, 0);
        Date calDate2 = cal.getTime();
        String simpleCal = sdf.format(calDate2);
        System.out.println(simpleCal);
        
        System.out.println("");
        
        
        //課題４
        System.out.println("課題4");
        
        cal.set(2015,0,1,0,0,0);
        Date kadai4_1 = cal.getTime();
        long a = kadai4_1.getTime();
        
        cal.set(2015,11,31,23,59,59);
        Date kadai4_2 = cal.getTime();
        long b = kadai4_2.getTime();
        
        System.out.println(b-a);
        
        System.out.println("");
        
        
        //課題５
        System.out.println("課題5");
        
        String name = "星野宏太";
        System.out.println(name.getBytes().length);
        System.out.println(name.length());
        
        System.out.println("");
        
        
        //課題６
        System.out.println("課題6");
        
        String address = "irgc0918@gmail.com";
        int i = address.indexOf("@");
        System.out.println(address.substring(i));
        
        System.out.println("");
        
        
        //課題７
        System.out.println("課題7");
        
        String kadai_7 = "きょUはぴIえIちぴIのくみこみかんすUのがくしゅUをしてIます";
        kadai_7 = kadai_7.replace("U","う");
        System.out.println(kadai_7.replace("I", "い"));
        
        System.out.println("");
        
        
        //課題8
        File file = new File("sample.txt");
        
        FileWriter fw = new FileWriter(file);
        
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("私の名前は星野宏太です");
        bw.newLine();
        bw.write("1990/4/14　生まれです");
        bw.newLine();
        bw.write("埼玉に住んでいます");
        bw.newLine();
        bw.write("好きな飲み物はコーヒーです");
        bw.newLine();
        
        bw.close();
        
        
        //課題９
        System.out.println("課題9");
        
        FileReader fr = new FileReader(file);
        
        BufferedReader br = new BufferedReader(fr);
        
        String s;
        while((s=br.readLine())!=null){
            System.out.println(s);
        }
        
    }
    
}
