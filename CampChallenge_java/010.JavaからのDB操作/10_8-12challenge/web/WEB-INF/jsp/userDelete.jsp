<%-- 
    Document   : userDelete
    Created on : 2016/10/21, 16:52:26
    Author     : Kouta
--%>
<%@page import="challenge.Model" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            Model model = (Model)request.getAttribute("deleteResult");
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <%
            out.print("profilesID:"+model.getID()+"のユーザーを削除しました");
        %>
    </center>    
    </body>
</html>
