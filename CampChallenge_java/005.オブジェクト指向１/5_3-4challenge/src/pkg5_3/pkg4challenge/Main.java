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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    //課題3,4
    Test sample = new Test();
    sample.set("アイウエオ", 12345);
    sample.print();
    
    Test_2 sample2 = new Test_2();
    sample2.set("あいうえお", 99999);
    sample2.print();
    sample2.clear();
    sample2.print();
    
    }

}


