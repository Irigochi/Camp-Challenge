<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%@page import="jums.UserDataBeans"%>
<%
    HttpSession hs = request.getSession();
    
    UserDataBeans udb = (UserDataBeans)session.getAttribute("udb");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録確認画面</title>
    </head>
    <body>
    <%  /*
        4.insertconfirmにて、フォームの内容が未入力であっても通過してしまう場合がある。
          これを通過させないようにし、かつどの項目が不完全なのかをわかるようにしなさい
        */
        //未入力のListの要素数が0であれば、登録確認表示
        if(udb.al().size() == 0){
    %>
        <h1>登録確認</h1>
        名前:<%= udb.getName()%><br>
        生年月日:<%= udb.getYear()+"年"+udb.getMonth()+"月"+udb.getDay()+"日"%><br>
        種別:<%= udb.getTypeString()%><br>
        電話番号:<%= udb.getTell()%><br>
        自己紹介:<%= udb.getComment()%><br>
        上記の内容で登録します。よろしいですか？
        
        <form action="insertresult" method="POST">
            <%--2.insertresultにて直リンク防止用の処理が存在しない。insertからinsertconfirmへの流れを参考に修正しなさい--%>
            <input type="hidden" name="ac" value="<%= hs.getAttribute("ac")%>">
            <input type="submit" name="yes" value="はい">           
        </form>
            
    <% }else{ %>   
        <h1>入力が不完全です</h1>
        下記項目が未入力です<br>
          <%
            //未入力のListに要素がある場合はそれを全て表示
            for(int i = 0; i < udb.al().size(); i++){
                out.print(udb.al().get(i)+"<br>");
            }%>
            
    <% } %>
        <form action="insert" method="POST">
            <input type="submit" name="no" value="登録画面に戻る">
        </form>
        
        <br>
        <%=JumsHelper.getInstance().home()%>
    </body>

</html>
