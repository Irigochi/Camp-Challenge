<%-- 
    Document   : 8_2challenge
    Created on : 2016/10/17, 10:27:53
    Author     : Kouta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <%
            request.setCharacterEncoding("UTF-8");
   
            String br = "<br>";
   
            String name = request.getParameter("txtName");
            String gender = request.getParameter("gender");
            String syumi = request.getParameter("syumi");
       
            out.print(name+br);
            out.print(gender+br);
            out.print(syumi+br);

        %>

