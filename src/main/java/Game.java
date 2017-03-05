

import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by lmarcich on 3/3/17.
 */
public class Game {
    private PrintStream out;
    private Board board;
    private final Player p1;
    private final Player p2;


    public Game(PrintStream out, Board board, Player p1, Player p2) {
        this.out = out;
        this.board = board;
        this.p1 = p1;
        this.p2 = p2;
    }


    public void start() {
        board.display();
         playerTurn(p1);
         playerTurn(p2);

    }


    private void playerTurn(Player activePlayer) {
        try {
            placePlayerMark(activePlayer);
            board.display();
        } catch (IOException e) {

        }
    }

    private void placePlayerMark(Player activePlayer) throws IOException {
        boolean placedMark = false;
        while (!placedMark) {
            int markLocation = activePlayer.locationSelection();
            if (board.isAvailableLocation(markLocation)) {
                board.placeMarkAtLocation(activePlayer.mark(), markLocation);
                placedMark = true;
            } else {
                out.println("Location already taken.");
            }
        }
    }








}
