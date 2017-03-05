import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by lmarcich on 3/3/17.
 */
public class Player {
    private PrintStream out;
    private BufferedReader in;
    private final String id;
    public final String mark;
    private Board board;

    public Player(BufferedReader in, PrintStream out, String id, String mark, Board board) {
        this.out = out;
        this.in = in;
        this.id = id;
        this.mark = mark;
        this.board = board;
    }



    public void placeMark()  {
        out.println("Player " + id + "- please select a space to place your mark: ");
        int location;
        while (!board.isAvailableLocation((location = readLine()))) {
            out.println("Location already taken. Please select a different location: ");
        }
        board.placeMarkAtLocation(mark, location);

    }

    private int readLine() {
        try {
            return Integer.parseInt(in.readLine());
        } catch (IOException e){
            return -1;
        }
    }

}
