package controllers;

import java.util.ArrayList;

import models.Card;
import models.StackLadder;
import tools.IO;

public class FlipCardController {

    private ArrayList<StackLadder> ladders;

    public FlipCardController(ArrayList<StackLadder> ladders) {
        this.ladders = ladders;
    }

    public void execute() {
        int ladderPosition = IO.getInstance().readLimitedInt("¿de qué escalera? (1-7):", 1, 7);
        Card card = ladders.get(ladderPosition - 1).getStackCard().lastElement();
        if (!card.isHidden()) {
            IO.getInstance().writeln("Carta ya girada");
        } else {
            card.setHidden(false);
        }
    }

}
