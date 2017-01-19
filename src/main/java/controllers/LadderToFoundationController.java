package controllers;

import models.Card;
import models.StackCard;
import models.StackLadder;
import tools.IO;

public class LadderToFoundationController extends OperationsController {

    public LadderToFoundationController() {
        super();
    }

    @Override
    public void execute() {
        int fromLadder = IO.getInstance().readLimitedInt("¿desde que escalera? (1-7):", 7);
        StackLadder ladder = game.getLadders().get(fromLadder - 1);
        Card card = ladder.getStackCard().lastElement();
        StackCard foundation = game.getFoundations().get(card.getSuit());
        if (foundation.getStackCard().isEmpty()) {
            if (card.getNumber().getCardValue() == 1) {
                foundation.getStackCard().push(ladder.getStackCard().pop());
            } else {
                IO.getInstance().writeln("Carta no válida");
            }
        } else {
            int previousCardValue = foundation.getStackCard().lastElement().getNumber().getCardValue();
            if (previousCardValue == card.getNumber().getCardValue() - 1) {
                foundation.getStackCard().push(ladder.getStackCard().pop());
            } else {
                IO.getInstance().writeln("Carta inválida");
            }
        }
    }
}
