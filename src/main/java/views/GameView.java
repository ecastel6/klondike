package views;

import java.util.ArrayList;
import java.util.Hashtable;

import models.CardSuit;
import models.StackCard;
import models.StackDeck;
import models.StackLadder;
import tools.IO;

public class GameView {

    private StackDeck deck;

    private ArrayList<StackLadder> ladders;

    private Hashtable<CardSuit, StackCard> foundations;

    private StackCard waste;

    public GameView(StackDeck deck, ArrayList<StackLadder> ladders, Hashtable<CardSuit, StackCard> foundations, StackCard waste) {
        this.deck = deck;
        this.ladders = ladders;
        this.foundations = foundations;
        this.waste = waste;
    }


    public void showBoard() {
        if (deck.getStackCard().isEmpty()) {
            IO.getInstance().writeln("Baraja: []");
        } else {
            IO.getInstance().writeln("Baraja: [X,X]");
        }

        IO.getInstance().writeln("Descarte:" + waste.toString());

        for (int i = 0; i < CardSuit.values().length; i++) {
            IO.getInstance().writeln("Palo " + CardSuit.values()[i] + ": " + foundations.get(CardSuit.values()[i]));
        }

        for (int i = 1; i <= 7; i++) {
            IO.getInstance().writeln("Escalera " + i + ": " + ladders.get(i - 1).toString());
        }

    }
}