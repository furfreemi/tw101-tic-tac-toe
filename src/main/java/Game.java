


/**
 * Created by lmarcich on 3/3/17.
 */
public class Game {
    private Board board;
    private final Player playerOne;
    private final Player playerTwo;


    public Game(Board board, Player playerOne, Player playerTwo) {
        this.board = board;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }


    public void start() {
        board.display();
        playerOne.placeMark();
        board.display();
        playerTwo.placeMark();
        board.display();
    }











}
