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
public class GameTest {

    private PrintStream out;
    private Game game;
    private BufferedReader in;

    @Before
    public void setUp() throws IOException {
        out = mock(PrintStream.class);
        in = mock(BufferedReader.class);
        game = new Game(in, out);
        when(in.readLine()).thenReturn("1");
        game.start();

    }


    @Test
    public void shouldDisplayBoardGuideWhenGameStarts(){
        verify(out).println("1|2|3\n" +
                "-----\n" +
                "4|5|6\n" +
                "-----\n" +
                "7|8|9");
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
    public void shouldReprintBoardWithMarkWhenFirstPlayerEntersInput() {
        verify(out).println("X|2|3\n" +
                "-----\n" +
                "4|5|6\n" +
                "-----\n" +
                "7|8|9");
    }

}