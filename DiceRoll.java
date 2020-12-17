import java.util.*;

public class DiceRoll {
    
    private int value;
    
    public DiceRoll() {
        value = (int)(Math.random()*6)+1;
    }
    
    public void reset() {
        value = (int)(Math.random()*6)+1;
    }
    
    public int getValue() {
        return value;
    }
}
