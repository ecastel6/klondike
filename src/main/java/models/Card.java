package models;

public class Card {

    private CardSuit suit;

    private CardNumber number;

    private boolean hidden;

    public Card(CardNumber number, CardSuit suit, boolean hidden) {
        this.number = number;
        this.suit = suit;
        this.hidden = hidden;
    }

    public CardSuit getSuit() {
        return suit;
    }

    public CardNumber getNumber() {
        return number;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public boolean isHidden() {
        return hidden;
    }

    @Override
    public String toString() {
        if (!this.isHidden()) {
            return "[" + this.number + " " + this.suit + "]";
        }
        return "[]";
    }
}
