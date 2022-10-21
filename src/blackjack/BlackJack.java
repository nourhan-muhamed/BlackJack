
package blackjack;

import java.util.Scanner;


public class BlackJack {

    
    static Game gm = new Game();
    static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) 
    {
        GUI gui = new GUI();

        gm.DeckCard();
        gm.playerInfo();
        
        gui.runGUI( gm.deck, gm.playersArray[0].getPlayer_cardsArray(), gm.playersArray[1].getPlayer_cardsArray(), gm.playersArray[2].getPlayer_cardsArray(), gm.playersArray[3].getPlayer_cardsArray() );  
           
        
        for(int i = 0; i <3 ; i++)
        {
            int x;
            while(true)
            {
                System.out.println("Press 1 to Hit & Press 2 Stand");
                x=in.nextInt();
                if(x==1)
                {
                    Card C = Hit(i);
                    gui.updatePlayerHand(C,i);
                }
                else if(x==2)
                {
                    if(gm.playersArray[i].getScore() == 21)
                    {
                        gm.playersArray[i].setBJ(true);
                    }
                    gm.Hscore();
                    break;
                }
                else
                {
                    System.out.println("Not Valid Option, Please Try Again");
                }
            }
        }
        
        while(true)
        {
            if(gm.playersArray[3].getScore() > gm.valid_highscore && gm.playersArray[3].getScore() <= 21)
            {
                gm.playersArray[3].setBJ(true);
                break;
            }
            else if(gm.playersArray[3].getScore()==21)
            {
                gm.playersArray[3].setBJ(true);
                break;
            }
            else if(gm.playersArray[3].getScore() > 21)
            {
                break;
            }
            Card C = Hit(3);
            gui.updateDealerHand(C,gm.deck);
            
        }
        
      winner();  
        
        
        
    }
    public static Card Hit(int x)
    {
        Card C = gm.RndCard();
        gm.playersArray[x].setPlayer_cardsArray(C);
        gm.playersArray[x].setScore(C.getValue());
        
        return C;
    }
    
    public static void winner()
    {
        int cnt=0, index = -1;
        for(int i =0;i < 4 ;i++)
        {
            if(gm.playersArray[i].isBJ() == true)
            {
                cnt++;
                index = i;
            }
        }
        if(cnt>1)
        {
            System.out.println("Push");
            return;
        }
        else if(cnt==1)
        {
            System.out.println(gm.playersArray[index].getName()+" is the WINNER.");
        }
        else
        {
            for(int i =0; i < 3;i++)
            {
                if(gm.playersArray[i].getScore() == gm.valid_highscore)
                {
                    cnt++;
                    index = i;
                }
            }
                if(cnt>1)
            {
                System.out.println("Push");
                return;
            }
            else if(cnt==1)
            {
                System.out.println(gm.playersArray[index].getName()+" is the WINNER.");
            }
        }
    }
    
    
}
