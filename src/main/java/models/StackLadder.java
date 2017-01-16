package models;

public class StackLadder extends StackCard {

    public StackLadder() {
        super();
    }

    public void addCards(int max, StackDeck deck) {
        for (int i = 0; i < max; i++) {
            Card card = deck.getStackCard().pop();
            if (i == max - 1) {
                card.setHidden(false);
            }
            this.getStackCard().add(card);
        }
    }
}
