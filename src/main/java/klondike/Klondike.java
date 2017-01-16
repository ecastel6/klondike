package klondike;

import controllers.DeckToWasteController;
import controllers.ExitController;
import controllers.FlipCardController;
import controllers.FoundationToLadderController;
import controllers.LadderToFoundationController;
import controllers.LadderToLadderController;
import controllers.WasteToDeckController;
import controllers.WasteToFoundationController;
import controllers.WasteToLadderController;
import models.Game;
import tools.IO;
import views.GameView;

public class Klondike {

    private Game game;

    boolean ok;

    private GameView gameView;

    public Klondike() {
        game = new Game();
        gameView = new GameView(game.getDeck(), game.getLadders(), game.getFoundations(), game.getWaste());
        init();
        play();
    }

    public void init() {
        gameView.show();
    }

    public void play() {
        do {
            int menuOption = IO.getInstance().readInt("Opción (1-9): ", 1, 9);
            switch (menuOption) {
            case 1: {
                new DeckToWasteController(game.getWaste(), game.getDeck()).execute();
                gameView.show();
                break;
            }
            case 2: {
                new WasteToDeckController(game.getWaste(), game.getDeck()).execute();
                gameView.show();
                break;
            }
            case 3: {
                new WasteToFoundationController(game.getWaste(), game.getFoundations()).execute();
                gameView.show();
                break;
            }
            case 4: {
                new WasteToLadderController(game.getWaste(), game.getLadders()).execute();
                gameView.show();
                break;
            }
            case 5: {
                new LadderToFoundationController(game.getLadders(), game.getFoundations()).execute();
                gameView.show();
                break;
            }
            case 6: {
                new LadderToLadderController(game.getLadders()).execute();
                gameView.show();
                break;
            }
            case 7: {
                new FoundationToLadderController(game.getLadders(), game.getFoundations()).execute();
                gameView.show();
                break;
            }
            case 8: {
                new FlipCardController(game.getLadders()).execute();
                gameView.show();
                break;
            }
            default: {
                new ExitController().execute();
                break;
            }
            }
        } while (true);
    }

    public static void main(String[] args) {
        new Klondike();
    }
}
