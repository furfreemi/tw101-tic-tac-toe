import java.io.PrintStream;

/**
 * Created by lmarcich on 3/3/17.
 */
public class Game {
    private PrintStream out;

    public Game(PrintStream out) {
        this.out = out;
    }

    public void start() {
        out.println("1|2|3\n" +
                "-----\n" +
                "4|5|6\n" +
                "-----\n" +
                "7|8|9");
    }
}
