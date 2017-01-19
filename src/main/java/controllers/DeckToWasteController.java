package controllers;

import models.Card;
import models.StackCard;
import models.StackDeck;
import tools.IO;

public class DeckToWasteController extends OperationsController {

    public DeckToWasteController() {
        super();
    }

    @Override
    public void execute() {
        if (game.getDeck().getStackCard().isEmpty()) {
            IO.getInstance().writeln("Baraja vacía");
        } else {
            Card card = game.getDeck().getStackCard().pop();
            card.setHidden(false);
            game.getWaste().hiddenAll();
            game.getWaste().getStackCard().push(card);
        }
    }
}
