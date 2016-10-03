<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.HashMap"%>
<%

 final String br = "<br>";

 //課題1
 out.print("■課題1"+br);
 int num_1 = 3;
 String message_1 = " ";

 switch(num_1){
   case 1: message_1 = "one";
   break;
   case 2: message_1 = "two";
   break;
   default: message_1 = "想定外";
   break;
 }
 out.print(message_1);
 out.print(br);


 //課題2
 out.print("■課題2"+br);
 String language = "あ";
 String message_2 = " ";

 switch(language){
  case "A": message_2 = "英語";
  break;
  case "あ": message_2 = "日本語";
  break;
 }
 out.print(message_2);
 out.print(br);


 //課題3
 out.print("■課題3"+br);
 long num_3 = 1;
 for(int i=0; i<20; i++){
    num_3 = num_3 * 8;
	//out.print(num_3);
    //out.print(br);
 }
 out.print(num_3);
 out.print(br);


 //課題4
 out.print("■課題4"+br);
 String message_4 = " ";
 for(int i=0; i<30; i++){
    message_4 = message_4 + "A";
	//out.print(message_4);
    //out.print(br);
 }
 out.print(message_4);
 out.print(br);


 //課題5
 out.print("■課題5"+br);
 int num_5 = 0;
 int x = 0;
 for(int i=0; i<100; i++){
    x++;
    num_5 = num_5 + x;
	//out.print(num_5);
	//out.print(br);
 }
 out.print(num_5);
 out.print(br);


 //課題6
 out.print("■課題6"+br);
 int num_6 = 1000;
 while(num_6 >= 100){
    out.print(num_6);
	  out.print(br);
    num_6 = num_6 / 2;
 }
 out.print("終了");
 out.print(br);


 //課題7
 out.print("■課題7,8"+br);
 String list[] = {"10","100","soeda","hayashi","-20","118","END"};

 //課題8
 list[2] = "33";
 out.print(list[2]);
 out.print(br);


 //課題9
 out.print("■課題9"+br);
 HashMap<String,String> hmap=
   new HashMap<String,String>();

 hmap.put("1","AAA");
 hmap.put("hello","world");
 hmap.put("soeda","33");
 hmap.put("20","20");

 out.print(hmap.get("hello"));
 out.print(br);

 out.print(hmap.size());
 out.print(br);

 hmap.put("20","40");
 out.print(hmap.get("20"));
 out.print(br);

%>
