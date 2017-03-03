import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by lmarcich on 3/3/17.
 */
public class PlayerTest {


    private PrintStream out;
    private BufferedReader in;
    private Player player;


    @Before
    public void setUp() throws IOException {
        out = mock(PrintStream.class);
        in = mock(BufferedReader.class);
        player = new Player(in, out, 1, "X");
    }

    @Test
    public void shouldPrintMessageToPlayerWhenPlayerTurn() throws IOException {
        when(in.readLine()).thenReturn("1");

        player.locationSelection();

        verify(out).println("Player 1- please select a space to place your mark: ");

    }

    @Test
    public void shouldReturnSelectedLocationWhenPlayerEntersSelection() throws IOException {
        when(in.readLine()).thenReturn("5");

        assertEquals(5, player.locationSelection());
    }

}