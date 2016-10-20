/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.sql.*;

/**
 *
 * @author Kouta
 */
public class challenge6 {
    public static void main(String[] args) {
                    
           Connection con = null;           
           try{
               Class.forName("com.mysql.jdbc.Driver").newInstance();
               con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db","root","kirara0918");
               System.out.println("mysqlに接続できました");
               
               
               //課題6:課題2でINSERTしたレコードを指定して削除してください。SELECT*で結果を表示してください
               String del = "delete from profiles where profilesID = ?";
               String sel = "select*from profiles";
               PreparedStatement ps = con.prepareStatement(del);
               ps.setInt(1, 6);
               
               int result = ps.executeUpdate();
               System.out.println("削除件数"+result);
               
               ps = con.prepareStatement(sel);
               ResultSet rs = ps.executeQuery();
               while(rs.next()){
                   int id = rs.getInt("profilesID");
                   String name = rs.getString("name");
                   String tell = rs.getString("tell");
                   int age = rs.getInt("age");
                   String birth = rs.getString("birthday");
                   
                   System.out.println("処理結果");
                   System.out.println("ID:"+id+"/名前:"+name+
                           "/電話番号:"+tell+"/年齢:"+age+"/生年月日:"+birth);
               }
               
               
               rs.close();
               ps.close();
               con.close();
               
               
           }catch(InstantiationException | IllegalAccessException | ClassNotFoundException e){
               System.out.println("JDBCドライバのロードに失敗しました");
           }catch(SQLException e){
               System.out.println("mysqlに接続できませんでした");
           }finally{
               if(con != null){
                   try{
                       con.close();
                   }catch(SQLException e){
                       System.out.println("mysqlのクローズに失敗しました");
                   }
               }
           }
       }
}
