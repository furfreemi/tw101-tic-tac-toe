import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.verify;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by lmarcich on 3/3/17.
 */
public class BoardTest {

    private PrintStream printStream;
    private Board board;
    private List<String> boardArray;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        boardArray = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
        board = new Board(printStream, boardArray);
    }

    @Test
    public void shouldDisplayGameBoardWhenNoMovesMade(){
        board.display();
        verify(printStream).println(
                "1|2|3\n" +
                "-----\n" +
                "4|5|6\n" +
                "-----\n" +
                "7|8|9"
        );
    }



    @Test
    public void shouldDisplayCorrectMarkLocationWhenMarkMade(){
        board.placeMarkAtLocation("X", 3);
        board.display();
        verify(printStream).println(contains("1|2|X"));
    }


    @Test
    public void shouldReturnFalseWhenLocationAlreadyMarked(){
        board.placeMarkAtLocation("X", 3);

        assertFalse(board.availableLocation(3));
    }

    @Test
    public void shouldReturnTrueWhenLocationNotYetMarked(){
        assertTrue(board.availableLocation(2));
    }



}