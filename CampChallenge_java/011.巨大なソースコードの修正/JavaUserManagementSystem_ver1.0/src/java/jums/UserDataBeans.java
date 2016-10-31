/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
3. フォームから受け取ったデータ自体を格納できるJavaBeans(UserDataBeans.java)を作成し、
   これを利用して表示や分岐などをさせなさい(UserDataDTO.javaはデータベース用のJavaBeansなので微妙に違うものです)
*/
package jums;

import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author Kouta
 */
public class UserDataBeans implements Serializable {
    
    private String name;
    private String year;
    private String month;
    private String day;
    private int type;
    private String tell;
    private String comment;
    
    
    public UserDataBeans(){}
    
    
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public String getYear(){
        return this.year;
    }
    public void setYear(String year){
        this.year = year;
    }
    
    public String getMonth(){
        return this.month;
    }
    public void setMonth(String month){
        this.month = month;
    }
    
    public String getDay(){
        return this.day;
    }
    public void setDay(String day){
        this.day = day;
    }
    
    public int getType(){
        return this.type;
    }
    public void setType(int type){
        this.type = type;
    }
    
    public String getTell(){
        return this.tell;
    }
    public void setTell(String tell){
        this.tell = tell;
    }
    
    public String getComment(){
        return this.comment;
    }
    public void setComment(String comment){
        this.comment = comment;
    }
    
    
    //Typeをユーザー向けに文字列表示するためのメソッド
    public String getTypeString(){
        switch(this.type){
            case 1: return "エンジニア";
            case 2: return "営業";
            case 3: return "その他";
            default : return "";
        }
    }
    
    
    //未入力の項目をArrayListにして返すメソッド
    public ArrayList al(){
        ArrayList<String> al = new ArrayList();
        if(this.name.equals("")){
            al.add("名前");
        }
        if(this.year.equals("") || this.year.equals("----") ||
                this.month.equals("") || this.month.equals("--") ||
                this.day.equals("") || this.day.equals("--")){
            al.add("生年月日");
        }
        if(this.type < 1 || this.type > 3){
            al.add("種別");
        }
        if(this.tell.equals("") || this.tell.length() < 7){
            al.add("電話番号");
        }
        if(this.comment.equals("")){
            al.add("自己紹介");
        }
        return al;
    }
    
}
