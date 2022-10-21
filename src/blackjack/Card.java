/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author Eng. Nourhan
 */
public class Card {
    
    private int suit;
    private int rank;
    private int value;

    public Card(int suit, int rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }
    
    public Card(Card c ) {
        this.suit = c.suit;
        this.rank = c.rank;
        this.value = c.value;
    }
    
    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }
    
    
    
    
    
}
