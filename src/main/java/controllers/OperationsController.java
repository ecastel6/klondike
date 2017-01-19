package controllers;

import models.Game;

public abstract class OperationsController {

    protected Game game;

    public abstract void execute();

    public void setGame(Game game) {
        this.game = game;
    }
}
