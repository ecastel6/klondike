package tools;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LimitedIntDialog {

    private static LimitedIntDialog limitedIntDialog;

    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    private LimitedIntDialog() {

    }

    public static LimitedIntDialog getInstance() {
        if (limitedIntDialog == null) {
            limitedIntDialog = new LimitedIntDialog();
        }
        return limitedIntDialog;
    }

    public int read(String title, int min, int max) {
        assert title != null;
        ClosedInterval limits = new ClosedInterval(min, max);
        ClosedIntervalView limitsView = new ClosedIntervalView("El valor debe estar entre ", limits);
        int value;
        boolean ok;
        do {
            value = readInt(title + " " + limitsView + ": ");
            ok = limits.includes(value);
            if (!ok) {
                limitsView.writeln();
            }
        } while (!ok);
        return value;
    }

    public int read(String title, int max) {
        return this.read(title, 1, max);
    }

    public int readInt(String title) {
        int inputNumber = 0;
        boolean ok = false;
        do {
            try {
                inputNumber = Integer.parseInt(this.readString(title));
                ok = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (!ok);
        return inputNumber;
    }

    public String readString(String title) {
        String input = null;
        boolean ok = false;
        do {
            System.out.print(title);
            try {
                input = bufferedReader.readLine();

                if ((!input.isEmpty()) && (isNumber(input))) {
                    ok = true;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (!ok);
        return input;
    }

    public boolean isNumber(String input) {
        String regex = "[0-9]";
        if (input.matches(regex)) {
            return true;
        }
        ;
        return false;
    }
}
