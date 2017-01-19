package controllers;

import tools.IO;

public class WasteToDeckController extends OperationsController {
    
    public WasteToDeckController() {
        super();
    }

    @Override
    public void execute() {
        if (game.getWaste().getStackCard().isEmpty()) {
            while (!game.getWaste().getStackCard().isEmpty()) {
                game.getDeck().getStackCard().push(game.getWaste().getStackCard().pop());
            }
        } else {
            IO.getInstance().writeln("Aun quedan cartas en el mazo de descarte");
        }
    }
}
