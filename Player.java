import java.util.*;

public class Player {
    
ArrayList<DiceRoll> dices;
ArrayList<Claim> claims;

public Player(int numOfDice) {
    dices = new ArrayList<DiceRoll>();
    claims = new ArrayList<Claim>();
    
    for(int x = 0; x < numOfDice; x++) {
        dices.add(new DiceRoll());
    }
    
    
}

public int diceCount() {
    return dices.size();
}

public void printClaim() {
    System.out.print("Claims ");
    claims.get(claims.size()-1).printClaim();
    System.out.println();
}



public boolean playerLiar() {
    return claims.get(claims.size()-1).playerLiar();
}


public void shakeCup() {
    for(int x = 0; x < dices.size(); x++) {
        dices.get(x).reset();
    }
}

public void removeDi() {
    dices.remove(0);
}

public void printDice() {
    for(int x = 0; x < dices.size(); x++) {
       
        System.out.print(dices.get(x).getValue() + ", ");
        
    }
    
    System.out.println();
    
}




}


