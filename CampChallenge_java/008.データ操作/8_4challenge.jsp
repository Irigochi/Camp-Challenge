<%-- 
    Document   : 8_4challenge
    Created on : 2016/10/17, 12:23:28
    Author     : Kouta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession" import="java.util.Date" import="java.text.*"%>

<%
    //out.print("３．クッキーに現在時刻を記録し、次にアクセスした際に、前回記録した日時を表示してください。<br>");
    
    Date d = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String sdfd = sdf.format(d);
    
    
    HttpSession hs = request.getSession(true);
    
    hs.setAttribute("LastLogin", sdfd);
    
    out.print("最後のログインは"+hs.getAttribute("LastLogin"));
%>