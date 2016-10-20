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
public class challenge2 {    
    public static void main(String[] args) {
                    
           Connection con = null;           
           try{
               Class.forName("com.mysql.jdbc.Driver").newInstance();
               con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db","root","kirara0918");
               System.out.println("mysqlに接続できました");
               
               
               //課題2:前回の課題1で作成したテーブルに自由なメンバー情報を格納する処理を構築してください
               /*
               Statement stm = con.createStatement();
               String ins = "insert into profiles values(8,'テスト','111-1111-1111',100,'2000-12-31')";
               int result = stm.executeUpdate(ins);
               System.out.println("更新件数"+result);
               
               上記のやり方は処理に時間がかかる(?)
               */
               
               String ins = "insert into profiles values(?, ?, ?, ?, ?)";
               PreparedStatement ps = con.prepareStatement(ins);
               
               ps.setInt(1, 6);
               ps.setString(2, "テスト");
               ps.setString(3, "999-9999-9999");
               ps.setInt(4, 99);
               ps.setDate(5, Date.valueOf("1990-01-01"));
               
               int ins_result = ps.executeUpdate();
               System.out.println("更新件数"+ins_result);
               
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
