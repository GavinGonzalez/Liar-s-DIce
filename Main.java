
import java.util.*;

public class Main
{
	public static void main(String[] args) {
	    String yn = "";
	    
	    outerloop:
	    
	    while(true) {
	    ArrayList<Claim> claims = new ArrayList<Claim>();
	    Scanner scan = new Scanner(System.in);
	    System.out.println("Number of players");
	    int numPlayers = scan.nextInt();
	    System.out.println("Number of dice");
	    int numDice = scan.nextInt();
	    ArrayList<Player> players = new ArrayList<Player>();
	    
	    //p1 is the user
	    for(int x = 0; x < numPlayers; x++) {
	        players.add(new Player(numDice));
	    }
	    
	    //----------------------------------\
	    boolean start = true;
	    int player = 0;
	    boolean tender = false;
	    int callOrStay = 0;
	       while(players.get(0).diceCount() >= 0) {
	       
	        
	       
	       if(players.get(player).diceCount() == 0) {
	           int y = 0;
	           
	              if(player == 0) {
	                  
	                  System.out.println("YOU SUCK");
	                  
	                  System.out.println("would you like to play again (Y/N)");
        	            yn = scan.nextLine();
        	            
        	            if(yn == "n") {
        	               System.exit(0);
        	           }
        	           else {
        	               
        	           break;
        	           }
        	        } 
        	        
        	        
	              
	           
	               else {
                    System.out.println("player " + (player+1)+ " is out of the game");
	                players.remove(player);
	               }
                }  
	       
	        
	        
	        
	         if(players.size() == 1) {
	            int y = 0;
                
	            
	            if(players.get(0).diceCount() > 0) {
                     System.out.println("YOU WON!!!!!!");
                     
                    System.out.println("would you like to play again (Y/N)");
        	            yn = scan.nextLine();
        	            
        	           if(yn == "n") {
        	               break outerloop;
        	           }
	            }
	            
	            
	           
	            
	         }
	        
	        
	        
	     
	        else if(player == 0 && players.get(0).diceCount() > 0) {
	            boolean lie = false;
	            int numOfVals;
	            int val;
	            
	            
	            
	           //if tender == true in last iteration and is not that players turn
	           if(tender == true) {
	               tender = false;
	           }
	           
	           
	           
	           
	            
	               //-------------------
	               
	               while(true) {
	               System.out.println("would you like to call out the previus player (1) or make a numeric claim (2)");
	               callOrStay = scan.nextInt();
	               
	               if(start == true/* && callOrStay == 2*/) {
	                   if(callOrStay == 2) {
	                   break;
	                   }
	               }
	               
	               else if(start == false) {
	                   if(claims.get(claims.size()-1).playerLiar() == true) {
	                       
	                       if(callOrStay == 2) {
	                         break;
	                       }
	                 }
	                 
	                 if(claims.get(claims.size()-1).playerLiar() == false) {
	                     if(callOrStay == 1 || callOrStay == 2) {
	                     break;
	                     }
	               
	                 }
	                 
	               
	               }
	               
	               
	               
	               }
	               
	               
	               
	               
	               
	               
	               
	               
	               
	               if(callOrStay == 1) {//////////////////////////////////////change player
	               System.out.println("player " + (player+1) + " (you) said " + players.size() + " is Lying");
	               
	                
	                claims.add(new Claim(1, 1));
	                claims.get(claims.size()-1).isLiar = true;
	               
	               if(ifLiar(players, claims.get(claims.size()-1).numOfVals(), claims.get(claims.size()-1).val()) ) {
	                    players.get(players.size()-1).removeDi();
	                    System.out.println("Player " + (player+1) + " Wins");
	                    player = players.size()-2;
	                }
	                
	                else {
	                   
	                    players.get(player).removeDi();
	                    System.out.println("Player " + (players.size()) + " Wins");
	                    player = -1;
	                    
	                }
	                tender = true;
	                System.out.println("Press enter to reset");
	                scan.nextLine();
	                
	                for(int x = 0; x < players.size(); x++) {
	                    players.get(x).shakeCup();
	                }
	                
	           }
	           
	           if(callOrStay == 2) {
	               
	               if(start == true) {
	               System.out.println("Enter your claim");
    	           System.out.println("input the number of dice");
    	           numOfVals = scan.nextInt();
    	           System.out.println("input the value of dice");
    	           val = scan.nextInt();
    	           claims.add(new Claim(numOfVals, val));
    	           
    	           System.out.println("player " + (player+1) + " claim (your claim)");
    	           System.out.print("Dice: ");
	                players.get(player).printDice();
	                claims.get(claims.size()-1).printClaim();
	                
	               }
	               
	               else {
	                   
	                   while(true) {
	                       System.out.println("Enter your claim");
            	           System.out.println("input the number of dice");
            	           numOfVals = scan.nextInt();
            	           System.out.println("input the value of dice");
            	           val = scan.nextInt();
            	   
            	           if(val <= 6 && val > claims.get(claims.size()-1).val()) {
            	               claims.add(new Claim(numOfVals, val));
            	               claims.get(claims.size()-1).printClaim();
            	               break;
            	           }
            	           
            	           else if(numOfVals > claims.get(claims.size()-1).numOfVals() && val <= 6 && val > claims.get(claims.size()-1).val()) {
            	               claims.add(new Claim(numOfVals, val));
            	               claims.get(claims.size()-1).printClaim();
            	               break;
            	           }
            	           
            	           System.out.println("Please input a valid number of dice or dice value");
	                   }
	                   
	               }
	           }
	               
	       
	       
	       
	       
	       
	         }
	         
	         
	        
	        
	        
	        
	        
	        
	        
	        else if(tender == true) {
	                claims.add(new Claim((claims.get(claims.size()-1)), players));
	                 System.out.println("player " + (player+1) + " claim");
	                
	                    
	                    //if(claims.get(claims.size()-1).playerLiar() == true) {
	                        tender = false;
	                        
	                        players.get(players.size()-1).printDice();
	                        claims.get(claims.size()-1).isLiar = false;
	                        claims.get(claims.size()-1).resetClaim(players);
	                        
	                     
	                    //}
	                    //System.out.println("********");
	                    //tender = false;
	                claims.get(claims.size()-1).printClaim();
	            }
	        
	        
	        
	            
	            //the first robot can't say that another player is a liar
	            else if(tender == false) {
	                
	                if(players.get(player).diceCount() > 0 && claims.get(claims.size()-1).playerLiar() == false) {
	                    
	                 claims.add(new Claim((claims.get(claims.size()-1)), players));
	                 System.out.println("player " + (player+1) + " claim");
	                 claims.get(claims.size()-1).printClaim();
	                 
	                }
	            
	               
	                if((claims.get(claims.size()-1).playerLiar() == true)) {
	                    
	                
	                System.out.println("Player " + (player+1) + " said " + (player) + " is a liar");
	                
	                if(ifLiar(players, claims.get(claims.size()-2).numOfVals(), claims.get(claims.size()-2).val()) ) {
	                    players.get(player-1).removeDi();
	                    System.out.println("Player " + (player+1) + " Wins");
	                    player = player-2;
	                }
	                
	                else {
	                    
	                    players.get(player).removeDi();
	                    System.out.println("Player " + (player) + " Wins");
	                    player = player-1;
	                }
	                tender = true;
	                System.out.println("Press enter to reset");
	                scan.nextLine();
	                
	                for(int x = 0; x < players.size(); x++) {
	                    players.get(x).shakeCup();
	                }
	                
	                
	            }
	            
	            
	           
	            
	            
	            }
	            
	        if(player >= players.size()-1) {
	            player = -1;
	           }   
	
	         start = false;
	        player++;
	        
	       }
	       
	       
	       //-------------------------------- 
	      if(yn == "n") {
	          break;
	      }
        	 
	    }
	    
	               
       
	    
	    
	}
	
	
	public static boolean ifLiar(ArrayList<Player> play, int num, int val) {
   int counter = 0;
   
   for(int x = 0; x < play.size(); x++) {
       for(int y = 0; y < play.get(x).dices.size(); y++) {
           if(val == play.get(x).dices.get(y).getValue()) {
               counter++;
           }
       }
   }
   
   if(counter >= num) {
       return false;
   }
   
   return true;
}

	
}


