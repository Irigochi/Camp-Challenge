<%@page import="jums.JumsHelper"
        import="jums.UserDataList" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    UserDataList udl = (UserDataList)request.getAttribute("resultData");
    HttpSession hs = request.getSession();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS検索結果画面</title>
    </head>
    <body>
        <h1>検索結果</h1>
        <%if(udl.idListSize() != 0){%>
        <table border=1>
            <tr>
                <th>名前</th>
                <th>生年</th>
                <th>種別</th>
                <th>登録日時</th>
            </tr>            
            <%for(int i = 0; i < udl.idListSize(); i++){%>
            <tr>
                <td><a href="ResultDetail?id=<%= udl.getIdList(i)%>&ac=<%= hs.getAttribute("ac")%>"><%= udl.getNameList(i)%></a></td>
                <td><%= udl.getYear(i)%></td>
                <td><%= jh.exTypenum(udl.getTypeList(i))%></td>
                <td><%= udl.getNewDateList(i)%></td>
            </tr>
            <%}%>
        </table>
        <br>
        <%}else{%>
        <h2>お探しのユーザーは存在しません</h2>
        <%}%>
    </body>
    <form action="Search" method="post">
        <input type="hidden" name="ac" value="<%= hs.getAttribute("ac")%>">
        <input type="submit" name="back" value="検索に戻る" style="width:100px">
    </form><br>
    <%=jh.home()%>
</html>
