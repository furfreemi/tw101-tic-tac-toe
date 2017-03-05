
import java.io.PrintStream;
import java.util.List;

/**
 * Created by lmarcich on 3/3/17.
 */
public class Board {


    private List<String> board;
    private PrintStream out;


    public Board(PrintStream out, List<String> board){
        this.out = out;
        this.board = board;
    }


    public void placeMarkAtLocation(String mark, int location){
        board.set(location - 1, mark);
    }


    public boolean availableLocation(int location){
        return isNumber(board.get(location - 1));
    }


    private boolean isNumber(String location){
        try {
            Integer.parseInt(location);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }


    public void display(){
        String boardString = String.format(
                        "%s|%s|%s\n" +
                        "-----\n" +
                        "%s|%s|%s\n" +
                        "-----\n" +
                        "%s|%s|%s", board.toArray());

        out.println(boardString);
    }


}
