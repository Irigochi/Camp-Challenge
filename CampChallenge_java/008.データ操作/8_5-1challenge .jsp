<%-- 
    Document   : 8_1challenge
    Created on : 2016/10/14, 16:49:36
    Author     : Kouta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession" 
        import="javax.servlet.http.Cookie" 
        import="java.util.Date" 
        import="java.text.*"
        import="java.net.URLDecoder"%>

<%
    request.setCharacterEncoding("UTF-8");
    
    String name = "";
    String gender = "";
    String hobby = "";
        
    Cookie cs[] = request.getCookies();
    
    if(cs != null){
        for(int i=0; i<cs.length; i++){
            if(cs[i].getName().equals("NAME")){
                name = URLDecoder.decode(cs[i].getValue(),"UTF-8");
            }else if(cs[i].getName().equals("GENDER")){
                gender = URLDecoder.decode(cs[i].getValue(),"UTF-8");
            }else if(cs[i].getName().equals("HOBBY")){
                hobby = URLDecoder.decode(cs[i].getValue(),"UTF-8");
            }
        }
    }
    
%>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Javaでのデータ操作課題</title>
    </head>
    <body>        
        <form action="./8_5-2challenge.jsp" method="post">
            <center>
                <h2>データ操作課題 応用編</h2>
                
                </h3>
                <hr>
                氏名：<input type="text" name="txtName" value="<%=name%>"><br>
                
                <hr>
            
                男<input type="radio" name="gender" value="男" 
                        <%if(gender.equals("男")){%>
                            checked
                        <%}%>>
                女<input type="radio" name="gender" value="女"
                        <%if(gender.equals("女")){%>
                            checked
                        <%}%>><br>
            
                <hr>
            
                趣味：<textarea name="hobby"><%=hobby%></textarea><br>
            
                <input type="submit" value="送信"><br>
            </center>
        </form>        
    </body>
</html>

