package controllers;

import models.StackCard;
import models.StackDeck;
import tools.IO;

public class WasteToDeckController {

    private StackDeck deck;

    private StackCard waste;

    public WasteToDeckController(StackCard waste, StackDeck deck) {
        this.waste = waste;
        this.deck = deck;
    }

    public void execute() {
        if (waste.getStackCard().isEmpty()) {
            while (!waste.getStackCard().isEmpty()) {
                deck.getStackCard().push(waste.getStackCard().pop());
            }
        } else {
            IO.getInstance().writeln("El mazo de descarte aún tiene cartas");
        }
    }
}
