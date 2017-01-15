package controllers;

import java.util.ArrayList;
import java.util.Hashtable;

import models.Card;
import models.StackCard;
import models.StackLadder;
import models.CardSuit;
import tools.IO;

public class LadderToFoundationController {

    private ArrayList<StackLadder> ladders;

    private Hashtable<CardSuit, StackCard> foundations;

    public LadderToFoundationController(ArrayList<StackLadder> ladders, Hashtable<CardSuit, StackCard> foundations) {
        this.ladders = ladders;
        this.foundations = foundations;
    }

    public void execute() {
        int fromLadder = IO.getInstance().readInt("¿desde que escalera? (1-7):",1,7);
        StackLadder ladder = ladders.get(fromLadder - 1);
        Card card = ladder.getStackCard().lastElement();
        StackCard foundation = foundations.get(card.getSuit());
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
