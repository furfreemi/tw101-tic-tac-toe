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
    private String[] board = new String[9];


    public Game(BufferedReader in, PrintStream out) {
        this.in = in;
        this.out = out;

        for (int i = 0; i < board.length; i++){
            board[i] = i + 1 + "";
        }
    }


    public void start() {
        displayBoard();
        getPlayerOneLocationSelection();
    }


    private void getPlayerOneLocationSelection() {
        out.println("Player 1- please select a space to place your mark: ");

        try {
            String markLocation = in.readLine();
            board[Integer.parseInt(markLocation) - 1] = "X";
            displayBoard();
        } catch (IOException e) {

        } //catch (NumberFormatException e2){

        //}
    }


    private void displayBoard(){
        String boardString = "";
        for (int r = 0; r < 3; r++){
            for (int c = 0; c < 3; c++){
                boardString += board[r * 3 + c];
                if (c < 2){
                    boardString += "|";
                }
            }
            if (r < 2){
            boardString += "\n-----\n";
            }
        }
        out.println(boardString);
    }


}
