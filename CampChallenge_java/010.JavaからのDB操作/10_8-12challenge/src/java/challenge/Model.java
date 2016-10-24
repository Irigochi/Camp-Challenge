/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge;

import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author Kouta
 */
public class Model implements Serializable {
    
    //インスタンスフィールド
    private int id;
    private String name;
    private String tell;
    private int age;
    private String birth;
    private ArrayList<Integer> idList;
    private ArrayList<String> nameList;
    private ArrayList<String> tellList;
    private ArrayList<Integer> ageList;
    private ArrayList<String> birthList;
    
    //コンストラクタ
    public Model(){
        this.tellList = new ArrayList<>();
        this.nameList = new ArrayList<>();
        this.idList = new ArrayList<>();
        this.ageList = new ArrayList<>();
        this.birthList = new ArrayList<>();
    }
    
    //各フィールドのゲッター・セッター
    //profilesID
    public int getID(){
        return id;
    }
    public void setID(int i){
        this.id = i;
    }
    //name
    public String getName(){
        return name;
    }
    public void setName(String n){
        this.name = n;
    }
    //tell
    public String getTell(){
        return tell;
    }
    public void setTell(String t){
        this.tell = t;
    }
    //age
    public int getAge(){
        return age;
    }
    public void setAge(int a){
        this.age = a;
    }
    //birth
    public String getBirth(){
        return birth;
    }
    public void setBirth(String b){
        this.birth = b;
    }
    //idのリスト
    public int getIDList(int i){
        return idList.get(i);
    }
    public void setIDList(int i){
        this.idList.add(i);
    }
    
    public String getNameList(int i){
        return nameList.get(i);
    }
    public void setNameList(String n){
        this.nameList.add(n);
    }
    
    public String getTellList(int i){
        return tellList.get(i);
    }
    public void setTellList(String t){
        this.tellList.add(t);
    }
    
    public int getAgeList(int i){
        return ageList.get(i);
    }
    public void setAgeList(int a){
        this.ageList.add(a);
    }
    
    public String getBirthList(int i){
        return birthList.get(i);
    }
    public void setBirthList(String b){
        this.birthList.add(b);
    }
    
    public ArrayList total(){
        return idList;
    }
}
