<%-- 
    Document   : 8_1challenge
    Created on : 2016/10/14, 16:49:36
    Author     : Kouta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Javaでのデータ操作課題</title>
    </head>
    <body>
        <form action="./8_2challenge.jsp" method="post">
            
            氏名<input type="text" name="txtName"><br>
            
            男<input type="radio" name="gender" value="男"><br>
            女<input type="radio" name="gender" value="女"><br>
            
            趣味<textarea name="syumi"></textarea><br>
            
            <input type="submit" value="送信"><br>
            
        </form>
        
    </body>
</html>

