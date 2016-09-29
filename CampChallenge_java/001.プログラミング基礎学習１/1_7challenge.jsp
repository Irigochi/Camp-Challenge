<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

 final String br = "<br>";
 
 
 //課題7
 out.print("■課題7" + br);
 
 String cate = request.getParameter("category");
  //種別の変数
 String num = request.getParameter("number");
  //個数の変数
 String pri = request.getParameter("price");
  //総額の変数
 
 if(cate.equals("1")){
   out.print("雑貨" + br);
 }else if(cate.equals("2")){
   out.print("生鮮食品" + br);
 }else{
   out.print("その他" + br);
 }
  //文字列比較にはequalsメソッドを使う
 
 int sougaku = Integer.parseInt(pri);
 int kosuu = Integer.parseInt(num);
 int value = sougaku / kosuu;
  //総額と個数をint型に変換し、計算結果を変数に代入
 
 out.print("総額:" + sougaku + br);
 out.print("1個あたりの値段:" + value + br);
 
 double point = 0;
 if(sougaku >= 5000){
   point = sougaku * 0.05;
 }else if((5000 > sougaku) && (sougaku >= 3000)){
   point = sougaku * 0.04;
 }else{
   point = 0;
 }
  //小数の変数の定義ではdouble型を使う by Progate
  //if(()&&()):かつ、if(()||())または
 
 out.print("今回のポイントは:" + point + "ptです。" + br);
 out.print("1pt=1円として次回お買い物よりご利用いただけます。");
 
%>