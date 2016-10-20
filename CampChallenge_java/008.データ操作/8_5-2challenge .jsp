<%-- 
    Document   : 8_2challenge
    Created on : 2016/10/17, 10:27:53
    Author     : Kouta
--%>

<%@page import="java.net.URLEncoder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <%
            request.setCharacterEncoding("UTF-8");
   
            String br = "<br>";
   
            String name = request.getParameter("txtName");
            String gender = request.getParameter("gender");
            String hobby = request.getParameter("hobby");
            
            Cookie cName = new Cookie("NAME",URLEncoder.encode(name, "UTF-8"));
            Cookie cGender = new Cookie("GENDER",URLEncoder.encode(gender,"UTF-8"));
            Cookie cHobby = new Cookie("HOBBY",URLEncoder.encode(hobby,"UTF-8"));
            
            response.addCookie(cName);
            response.addCookie(cGender);
            response.addCookie(cHobby);
            
            out.print("登録情報"+br);
            out.print(name+br);
            out.print(gender+br);
            out.print(hobby+br);
            
        %>

