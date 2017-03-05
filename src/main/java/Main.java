import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lmarcich on 3/3/17.
 */
public class Main {

    public static void main(String[] args) {
        List<String> boardArray = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
        Board board = new Board(System.out, boardArray);
        Player playerOne = new Player(new BufferedReader(new InputStreamReader(System.in)), System.out, "One", "X", board);
        Player playerTwo = new Player(new BufferedReader(new InputStreamReader(System.in)), System.out, "Two", "O", board);
        new Game(board, playerOne, playerTwo).start();
    }

}
