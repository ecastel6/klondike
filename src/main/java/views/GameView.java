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

    private IO io;

    public GameView(StackDeck deck, ArrayList<StackLadder> ladders, Hashtable<CardSuit, StackCard> foundations, StackCard waste) {
        this.deck = deck;
        this.ladders = ladders;
        this.foundations = foundations;
        this.waste = waste;
        io = new IO();
    }

    public void show() {
        showBoard();
        showMenu();
    }

    public void showBoard() {
        if (deck.getStackCard().isEmpty()) {
            io.writeln("Baraja: []");
        } else {
            io.writeln("Baraja: [X,X]");
        }

        io.writeln("Descarte:" + waste.toString());

        for (int i = 0; i < CardSuit.values().length; i++) {
            io.writeln("Palo " + CardSuit.values()[i] + ": " + foundations.get(CardSuit.values()[i]));
        }

        for (int i = 1; i <= 7; i++) {
            io.writeln("Escalera " + i + ": " + ladders.get(i - 1).toString());
        }

    }

    public void showMenu() {
        io.writeln("---------------------------\n"
                + "1. Mover de baraja a descarte\n"
                + "2. Mover de descarte a baraja\n"
                + "3. Mover de descarte a palo\n"
                + "4. Mover de descarte a escalera\n"
                + "5. Mover de escalera a palo\n"
                + "6. Mover de escalera a escalera\n"
                + "7. Mover de palo a escalera\n"
                + "8. Voltear en escalera\n"
                + "9. Salir\n");
    }

}