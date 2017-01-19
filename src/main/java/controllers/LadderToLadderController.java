package controllers;

import models.StackCard;
import models.StackLadder;
import tools.IO;

public class LadderToLadderController extends OperationsController {

    public LadderToLadderController() {
        super();
    }

    @Override
    public void execute() {
        int originLadder = IO.getInstance().readLimitedInt("¿Escalera de origen? (1-7):", 7);
        int destinationLadder = IO.getInstance().readLimitedInt("¿Escalera de destino? (1-7):", 7);

        StackLadder origin = game.getLadders().get(originLadder - 1);
        int numCards = IO.getInstance().readLimitedInt("¿Cuantas muevo?:", origin.size());

        StackLadder destination = game.getLadders().get(destinationLadder - 1);
        int valueOriginLadder = origin.getStackCard().lastElement().getNumber().getCardValue() - numCards;
        int valueDestinationLadder = destination.getStackCard().lastElement().getNumber().getCardValue();
        if (valueOriginLadder == valueDestinationLadder + 1) {
            StackCard stackCard = new StackCard();
            for (int i = 0; i < numCards; i++) {
                stackCard.getStackCard().push(game.getLadders().get(originLadder - 1).getStackCard().pop());
            }
            while (!stackCard.getStackCard().isEmpty()) {
                game.getLadders().get(destinationLadder - 1).getStackCard().push(stackCard.getStackCard().pop());
            }
        } else {
            IO.getInstance().writeln("Operación inválida");
        }
    }
}
