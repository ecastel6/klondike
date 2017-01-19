package controllers;

public enum OptionEnum {
    MOVE_DECK_TO_WASTE(1, "Mover de baraja a descarte", new DeckToWasteController()),
    MOVE_WASTE_TO_DECK(2, "Mover de descarte a baraja", new WasteToDeckController()),
    MOVE_WASTE_TO_SUIT(3, "Mover de descarte a palo", new WasteToFoundationController()),
    MOVE_WASTE_TO_LADDER(4, "Mover de descarte a escalera", new WasteToLadderController()),
    MOVE_LADDER_TO_FOUNDATION(5, "Mover de escalera a palo", new LadderToFoundationController()),
    MOVE_LADDER_TO_LADDER(6, "Mover de escalera a escalera", new LadderToLadderController()),
    MOVE_FOUNDATION_TO_LADDER(7, "Mover de palo a escalera", new FoundationToLadderController()),
    FLIP_IN_LADDER(8, "Voltear en escalera", new FlipCardController()),
    EXIT_GAME(9, "Salir", new ExitController());

    private int value;

    private String option;

    private OperationsController operationController;

    OptionEnum(int value, String option, OperationsController operationController) {
        this.option = option;
        this.value = value;
        this.operationController = operationController;
    }

    public int getValue() {
        return value;
    }

    public String getOption() {
        return option;
    }

    public OperationsController getOperationController() {
        return operationController;
    }
}
