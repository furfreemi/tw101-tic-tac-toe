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
        when(in.readLine()).thenReturn("1", "3", "3", "4");
        when(board.availableLocation(1)).thenReturn(true);
        when(board.availableLocation(3)).thenReturn(true, false);
        when(board.availableLocation(4)).thenReturn(true);
        game.start();
    }


    @Test
    public void shouldDisplayBoardGuideWhenGameStarts(){
        verify(board, atLeast(1)).display();
    }







    @Test
    public void shouldPromptFirstPlayerForSpaceSelection(){
        verify(out, atLeast(1)).println("Player 1- please select a space to place your mark: ");
    }


    @Test
    public void shouldReadSelectionFromFirstPlayer() throws IOException {
        verify(in, atLeast(1)).readLine();
    }

    @Test
    public void shouldPlaceMarkAtLocationWhenFirstPlayerTurnComplete() {
        verify(board).placeMarkAtLocation("X", 1);
    }


    @Test
    public void shouldReprintBoardWithMarkWhenFirstPlayerEntersInput() {
        verify(board, atLeast(2)).display();
    }







    @Test
    public void shouldPromptSecondForSpaceSelection(){
        verify(out, atLeast(1)).println("Player 2- please select a space to place your mark: ");
    }

    @Test
    public void shouldReadSelectionFromSecondPlayer() throws IOException {
        verify(in, atLeast(2)).readLine();
    }


    @Test
    public void shouldPlaceMarkAtLocationWhenSecondPlayerTurnComplete() {
        verify(board).placeMarkAtLocation("O", 3);
    }


    @Test
    public void shouldReprintBoardWithMarkWhenSecondPlayerEntersInput() {
        verify(board, atLeast(3)).display();
    }







    @Test
    public void shouldPrintMessageWhenLocationTaken(){
        verify(out).println("Location already taken.");
    }

}