<%@page import="java.util.ArrayList"
        import="javax.servlet.http.HttpSession"
        import="jums.JumsHelper"
        import="jums.UserDataBeans"
        import="jums.UserDataDTO"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataDTO udd = (UserDataDTO)hs.getAttribute("resultData");
    UserDataBeans udb = (UserDataBeans)hs.getAttribute("updateUdb");
    ArrayList<String> chkList = udb.chkproperties();
    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録確認画面</title>
    </head>
    <body>
    <% if(chkList.size()==0){ %>
        <h1>上書き確認</h1>
        <h2>変更前</h2>
        名前:<%= udd.getName()%><br>
        生年月日:<%= udd.getYear()+"年"+udd.getMonth()+"月"+udd.getDay()+"日"%><br>
        種別:<%= jh.exTypenum(udd.getType())%><br>
        電話番号:<%= udd.getTell()%><br>
        自己紹介:<%= udd.getComment()%><br>
        登録日時:<%= udd.getNewDate()%><br>
        <br>
        <h2>変更後</h2>
        名前:<%= udb.getName()%><br>
        生年月日:<%= udb.getYear()+"年"+udb.getMonth()+"月"+udb.getDay()+"日"%><br>
        種別:<%= jh.exTypenum(udb.getType())%><br>
        電話番号:<%= udb.getTell()%><br>
        自己紹介:<%= udb.getComment()%><br>
        <br>
        上記の内容で上書きします。よろしいですか？
        <form action="UpdateResult" method="POST">
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            <input type="submit" name="yes" value="はい">
        </form>
    <% }else{ %>
        <h1>入力が不完全です</h1>
        <%=jh.chkinput(chkList) %>
    <% } %>
        <form action="Update" method="POST">
            <input type="submit" name="no" value="記入画面に戻る">
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            <input type="hidden" name="mode" value="REINPUT">
        </form>
            <br>
        <%=jh.home()%>
    </body>
</html>
