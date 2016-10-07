
package pkg4_5.pkg8challenge;

import java.util.ArrayList;



public class Person {
    
    //インスタンスのリスト
    public static ArrayList<Person> userList = new ArrayList<Person>();
    
    //インスタンスフィールド
    public int id;
    public String name;
    public String birth;
    public String address;
    
    //コンストラクタ
    Person(int id, String name, String birth, String address){
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.address = address;
        userList.add(this);
    }
    
    
    //1つのインスタンスの情報を配列にするメソッド
    //インスタンス変数の呼び出しはインスタンス名.変数名
    public static String[] userInfo(Person user){
        String s_id = String.valueOf(user.id);
        String[] userinfo = new String[4];
        userinfo[0] = s_id;
        userinfo[1] = user.name;
        userinfo[2] = user.birth;
        userinfo[3] = user.address;
        return userinfo;
    }
    
    
    //上の配列を並べて表示するメソッド(null)はスキップ
    public static void printInfo(String[] x){
        for(int i=1;i<x.length;i++){
            if(x[i]==null){
                continue;
            }else{
                System.out.println(x[i]);
            }
        }
    }
    
    
    public static void oneInfo(int number){
        String num = String.valueOf(number);
        for(int i=0;i<userList.size();i++){
            if(num.equals(userInfo(userList.get(i))[0])){
                printInfo(userInfo(userList.get(i)));
                break;
            }
        }
    }
    
    
    public static void allInfo(){
        int limit = 2;
        for(int i=0; i<limit; i++){
            userList.get(i).printInfo(userList.get(i).userInfo(userList.get(i)));
            System.out.println("");
        }
    }
    
}
