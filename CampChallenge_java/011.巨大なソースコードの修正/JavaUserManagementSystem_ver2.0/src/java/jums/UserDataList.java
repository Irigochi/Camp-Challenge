/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
/**
 * 複数のユーザー情報をArrayListで持ちまわる
 * @author Kouta
 */
public class UserDataList {
    
    private final ArrayList<Integer> idList;
    private final ArrayList<String> nameList;
    private final ArrayList<Date> birthdayList;
    private final ArrayList<String> tellList;
    private final ArrayList<Integer> typeList;
    private final ArrayList<String> commentList;
    private final ArrayList<Timestamp> newDateList;
    
    public UserDataList(){
        this.idList = new ArrayList();
        this.nameList = new ArrayList();
        this.birthdayList = new ArrayList();
        this.tellList = new ArrayList();
        this.typeList = new ArrayList();
        this.commentList = new ArrayList();
        this.newDateList = new ArrayList(); 
    }
    
    public int idListSize(){
        return this.idList.size();
    }
    
    public int getIdList(int i){
        return this.idList.get(i);
    }
    public void addIdList(int i){
        this.idList.add(i);
    }
    
    public String getNameList(int i){
        return this.nameList.get(i);
    }
    public void addNameList(String s){
        this.nameList.add(s);
    }
    
    public Date getBirthdayList(int i){
        return this.birthdayList.get(i);
    }
    public void addBirthdayList(Date d){
        this.birthdayList.add(d);
    }
    
    public String getTellList(int i){
        return this.tellList.get(i);
    }
    public void addTellList(String s){
        this.tellList.add(s);
    }
    
    public int getTypeList(int i){
        return this.typeList.get(i);
    }
    public void addTypeList(int i){
        this.typeList.add(i);
    }
    
    public String getCommentList(int i){
        return this.commentList.get(i);
    }
    public void addCommentList(String s){
        this.commentList.add(s);
    }
    
    public Timestamp getNewDateList(int i){
        return this.newDateList.get(i);
    }
    public void addNewDateList(Timestamp t){
        this.newDateList.add(t);
    }
    
    //生年のみ表示するためのメソッド
    public int getYear(int i){
        Calendar cal = Calendar.getInstance();
        cal.setTime(this.birthdayList.get(i));
        int year = cal.get(Calendar.YEAR);
        return year;
    }
}