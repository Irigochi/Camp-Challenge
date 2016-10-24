<%-- 
    Document   : userInput
    Created on : 2016/10/20, 18:43:41
    Author     : Kouta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Javaからのデータベース操作</title>
    </head>   
    <body>
    <center>
        <h2>Javaからのデータベース操作</h2>
        <hr>       
        <form action="./Controller" method="post">
            <fieldset>
                <legend>検索</legend>
                名前：<input type="text" name="searchName" value="">
                年齢：<input type="number" name="searchAge" min="0" max="120" value="">
                生年月日：<input type="text" name="searchBirth" placeholder="1990-01-01" value="">
                    <input type="submit" name="button" value="検索">
            </fieldset>
            <br>
            <br>
            <fieldset>
                <legend>追加</legend>
                    ID：<input type="text" name="insertID" size="3">
                    名前：<input type="text" name="insertName">
                    年齢：<input type="number" name="insertAge" min="0" max="120"><br>
                    電話番号：<input type="tel" name="insertTell" placeholder="xxx-xxxx-xxxx">
                    生年月日：<input type="text" name="insertBirth" placeholder="1990-01-01">
                    <input type="submit" name="button" value="追加">
            </fieldset>
            <br>
            <br>
            <fieldset>
                <legend>IDで指定したレコードを削除</legend>
                ID：<input type="text" name="delete" size="3"><input type="submit" name="button" value="削除">
            </fieldset>
            <br>
            <br>
            <fieldset>
                <legend>IDで指定したレコードを上書き</legend>
                ID：<input type="text" name="updateID" size="3">
                <input type="submit" name="button" value="選択">
            </fieldset>
        </form>
    </center>
    </body>
</html>
