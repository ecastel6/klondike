package controllers;

import java.util.ArrayList;
import java.util.Hashtable;

import models.Card;
import models.CardSuit;
import models.StackCard;
import models.StackLadder;
import tools.IO;

public class FoundationToLadderController {

    private ArrayList<StackLadder> ladders;

    private Hashtable<CardSuit, StackCard> foundations;

    public FoundationToLadderController(ArrayList<StackLadder> ladders, Hashtable<CardSuit, StackCard> foundations) {

        this.ladders = ladders;
        this.foundations = foundations;
    }

    public void execute() {
        int fromFoundation = IO.getInstance().readLimitedInt("¿ desde que Palo ? (1-4):", 4);
        int toLadder = IO.getInstance().readLimitedInt("¿ a que escalera ? (1-7):", 7);
        CardSuit foundation = CardSuit.values()[fromFoundation - 1];
        StackCard suit = foundations.get(foundation);
        if (suit.getStackCard().isEmpty()) {
            IO.getInstance().writeln("Palo vacio");
        } else {
            Card card = suit.getStackCard().pop();
            ladders.get(toLadder - 1).getStackCard().push(card);
        }
    }
}
