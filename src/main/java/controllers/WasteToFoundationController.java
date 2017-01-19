package controllers;

import models.Card;
import models.CardSuit;
import models.StackCard;
import tools.IO;

public class WasteToFoundationController extends OperationsController {

    public WasteToFoundationController() {
        super();
    }

    @Override
    public void execute() {
        if (game.getWaste().getStackCard().isEmpty()) {
            IO.getInstance().writeln("Mazo de descartes vacío");
        } else {
            Card wasteCard = game.getWaste().getStackCard().lastElement();
            CardSuit wasteSuit = wasteCard.getSuit();
            int wasteValue = wasteCard.getNumber().getCardValue();
            StackCard suitArray = game.getFoundations().get(wasteSuit);
            if (suitArray.getStackCard().isEmpty()) {
                if (wasteValue == 1) {
                    suitArray.getStackCard().push(game.getWaste().getStackCard().pop());
                } else {
                    IO.getInstance().writeln("La primera carta debe ser un AS");
                }
            } else {
                Card suitCard = suitArray.getStackCard().lastElement();
                int suitValue = suitCard.getNumber().getCardValue();
                if (wasteValue == suitValue + 1) {
                    suitArray.getStackCard().push(game.getWaste().getStackCard().pop());
                } else {
                    IO.getInstance().writeln("Palo erróneo");
                }
            }
        }
    }
}
