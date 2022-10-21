/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Eng. Nourhan
 */
public class Game {
    
    Player[] playersArray = new Player[4];
    Card[] deck = new Card[52];
    int valid_highscore = 0;
        
    public void DeckCard()
    {
        int idx = 0;
        for(int i =0;i < 4;i++)
        {
            for(int j =0;j < 13;j++)
            {
                int value = j+1;
                if(value>10)
                {
                    value=10;
                }
                deck[idx]=new Card(i,j,value);
                idx++;
            }
        }
    }
    
    public Card RndCard()
    {
        Random rand= new Random();
        Card chosen ;
        while(true)
        {
            int choose = rand.nextInt(52);
            if(deck[choose]!= null)
            {
                chosen =new Card(deck[choose]);
                deck[choose]=null;
                break;
            }
            
        }
        return chosen;
    }
    
    public void playerInfo()
    {
        Scanner in = new Scanner(System.in);
        for(int i =0 ; i < 3 ; i++)
        {
            playersArray[i] = new Player();
            System.out.println("Please Enter Your Name : ");
            playersArray[i].setName(in.nextLine());
            for(int k =0 ; k < 2 ; k++)
            {
                Card C = RndCard();
                playersArray[i].setPlayer_cardsArray(C);
                playersArray[i].setScore(C.getValue());
            }
        }
        Hscore();
        playersArray[3] = new Player();
        playersArray[3].setName("Dealer");
        for(int k =0 ; k < 2 ; k++)
            {
                Card C = RndCard();
                playersArray[3].setPlayer_cardsArray(C);
                playersArray[3].setScore(C.getValue());
            }
    }
    
    public void Hscore()
    {
        valid_highscore=0;
        for(int i=0;i<3;i++)
        {
            if((playersArray[i].getScore()<= 21) && (playersArray[i].getScore()> valid_highscore))
            {
               valid_highscore = playersArray[i].getScore();
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    
}
