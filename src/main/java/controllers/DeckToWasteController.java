package controllers;

import models.Card;
import models.StackCard;
import models.StackDeck;
import tools.IO;

public class DeckToWasteController {

    private StackDeck deck;

    private StackCard waste;

    public DeckToWasteController(StackCard waste, StackDeck deck) {
        this.waste = waste;
        this.deck = deck;
    }

    public void execute() {
        if (deck.getStackCard().isEmpty()) {
            IO.getInstance().writeln("Baraja vacía");
        } else {
            Card card = deck.getStackCard().pop();
            card.setHidden(false);
            waste.hiddenAll();
            waste.getStackCard().push(card);
        }
    }
}
