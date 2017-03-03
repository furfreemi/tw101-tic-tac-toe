import java.io.PrintStream;

/**
 * Created by lmarcich on 3/3/17.
 */
public class Board {


    private String[] board = new String[9];
    private PrintStream out;


    public Board(PrintStream out){
        this.out = out;

        for (int i = 0; i < board.length; i++){
            board[i] = i + 1 + "";
        }

    }


    public boolean placeMarkAtLocation(String mark, int location){
        board[location - 1] = mark;
        return false;
    }


    public void display(){
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
