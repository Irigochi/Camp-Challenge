<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%  /*
    5.insertconfirmからinsertへ再度入力する際に、このままではフォームに値が保持されていない。
      適切な処理を施して、再度入力の際にはフォームに値を保持したままにさせなさい
    */
    //セッションの中身を変数に代入する
    HttpSession hs = request.getSession();
    Object sName = session.getAttribute("name");
    Object sTell = session.getAttribute("tell");
    Object sRadio = session.getAttribute("type");
    Object sYear = session.getAttribute("year");
    Object sMonth = session.getAttribute("month");
    Object sDay = session.getAttribute("day");
    Object sComment = session.getAttribute("comment");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録画面</title>
    </head>
    <body>
    <form action="insertconfirm" method="POST"><%--それぞれの変数を初期値に設定--%>
        名前:
        <input type="text" name="name" 
               value="<%if(sName != null){
                        out.print(sName);}%>">
        <br><br>

        生年月日:　
        <select name="year">
            <option value="">----</option>
            <%
            if(sYear != null){ %>
            <option value="<%= sYear%>" selected><%= sYear%></option>
            <% }     
            for(int i=1950; i<=2010; i++){ %>
            <option value="<%=i%>"> <%=i%> </option>
            <% } %>
        </select>年
        <select name="month">
            <option value="">--</option>
            <%
            if(sMonth != null){ %>
            <option value="<%= sMonth%>" selected><%= sMonth%></option>
            <% }
            for(int i = 1; i<=12; i++){ %>
            <option value="<%=i%>"><%=i%></option>
            <% } %>
        </select>月
        <select name="day">
            <option value="">--</option>
            <%
            if(sDay != null){ %>
            <option value="<%= sDay%>" selected><%= sDay%></option>
            <% }
            for(int i = 1; i<=31; i++){ %>
            <option value="<%=i%>"><%=i%></option>
            <% } %>
        </select>日
        <br><br>

        種別:
        <br>
        <input type="radio" name="type" value="1" <%if(sRadio == null || sRadio.equals("1")){%>checked<%}%>>エンジニア<br>
        <input type="radio" name="type" value="2" <%else if(sRadio.equals("2")){%>checked<%}%>>営業<br>
        <input type="radio" name="type" value="3" <%else if(sRadio.equals("3")){%>checked<%}%>>その他<br>
        <br>

        電話番号:
        <input type="text" name="tell" 
               value="<%if(sTell != null){
                        out.print(sTell);
                        }%>">
        <br><br>

        自己紹介文
        <br>
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%
            if(sComment != null){out.print(sComment);}
        %></textarea><br><br>
        
        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <input type="submit" name="btnSubmit" value="確認画面へ">
    </form>
        
        <br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
