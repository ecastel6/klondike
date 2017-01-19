package views;

import controllers.OptionEnum;
import tools.IO;

public class OptionsView {
    public void show(OptionEnum[] options) {
        for (OptionEnum option : options) {
            IO.getInstance().writeln(option.getValue() + ". " + option.getOption());
        }
    }
}
