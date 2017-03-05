import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by lmarcich on 3/3/17.
 */
public class Player {
    private PrintStream out;
    private BufferedReader in;
    private final int id;
    public final String mark;

    public Player(BufferedReader in, PrintStream out, int id, String mark) {
        this.out = out;
        this.in = in;
        this.id = id;
        this.mark = mark;
    }


    


    public int locationSelection() throws IOException {
        out.println("Player " + id + "- please select a space to place your mark: ");
        return Integer.parseInt(in.readLine());
    }

    public String mark(){
        return mark;
    }
}
