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
public class Player {
    
    private String name;
    private int score = 0;
    private Card[] player_cardsArray = new Card[11];
    private boolean BJ = false;
    //private boolean lost = false;
    private int index =0;

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score += score;
    }

    public void setPlayer_cardsArray(Card c1) {
        this.player_cardsArray[index] = c1 ;
        index++;
    }

    public void setBJ(boolean BJ) {
        this.BJ = BJ;
    }

//    public void setLost(boolean lost) {
//        this.lost = lost;
//    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public Card[] getPlayer_cardsArray() {
        return player_cardsArray;
    }

    public boolean isBJ() {
        return BJ;
    }

//    public boolean isLost() {
//        return lost;
//    }
    
    
    
    
    
    
}
