import com.sun.org.apache.xpath.internal.operations.Number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by lmarcich on 3/3/17.
 */
public class Game {
    private BufferedReader in;
    private PrintStream out;
    private Board board;


    public Game(BufferedReader in, PrintStream out, Board board) {
        this.in = in;
        this.out = out;


        this.board = board;
    }


    public void start() {
        board.display();
        playerOneLocationSelection();
    }


    private void playerOneLocationSelection() {
        out.println("Player 1- please select a space to place your mark: ");

        try {
            String markLocation = in.readLine();
            board.placeMarkAtLocation("X", Integer.parseInt(markLocation));
            board.display();
        } catch (IOException e) {

        } //catch (NumberFormatException e2){

        //}
    }





}
