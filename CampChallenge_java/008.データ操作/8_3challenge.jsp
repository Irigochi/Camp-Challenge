<%-- 
    Document   : 8_3challenge
    Created on : 2016/10/17, 11:20:14
    Author     : Kouta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.Cookie" import="java.util.Date" import="java.text.*"%>

<%
    //out.print("３．クッキーに現在時刻を記録し、次にアクセスした際に、前回記録した日時を表示してください。<br>");
    
    Date d = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String sdfd = sdf.format(d);
    
    //Cookie 変数名 = new Cookie(Name, Value)
    Cookie c = new Cookie("LastLogin", sdfd);
    
    response.addCookie(c);
    
    Cookie cs[] = request.getCookies();
    if(cs != null){
        for(int i=0; i<cs.length; i++){
            if(cs[i].getName().equals("LastLogin")){
                out.print("最後のログインは"+cs[i].getValue()+"です");
                break;
            }
        }
    }
%>