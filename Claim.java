import java.util.*;

public class Claim {
    
    private int numOfVals;
    private int val;
    public boolean isLiar;
    
    public Claim(int num, int vals) {
        numOfVals = num;
        val = vals;
    }
    
    public Claim(Claim preClaim, ArrayList<Player> players) {
        
        int rand = (int)(Math.random()*3)+1;
        
        if(rand == 1) {
            isLiar = true;
        }
        
        if(preClaim.numOfVals() > numOfDice(players)) {
            isLiar = true;
        }
        
        
        else {
            isLiar = false;
            
            if(preClaim.val() < 6) {
                
            int range = (6 - (preClaim.val+1))+1;
            numOfVals = preClaim.numOfVals();
            val = (int)(Math.random()*range)+(preClaim.val+1);
           }
           
           else {
               
              int range = (numOfDice(players)-(preClaim.numOfVals()+1))+1;
              numOfVals = (int)(Math.random()*range)+(preClaim.numOfVals()+1);
              val = (int)(Math.random()*6)+1; 
           }
        }
        
        
        
    }
    
    public int numOfDice(ArrayList<Player> play) {
        int count = 0;
        
        for(int x = 0; x < play.size(); x++) {
            count += play.get(x).diceCount();
        }

        return count;
    }
    
    
    public void resetClaim(ArrayList<Player> play) {
       numOfVals = (int)(Math.random()*numOfDice(play))+1;
       val = (int)(Math.random()*6)+1;
    }
    
    
    public int numOfVals() {
        return numOfVals;
    }
    
    public boolean playerLiar() {
        return isLiar;
    }
    
    public int val() {
        return val;
    }
    
    public void printClaim() {
        
        if(isLiar) {
            System.out.println("Liar");
        }
        
        else {
        System.out.println(numOfVals + ", " + val);
        }
    }
    
    public void reset(int numOfVals, int val) {
        this.numOfVals = numOfVals;
        this.val = val;
    }
}
