<%@page import="jums.UserDataList"%>
<%@page import="jums.JumsHelper" %>
<%
    HttpSession hs = request.getSession();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>削除結果画面</title>
    </head>
    <body>
    <h1>削除確認</h1>
    削除しました。<br>
    <form action="SearchResult" method="post">
      <input type="submit" name="NO" value="検索結果に戻る" style="width:100px">
      <input type="hidden" name="ac" value="<%= hs.getAttribute("ac")%>">
      <input type="hidden" name="name" value="<%= request.getAttribute("name")%>">
      <input type="hidden" name="year" value="<%= request.getAttribute("year")%>">
      <input type="hidden" name="type" value="<%= request.getAttribute("type")%>">
    </form><br>
    <%=JumsHelper.getInstance().home()%>
    </body>
</html>
