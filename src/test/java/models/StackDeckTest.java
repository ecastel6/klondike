package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StackDeckTest {
    
    private StackDeck deck;
    
    @Before
    public void setup(){
        deck = new StackDeck();
    }
    
    @Test
    public void testSize() {
        assertEquals(52, deck.getStackCard().size());
    }
}
