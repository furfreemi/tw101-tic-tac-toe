import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by lmarcich on 3/3/17.
 */
public class GameTest {

    private PrintStream out;
    private Game game;
    private BufferedReader in;
    private Board board;

    @Before
    public void setUp() throws IOException {
        out = mock(PrintStream.class);
        in = mock(BufferedReader.class);
        board = mock(Board.class);
        game = new Game(in, out, board);
        when(in.readLine()).thenReturn("1");
        game.start();
    }


    @Test
    public void shouldDisplayBoardGuideWhenGameStarts(){
        verify(board, atLeast(1)).display();
    }


    @Test
    public void shouldPromptFirstPlayerForSpaceSelection(){
        verify(out).println("Player 1- please select a space to place your mark: ");
    }


    @Test
    public void shouldReadSelectionFromFirstPlayer() throws IOException {
        verify(in).readLine();
    }

    @Test
    public void shouldPlaceMarkAtLocationWhenFirstPlayerTurnComplete() {
        verify(board).placeMarkAtLocation("X", 1);
    }


    @Test
    public void shouldReprintBoardWithMarkWhenFirstPlayerEntersInput() {
        verify(board, atLeast(2)).display();
    }

}