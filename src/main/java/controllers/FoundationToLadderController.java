package controllers;

import models.Card;
import models.CardSuit;
import models.StackCard;
import tools.IO;

public class FoundationToLadderController extends OperationsController {

    public FoundationToLadderController() {
        super();
    }

    @Override
    public void execute() {
        int fromFoundation = IO.getInstance().readLimitedInt("¿ desde que Palo ? (1-4):", 4);
        int toLadder = IO.getInstance().readLimitedInt("¿ a que escalera ? (1-7):", 7);
        CardSuit foundation = CardSuit.values()[fromFoundation - 1];
        StackCard suit = game.getFoundations().get(foundation);
        if (suit.getStackCard().isEmpty()) {
            IO.getInstance().writeln("Palo vacio");
        } else {
            Card card = suit.getStackCard().pop();
            game.getLadders().get(toLadder - 1).getStackCard().push(card);
        }
    }
}
