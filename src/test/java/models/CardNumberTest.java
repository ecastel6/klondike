package models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CardNumberTest {

    @Test
    public void testGetCardValue() {
        assertEquals(11, CardNumber.J.getCardValue());
        assertEquals(12, CardNumber.Q.getCardValue());    
    }
}
