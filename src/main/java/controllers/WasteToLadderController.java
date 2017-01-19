package controllers;

import models.Card;
import models.StackLadder;
import tools.IO;

public class WasteToLadderController extends OperationsController {

    public WasteToLadderController() {
        super();
    }

    @Override
    public void execute() {
        if (game.getWaste().getStackCard().isEmpty()) {
            IO.getInstance().writeln("Mazo de descartes vacio");
        } else {
            int fromLadder = IO.getInstance().readLimitedInt("¿escalera de destino? (1-7):", 1, 7);
            Card wasteCard = game.getWaste().getStackCard().lastElement();
            int wasteValue = wasteCard.getNumber().getCardValue();
            StackLadder ladder = game.getLadders().get(fromLadder - 1);
            if (ladder.getStackCard().isEmpty()) {
                if (wasteValue == 13) {
                    ladder.getStackCard().push(game.getWaste().getStackCard().pop());
                } else {
                    IO.getInstance().writeln("Carta inválida");
                }
            } else {
                Card ladderCard = ladder.getStackCard().lastElement();
                int ladderCardValue = ladderCard.getNumber().getCardValue();
                if (wasteValue == ladderCardValue - 1) {
                    ladder.getStackCard().push(game.getWaste().getStackCard().pop());
                } else {
                    IO.getInstance().writeln("Carta inválida");
                }
            }
        }
    }
}
