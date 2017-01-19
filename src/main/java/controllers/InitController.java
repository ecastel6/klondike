package controllers;

import models.CardSuit;
import models.State;
import tools.IO;

public class InitController extends OperationsController {

    public InitController() {
        super();
    }

    @Override
    public void execute() {
        assert this.game != null;
        assert this.game.getState() == State.INITIALIZE;
        this.game.setState(State.IN_GAME);
    }

    public void showBoard() {
        if (game.getDeck().getStackCard().isEmpty()) {
            IO.getInstance().writeln("Baraja: []");
        } else {
            IO.getInstance().writeln("Baraja: [X,X]");
        }

        IO.getInstance().writeln("Descarte:" + game.getWaste().toString());

        for (int i = 0; i < CardSuit.values().length; i++) {
            IO.getInstance().writeln("Palo " + CardSuit.values()[i] + ": " + game.getFoundations().get(CardSuit.values()[i]));
        }

        for (int i = 1; i <= 7; i++) {
            IO.getInstance().writeln("Escalera " + i + ": " + game.getLadders().get(i - 1).toString());
        }
    }
}
