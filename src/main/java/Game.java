

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
    private boolean playerOneTurn = true;


    public Game(BufferedReader in, PrintStream out, Board board) {
        this.in = in;
        this.out = out;


        this.board = board;
    }


    public void start() {
        board.display();
         playerMarkSelection();
         playerMarkSelection();
         playerMarkSelection();

    }


    private void playerMarkSelection() {
        String mark = "X";
        int player = 1;

        if (!playerOneTurn){
            mark = "O";
            player = 2;
        }

        try {
            boolean placedMark = false;
            while (!placedMark) {
                out.println("Player " + player + "- please select a space to place your mark: ");
                int markLocation = Integer.parseInt(in.readLine());
                if (board.availableLocation(markLocation)) {
                    board.placeMarkAtLocation(mark, markLocation);
                    placedMark = true;
                } else {
                    out.println("Location already taken.");
                }
            }
            board.display();
        } catch (IOException e) {

        }
        playerOneTurn = !playerOneTurn;
    }






}
