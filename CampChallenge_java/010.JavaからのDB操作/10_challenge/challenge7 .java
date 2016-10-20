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
public class challenge7 {
    public static void main(String[] args) {
                    
           Connection con = null;           
           try{
               Class.forName("com.mysql.jdbc.Driver").newInstance();
               con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db","root","kirara0918");
               System.out.println("mysqlに接続できました");
               
               
               //課題7:profileID=1のnameを「松岡 修造」に、ageを48に、birthdayを1967-11-06に更新してください
               String upd = "update profiles set name=? ,age=? ,birthday=? where profilesID=?";
               String sel = "select*from profiles";
               PreparedStatement ps = con.prepareStatement(upd);
               ps.setString(1, "松岡修造");
               ps.setInt(2, 48);
               ps.setDate(3, Date.valueOf("1967-11-06"));
               ps.setInt(4, 1);
               
               int result = ps.executeUpdate();
               System.out.println("修正件数"+result);
               

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
