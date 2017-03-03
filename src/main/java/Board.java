
import java.io.PrintStream;

/**
 * Created by lmarcich on 3/3/17.
 */
public class Board {


    private String[] board;
    private PrintStream out;


    public Board(PrintStream out, String[] board){
        this.out = out;
        this.board = board;
    }


    public void placeMarkAtLocation(String mark, int location){
        board[location - 1] = mark;
    }


    public boolean availableLocation(int location){
        return board[location - 1] == null;
    }


    public void display(){
        String boardString = "";
        for (int r = 0; r < 3; r++){
            for (int c = 0; c < 3; c++){
                if (board[r * 3 + c] != null) {
                    boardString += board[r * 3 + c];
                } else {
                    boardString += r * 3 + c + 1;
                }
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
