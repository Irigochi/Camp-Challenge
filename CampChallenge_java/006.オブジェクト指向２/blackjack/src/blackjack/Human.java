/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.ArrayList;

/**
 *
 * @author Kouta
 */
abstract public class Human {
    
    abstract public int open();
    
    abstract public void setCard(ArrayList<Integer> list);
    
    abstract public boolean checkSum();
    
    ArrayList<Integer> myCards = new ArrayList<>();
    
    ArrayList<Integer> hand = new ArrayList<>();
    
}
