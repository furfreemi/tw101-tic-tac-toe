import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by lmarcich on 3/3/17.
 */
public class GameTest {


    @Test
    public void shouldDisplayBoardGuideWhenGameStarts(){
        PrintStream out = mock(PrintStream.class);
        Game game = new Game(out);
        game.start();
        verify(out).println("1|2|3\n" +
                "-----\n" +
                "4|5|6\n" +
                "-----\n" +
                "7|8|9");
    }

}