<%-- 
    Document   : userView
    Created on : 2016/10/20, 18:53:13
    Author     : Kouta
--%>
<%@page import="challenge.Model" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            Model model = (Model)request.getAttribute("searchResult");
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <%
            if(model != null){
                if(model.getIDList(0)== 0){
                    out.print("そのユーザーは存在しません");                    
                }else{               
                    out.print("検索結果<br><br>");
                    for(int i=0; i<model.total().size(); i++){
                        out.print("profilesID:"+model.getIDList(i)+"<br>");
                        out.print("name:"+model.getNameList(i)+"<br>");
                        out.print("tell:"+model.getTellList(i)+"<br>");
                        out.print("age:"+model.getAgeList(i)+"<br>");
                        out.print("birthday:"+model.getBirthList(i)+"<br>"+"<br>");
                        
                    }
                }
            }
        %>
    </center>    
    </body>
</html>
