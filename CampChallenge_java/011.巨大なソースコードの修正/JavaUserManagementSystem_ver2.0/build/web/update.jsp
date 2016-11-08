<%@page import="jums.UserDataDTO"%>
<%@page import="jums.JumsHelper"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataDTO udd = (UserDataDTO)hs.getAttribute("resultData");
    udd.setCalendar();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS変更画面</title>
    </head>
    <body>
    <form action="UpdateConfirm" method="POST">
        名前:
        <input type="text" name="name" value="<%= udd.getName()%>" required="">
        <br><br>

        生年月日:　
        <select name="year" required="">
            <option value="">----</option>
            <% for(int i=1950; i<=2010; i++){ %>
            <option value="<%=i%>" <%if(i == udd.getYear()){%>selected<%}%>><%=i%></option>
            <% } %>
        </select>年
        <select name="month" required="">
            <option value="">--</option>
            <% for(int i = 1; i<=12; i++){ %>
            <option value="<%=i%>" <%if(i == udd.getMonth()){%>selected<%}%>><%=i%></option>
            <% } %>
        </select>月
        <select name="day" required="">
            <option value="">--</option>
            <% for(int i = 1; i<=31; i++){ %>
            <option value="<%=i%>" <%if(i == udd.getDay()){%>selected<%}%>><%=i%></option>
            <% } %>
        </select>日
        <br><br>

        種別:
        <br>
            <% for(int i = 1; i<=3; i++){ %>
            <input type="radio" name="type" value="<%=i%>" <%if(i == udd.getType()){%>checked<%}%> required=""><%=jh.exTypenum(i)%><br>
            <% } %>
        <br>

        電話番号:
        <input type="text" name="tell" value="<%= udd.getTell()%>" required="">
        <br><br>

        自己紹介文
        <br>
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard" required=""><%= udd.getComment()%></textarea><br>
        
        <input type="submit" name="btnSubmit" value="確認画面へ">
        <input type="reset" value="リセット">
        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
    </form>
    <br>
    <form action="ResultDetail" method="POST">
      <input type="submit" name="NO" value="詳細画面に戻る"style="width:100px">
      <input type="hidden" name="ac" value="<%= hs.getAttribute("ac")%>">
    </form>
        <br>
        <%=jh.home()%>
    </body>
</html>
