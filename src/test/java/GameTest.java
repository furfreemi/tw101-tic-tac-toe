import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

/**
 * Created by lmarcich on 3/3/17.
 */
public class GameTest {

    private Game game;
    private Board board;
    private Player playerOne;
    private Player playerTwo;

    @Before
    public void setUp() throws IOException {
        board = mock(Board.class);
        playerOne = mock(Player.class);
        playerTwo = mock(Player.class);
        game = new Game(board, playerOne, playerTwo);
    }


    @Test
    public void shouldDisplayBoardGuideWhenGameStarts() throws IOException {
        game.start();
        verify(board, atLeast(3)).display();
    }




    @Test
    public void shouldTellPlayerOneToMove() throws IOException {
        game.start();
        verify(playerOne, atLeast(1)).placeMark();
    }



    @Test
    public void shouldTellPlayerTwoToMove() throws IOException {
        game.start();
        verify(playerTwo, atLeast(1)).placeMark();
    }







}