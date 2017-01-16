package controllers;

import java.util.ArrayList;

import models.StackCard;
import models.StackLadder;
import tools.IO;

public class LadderToLadderController {

    private ArrayList<StackLadder> ladders;

    public LadderToLadderController(ArrayList<StackLadder> ladders) {
        this.ladders = ladders;
    }

    public void execute() {
        int originLadder = IO.getInstance().readInt("¿Escalera de origen? (1-7):", 1, 7);
        int destinationLadder = IO.getInstance().readInt("¿Escalera de destino? (1-7):", 1, 7);
        int numCards = IO.getInstance().readInt("¿Cuantas cartas?:");

        StackLadder origin = ladders.get(originLadder - 1);
        StackLadder destination = ladders.get(destinationLadder - 1);
        int valueFromLadder = origin.getStackCard().lastElement().getNumber().getCardValue() - numCards;
        int valueToLadder = destination.getStackCard().lastElement().getNumber().getCardValue();
        if (valueFromLadder == valueToLadder + 1) {
            StackCard stackCard = new StackCard();
            for (int i = 0; i < numCards; i++) {
                stackCard.getStackCard().push(ladders.get(originLadder - 1).getStackCard().pop());
            }
            while (!stackCard.getStackCard().isEmpty()) {
                ladders.get(destinationLadder - 1).getStackCard().push(stackCard.getStackCard().pop());
            }
        } else {
            IO.getInstance().writeln("No se puede realizar la operación");
        }
    }
}
