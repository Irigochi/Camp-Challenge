<%-- 
    Document   : updateSelect
    Created on : 2016/10/21, 17:13:02
    Author     : Kouta
--%>
<%@page import="challenge.Model" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            Model model = (Model)request.getAttribute("select");
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
                    out.print("選択されたユーザー<br>");
                    out.print("profilesID:"+model.getID()+"<br>");
                    out.print("name:"+model.getName()+"<br>");
                    out.print("tell:"+model.getTell()+"<br>");
                    out.print("age:"+model.getAge()+"<br>");
                    out.print("birthday:"+model.getBirth()+"<br>");
                    %>
                    <br>
                    <form action="./Controller" method="post">
                        <fieldset>
                            <legend>上書きする情報を入力してください</legend>
                            ID：<input type="text" name="updateID" readonly="" size="3" value="<%out.print(model.getID());%>">
                            名前：<input type="text" name="updateName">
                            年齢：<input type="number" name="updateAge" min="0" max="120"><br>
                            電話番号：<input type="tel" name="updateTell" placeholder="xxx-xxxx-xxxx">
                            生年月日：<input type="text" name="updateBirth" placeholder="1990-01-01">
                            <input type="submit" name="button" value="上書き">
                        </fieldset>
                    </form>
                    
                <%    
                }
            }
        %>
    </center>    
    </body>
</html>
