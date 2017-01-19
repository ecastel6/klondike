package klondike;

import controllers.ExitController;
import controllers.InitController;
import controllers.OperationsController;
import controllers.OptionBuilder;
import models.Game;
import views.GameView;

public class Klondike {

    private Game game;

    private views.GameView gameView;

    private OptionBuilder optionBuilder;

    private InitController initController;

    private ExitController exitController;

    public Klondike() {
        game = new Game();
        gameView = new GameView(game.getDeck(), game.getLadders(), game.getFoundations(), game.getWaste());
        initController = new InitController();
        optionBuilder = new OptionBuilder();

    }

    public void play() {
        OperationsController operationsController;
        do {
            operationsController = getOperationsController();
            if (operationsController != null) {
                operationsController.setGame(game);
                operationsController.execute();
            }

            if (game.getState() == models.State.IN_GAME) {
                gameView.showBoard();
            }
        } while (operationsController != null);
    }

    public OperationsController getOperationsController() {
        switch (game.getState()) {
        case INITIALIZE:
            return initController;
        case IN_GAME:
            return optionBuilder.getOptionController();
        case EXIT:
            return exitController;
        default:
            return null;
        }
    }

    public static void main(String[] args) {
        new Klondike().play();
    }
}
