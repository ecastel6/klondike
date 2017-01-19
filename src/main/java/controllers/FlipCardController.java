package controllers;

import models.Card;
import tools.IO;

public class FlipCardController extends OperationsController {

    public FlipCardController() {
        super();
    }

    @Override
    public void execute() {
        int ladderPosition = IO.getInstance().readLimitedInt("¿de qué escalera? (1-7):", 1, 7);
        Card card = game.getLadders().get(ladderPosition - 1).getStackCard().lastElement();
        if (!card.isHidden()) {
            IO.getInstance().writeln("Carta ya girada");
        } else {
            card.setHidden(false);
        }
    }

}
