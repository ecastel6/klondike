package controllers;

import tools.IO;
import views.OptionsView;

public class OptionBuilder {

    private OptionEnum[] options;

    private OptionsView optionsView;

    public OptionBuilder() {
        this.options = OptionEnum.values();
        this.optionsView = new OptionsView();
    }

    public OperationsController getOptionController() {
        optionsView.show(options);
        int menuOption = IO.getInstance().readLimitedInt("Opción (1-9): ", 9);
        return options[menuOption - 1].getOperationController();
    }
}
