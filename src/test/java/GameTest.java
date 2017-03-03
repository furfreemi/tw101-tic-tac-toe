import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

/**
 * Created by lmarcich on 3/3/17.
 */
public class GameTest {

    private PrintStream out;
    private Game game;
    private BufferedReader in;
    private Board board;
    private Player p1;
    private Player p2;

    @Before
    public void setUp() throws IOException {
        out = mock(PrintStream.class);
        in = mock(BufferedReader.class);
        board = mock(Board.class);
        p1 = mock(Player.class);
        p2 = mock(Player.class);
        when(p1.mark()).thenReturn("X");
        when(p2.mark()).thenReturn("O");
        game = new Game(out, board, p1, p2);
    }


    @Test
    public void shouldDisplayBoardGuideWhenGameStarts() throws IOException {
        when(p1.locationSelection()).thenReturn(1);
        when(p2.locationSelection()).thenReturn(3);
        when(board.availableLocation(1)).thenReturn(true);
        when(board.availableLocation(3)).thenReturn(true);
        game.start();
        verify(board, atLeast(1)).display();
    }





    @Test
    public void shouldPromptFirstPlayerForSpaceSelection() throws IOException {
        when(p1.locationSelection()).thenReturn(1);
        when(p2.locationSelection()).thenReturn(3);
        when(board.availableLocation(1)).thenReturn(true);
        when(board.availableLocation(3)).thenReturn(true);
        game.start();
        verify(p1, atLeast(1)).locationSelection();
    }



    @Test
    public void shouldPlaceMarkAtLocationWhenFirstPlayerTurnComplete() throws IOException {
        when(p1.locationSelection()).thenReturn(1);
        when(p2.locationSelection()).thenReturn(3);
        when(board.availableLocation(1)).thenReturn(true);
        when(board.availableLocation(3)).thenReturn(true);
        game.start();
        verify(board).placeMarkAtLocation("X", 1);
    }


    @Test
    public void shouldReprintBoardWithMarkWhenFirstPlayerEntersInput() throws IOException {
        when(p1.locationSelection()).thenReturn(1);
        when(p2.locationSelection()).thenReturn(3);
        when(board.availableLocation(1)).thenReturn(true);
        when(board.availableLocation(3)).thenReturn(true);
        game.start();
        verify(board, atLeast(2)).display();
    }




    @Test
    public void shouldPlaceMarkAtLocationWhenSecondPlayerTurnComplete() throws IOException {
        when(p1.locationSelection()).thenReturn(1);
        when(p2.locationSelection()).thenReturn(3);
        when(board.availableLocation(1)).thenReturn(true);
        when(board.availableLocation(3)).thenReturn(true);
        game.start();
        verify(board).placeMarkAtLocation("O", 3);
    }


    @Test
    public void shouldReprintBoardWithMarkWhenSecondPlayerEntersInput() throws IOException {
        when(p1.locationSelection()).thenReturn(1);
        when(p2.locationSelection()).thenReturn(3);
        when(board.availableLocation(1)).thenReturn(true);
        when(board.availableLocation(3)).thenReturn(true);
        game.start();
        verify(board, atLeast(3)).display();
    }



    @Test
    public void shouldPrintMessageWhenLocationTaken() throws IOException {
        when(p1.locationSelection()).thenReturn(1);
        when(p2.locationSelection()).thenReturn(1, 3);
        when(board.availableLocation(1)).thenReturn(true, false);
        when(board.availableLocation(3)).thenReturn(true);
        game.start();
        verify(out).println("Location already taken.");
    }


}