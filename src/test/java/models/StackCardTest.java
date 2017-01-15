package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StackCardTest {
    
    private StackCard stackCard;
    
    @Before
    public void setUp() throws Exception {
        stackCard = new StackCard();
    }

    @Test
    public void testHiddenAll() {
        Card card = new Card(CardNumber.DOS,CardSuit.PICA,false);
        stackCard.getStackCard().push(card);
        stackCard.hiddenAll();
        assertEquals("[]", stackCard.toString());
    }

    @Test
    public void testToString() {
        Card card = new Card(CardNumber.DOS,CardSuit.PICA,false);
        stackCard.getStackCard().push(card);
        assertEquals("[DOS PICA]", stackCard.toString());
    }

}
