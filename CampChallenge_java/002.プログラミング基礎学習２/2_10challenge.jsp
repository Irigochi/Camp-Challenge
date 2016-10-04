<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

final String br = "<br>";

//課題10
out.print("■課題10"+br);

String number = request.getParameter("number");
int num = Integer.parseInt(number);
int prime[] = {2,3,5,7};
int count = 0;
String message = "";

out.print("元の値:" + num);
out.print(br);

if((num != 0)&&(num != 1)){

  for(int i = 0; i < prime.length; i++){
    while(num % prime[i] == 0){
      num = num / prime[i];
      count++;
    }
    if(count != 0){
      message = message + prime[i] + "…" + count + "回" + br;
      count = 0;
    }else if(num == 1){
      break;
    }
  }
  if(num > 1){
    message = message + "その他…" + num;
  }
}

out.print(message);

%>
