import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

/**
 * Created by lmarcich on 3/3/17.
 */
public class PlayerTest {


    private PrintStream out;
    private BufferedReader in;
    private Player player;
    private Board board;


    @Before
    public void setUp() throws IOException {

        out = mock(PrintStream.class);
        in = mock(BufferedReader.class);
        board = mock(Board.class);
        player = new Player(in, out, "", "", board);

        when(in.readLine()).thenReturn("-1");
        when(board.isAvailableLocation(anyInt())).thenReturn(true);

    }


    @Test
    public void shouldPrintMessageToPlayerWhenPlayerTurn() throws IOException {
        player = new Player(in, out, "player name", "", board);

        player.placeMark();

        verify(out).println("Player player name- please select a space to place your mark: ");

    }


    @Test
    public void shouldMarkBoardAtLocationWhenPlayerEntersLocation() throws IOException {
        when(in.readLine()).thenReturn("5");

        player.placeMark();

        verify(board).placeMarkAtLocation(anyString(), eq(5));

    }


    @Test
    public void shouldPlaceCorrectMarkWhenPlayerEntersLocation(){
        player = new Player(in, out, "", "identifying mark", board);

        player.placeMark();

        verify(board).placeMarkAtLocation(eq("identifying mark"), anyInt());
    }


    @Test
    public void shouldNotPlaceMarkWhenLocationIsNotAvailable() throws IOException {
        when(board.isAvailableLocation(5)).thenReturn(false, true);
        when(in.readLine()).thenReturn("5", "7");

        player.placeMark();

        verify(board, never()).placeMarkAtLocation(anyString(), eq(5));
    }

    @Test
    public void shouldPromptPlayerToEnterAnotherLocationWhenEnteredLocationUnavailable(){
        when(board.isAvailableLocation(-1)).thenReturn(false, true);

        player.placeMark();

        verify(out).println(contains("already taken"));
    }



    @Test
    public void shouldPromptPlayerForInputUntilValidInputEntered() throws IOException {
        when(board.isAvailableLocation(anyInt())).thenReturn(false, false, false, true);

        player.placeMark();

        verify(in, times(4)).readLine();
    }

}