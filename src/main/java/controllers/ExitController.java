package controllers;

import models.State;
import tools.IO;

public class ExitController extends OperationsController {
    @Override
    public void execute() {
        IO.getInstance().writeln("Saliendo de Klondike...");
        game.setState(State.EXIT);
    }
}
