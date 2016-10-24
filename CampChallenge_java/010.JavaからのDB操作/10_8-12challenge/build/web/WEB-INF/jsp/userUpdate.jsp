<%-- 
    Document   : userUpdate
    Created on : 2016/10/21, 17:38:02
    Author     : Kouta
--%>
<%@page import="challenge.Model" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            Model model = (Model)request.getAttribute("updateResult");
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <%
            if(model != null){
                if(model.getID()==0){
                    out.print("ユーザーの追加に失敗しました");                    
                }else{               
                    out.print("下記ユーザー情報を上書きしました<br>");
                    out.print("profilesID:"+model.getID()+"<br>");
                    out.print("name:"+model.getName()+"<br>");
                    out.print("tell:"+model.getTell()+"<br>");
                    out.print("age:"+model.getAge()+"<br>");
                    out.print("birthday:"+model.getBirth()+"<br>");
                }
            }
        %>
    </center>    
    </body>
</html>
