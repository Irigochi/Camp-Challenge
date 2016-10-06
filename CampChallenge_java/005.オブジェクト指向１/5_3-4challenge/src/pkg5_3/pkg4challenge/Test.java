/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg5_3.pkg4challenge;

/**
 *
 * @author Kouta
 */
//課題3
public class Test{
  public String str = "";
  public int num = 0;
  public void set(String s, int n){
    str = s;
    num = n;
  }
  public void print(){
    System.out.println(str + "と" + num);
  }
}