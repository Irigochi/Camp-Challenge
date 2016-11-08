<%@page import="jums.UserDataBeans"%>
<%@page import="jums.JumsHelper" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    UserDataBeans udb = (UserDataBeans)request.getAttribute("updateUdb");
    int id = (Integer)request.getAttribute("updateID");
    HttpSession hs = request.getSession();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS更新結果画面</title>
    </head>
    <body>
        <h1>変更結果</h1>
        名前:<%= udb.getName()%><br>
        生年月日:<%= udb.getYear()+"年"+udb.getMonth()+"月"+udb.getDay()+"日"%><br>
        種別:<%= jh.exTypenum(udb.getType())%><br>
        電話番号:<%= udb.getTell()%><br>
        自己紹介:<%= udb.getComment()%><br>
        以上の内容でユーザー情報を変更しました。<br>
    </body>
    <br>
    <form action="SearchResult" method="post">
      <input type="submit" name="NO" value="検索結果に戻る" style="width:100px">
      <input type="hidden" name="ac" value="<%= hs.getAttribute("ac")%>">
      <input type="hidden" name="name" value="<%= request.getAttribute("name")%>">
      <input type="hidden" name="year" value="<%= request.getAttribute("year")%>">
      <input type="hidden" name="type" value="<%= request.getAttribute("type")%>">
    </form>
    <br>
    <%=jh.home()%>
    </body>
</html>
