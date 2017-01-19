package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WasteTest {
    
    private StackCard waste;
    private Card card1;
    private Card card2;
    
    @Before
    public void setUp() {
        waste=new StackCard();
        card1 = new Card(CardNumber.SEIS, CardSuit.CORAZON, false);
        card2 = new Card(CardNumber.DIEZ, CardSuit.TREBOL, false);
        waste.getStackCard().push(card1);
        waste.getStackCard().push(card2);
    }

    @Test
    public void toStringTest() {
        assertEquals(card1.toString()+card2.toString(), waste.toString());
    }
    
    @Test
    public void popTest() {
        assertEquals(card2.toString(),waste.getStackCard().pop().toString());
    }

}
