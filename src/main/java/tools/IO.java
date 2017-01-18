package tools;

public class IO {

    private static IO io;

    

    public static IO getInstance() {
        if (io == null) {
            io = new IO();
        }
        return io;
    }

    public int readLimitedInt(String title, int min, int max) {
        return LimitedIntDialog.getInstance().read(title, min, max);
    }

    public int readLimitedInt(String title, int max) {
        return LimitedIntDialog.getInstance().read(title, max);
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
