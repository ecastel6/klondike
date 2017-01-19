package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CardTest {
    
    private Card card1;
    private Card card2;
    private Card card3;
    
    @Before
    public void setUp() {
        card1 = new Card(CardNumber.AS, CardSuit.CORAZON,false);
        card2 = new Card(CardNumber.SEIS, CardSuit.PICA,false);
        card3 = new Card(CardNumber.K, CardSuit.TREBOL,false);
        
    }

    @Test
    public void getNumberTest() {
        assertEquals(CardNumber.AS, card1.getNumber());
        assertEquals(CardNumber.SEIS, card2.getNumber());
        assertEquals(CardNumber.K, card3.getNumber());
    }
    
    @Test
    public void getSuitTest() {
        assertEquals(CardSuit.CORAZON, card1.getSuit());
        assertEquals(CardSuit.PICA, card2.getSuit());
        assertEquals(CardSuit.TREBOL, card3.getSuit());
    }
    
    @Test
    public void toStringTest() {
        assertEquals("[AS CORAZON]", card1.toString());
        assertEquals("[SEIS PICA]", card2.toString());
        assertEquals("[K TREBOL]", card3.toString());
    }
}
