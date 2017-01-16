package models;

import java.util.Stack;

public class StackCard {
    private Stack<Card> stackCard;

    public StackCard() {
        stackCard = new Stack<Card>();
    }

    public Stack<Card> getStackCard() {
        return this.stackCard;
    }

    public void hiddenAll() {
        for (Card card : this.stackCard) {
            card.setHidden(true);
        }
    }

    @Override
    public String toString() {
        String suiteString = "";
        for (int i = 0; i < this.stackCard.size(); i++) {
            suiteString = suiteString + this.stackCard.get(i).toString();
        }
        return suiteString;
    }
}
