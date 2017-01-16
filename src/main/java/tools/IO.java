package tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IO {

    private static IO io;

    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static IO getInstance() {
        if (io == null) {
            io = new IO();
        }
        return io;
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

    public int readInt(String title, int min, int max) {
        int inputNumber = 0;
        boolean ok = false;
        do {
            try {
                inputNumber = Integer.parseInt(this.readString(title));
                if (min <= inputNumber && inputNumber <= max) {
                    ok = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (!ok);
        return inputNumber;
    }

    public boolean isNumber(String input) {
        String regex = "[0-9]";
        if (input.matches(regex)) {
            return true;
        }
        ;
        return false;
    }

    public String readString(String title) {
        String input = null;
        boolean ok = false;
        do {
            this.write(title);
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

    public void write(String string) {
        System.out.print(string);
    }

    public void writeln() {
        System.out.println();
    }

    public void writeln(String string) {
        System.out.println(string);
    }

}
