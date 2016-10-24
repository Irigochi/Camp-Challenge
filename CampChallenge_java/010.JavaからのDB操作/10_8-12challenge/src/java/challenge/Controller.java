/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import javax.servlet.RequestDispatcher;
import challenge.Model;

/**
 *
 * @author Kouta
 */
public class Controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //各JSPの場所を変数に代入
        final String userSearch = "/WEB-INF/jsp/userSearch.jsp";
        final String userInsert = "/WEB-INF/jsp/userInsert.jsp";
        final String userDelete = "/WEB-INF/jsp/userDelete.jsp";
        final String updateSelect = "/WEB-INF/jsp/updateSelect.jsp";
        final String userUpdate = "/WEB-INF/jsp/userUpdate.jsp";
        final String error = "/WEB-INF/jsp/error.jsp";
        
        request.setCharacterEncoding("UTF-8");
        
        
        //Modelのインスタンス生成
        Model model = new Model();
        
        
        //ここからデータベースの処理
        Connection con = null;
        try{
            //mysqlに接続
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db","root","kirara0918");
            System.out.println("mysqlに接続できました");
            
            
            
            //検索ボタンが押された場合
            if(request.getParameter("button").equals("検索")){
                
                //変数selにmysqlのselect文を代入
                String sel = "select*from profiles where name like ? or age = ? or birthday = ?";
                
                String name = "%"+request.getParameter("searchName")+"%";
                int age = Integer.valueOf(request.getParameter("searchAge"));
                String birth = request.getParameter("searchBirth");

                PreparedStatement ps = con.prepareStatement(sel);
                
                ps.setString(1, name);
                ps.setInt(2, age);
                ps.setDate(3, Date.valueOf(birth));
                
                ResultSet rs = ps.executeQuery();
                
                //検索結果をセッターでmodelのArrayList(複数該当する可能性があるため)に渡す
                while(rs.next()){
                    model.setIDList(rs.getInt("profilesID"));
                    model.setNameList(rs.getString("name"));
                    model.setTellList(rs.getString("tell"));
                    model.setAgeList(rs.getInt("age"));
                    model.setBirthList(rs.getString("birthday"));
                }            
                rs.close();
                ps.close();
                con.close();
                
                //結果をserchResultとしてセット
                request.setAttribute("searchResult", model);
                //検索結果ページへ
                RequestDispatcher rd = request.getRequestDispatcher(userSearch);
                rd.forward(request, response);
                
            
                
                
            //追加ボタンが押された場合    
            }else if(request.getParameter("button").equals("追加")){
                
                //変数insにmysqlのinsert文を代入
                String ins = "insert into profiles(profilesID,name,tell,age,birthday)"
                        + "value(?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(ins);
                
                //取得した項目を変換しつつ変数に代入
                int i = Integer.parseInt(request.getParameter("insertID"));
                String n = request.getParameter("insertName");
                int a = Integer.parseInt(request.getParameter("insertAge"));
                String t = request.getParameter("insertTell");
                String b = request.getParameter("insertBirth");
                
                //(順番,変数)でセット、executeUpdateメソッドでmysqlをアップデート
                ps.setInt(1, i);
                ps.setString(2, n);
                ps.setString(3, t);
                ps.setInt(4, a);
                ps.setDate(5, Date.valueOf(b));
                ps.executeUpdate();
                
                //結果表示のためセッターで各値をmodelに渡す
                model.setID(i);
                model.setName(n);
                model.setTell(t);
                model.setAge(a);
                model.setBirth(b);
                
                ps.close();
                con.close();
                
                //結果をinsertResultとしてセット
                request.setAttribute("insertResult", model);
                //追加結果ページへ
                RequestDispatcher rd = request.getRequestDispatcher(userInsert);
                rd.forward(request, response);
            
              
 
            //削除ボタンが押された場合    
            }else if(request.getParameter("button").equals("削除")){
                String del = "delete from profiles where profilesID = ?";
                PreparedStatement ps = con.prepareStatement(del);
                int id = Integer.valueOf(request.getParameter("delete"));
                
                ps.setInt(1, id);
                ps.executeUpdate();
                model.setID(id);
                
                ps.close();
                con.close();
                
                //結果をdeleteResultとしてセット
                request.setAttribute("deleteResult", model);
                //削除結果ページへ
                RequestDispatcher rd = request.getRequestDispatcher(userDelete);
                rd.forward(request, response);
                
                
                
            //上書きの選択をおされた場合    
            }else if(request.getParameter("button").equals("選択")){
                String sel = "select*from profiles where profilesID = ?";
                PreparedStatement ps = con.prepareStatement(sel);
                int id = Integer.valueOf(request.getParameter("updateID"));
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                
                while(rs.next()){
                    model.setID(rs.getInt("profilesID"));
                    model.setName(rs.getString("name"));
                    model.setTell(rs.getString("tell"));
                    model.setAge(rs.getInt("age"));
                    model.setBirth(rs.getString("birthday"));
                }
                rs.close();
                ps.close();
                con.close();
                
                request.setAttribute("select", model);
                //一度上書き項目確認ページへ
                RequestDispatcher rd = request.getRequestDispatcher(updateSelect);
                rd.forward(request, response);
                
                
                
            //上書きボタンが押された場合    
            }else if (request.getParameter("button").equals("上書き")){
                int id = Integer.valueOf(request.getParameter("updateID"));
                String upd = "update profiles set name = ?, tell = ?, age = ?, birthday = ? where profilesID ="
                        + id;
                PreparedStatement ps = con.prepareStatement(upd);
                
                String n = request.getParameter("updateName");
                int a = Integer.parseInt(request.getParameter("updateAge"));
                String t = request.getParameter("updateTell");
                String b = request.getParameter("updateBirth");
                
                ps.setString(1, n);
                ps.setString(2, t);
                ps.setInt(3, a);
                ps.setString(4, b);
                ps.executeUpdate();
                
                model.setID(id);
                model.setName(n);
                model.setTell(t);
                model.setAge(a);
                model.setBirth(b);
                
                ps.close();
                con.close();
                
                request.setAttribute("updateResult", model);
                RequestDispatcher rd = request.getRequestDispatcher(userUpdate);
                rd.forward(request, response);
            }
            
            
        
        //例外発生時にはエラーページに飛ぶように設定
        }catch(InstantiationException | IllegalAccessException | ClassNotFoundException e){
            RequestDispatcher rd = request.getRequestDispatcher(error);
            rd.forward(request, response);
        }catch(SQLException e){
            RequestDispatcher rd = request.getRequestDispatcher(error);
            rd.forward(request, response);
        }finally{
            if(con != null){
                try{
                    con.close();
                }catch(SQLException e){
                    RequestDispatcher rd = request.getRequestDispatcher(error);
                    rd.forward(request, response);
                }
            }
        }       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
