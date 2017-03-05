import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
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
    private List<String> locations;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        locations = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
        board = new Board(printStream, locations);
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
    public void shouldMarkCorrectLocationWhenMarkMade(){
        board.placeMarkAtLocation("mark test", 3);

        assertThat(locations.get(2), is("mark test"));
    }



    @Test
    public void shouldDisplayCorrectMarkLocationWhenMarkMade(){
        locations.set(2, "mark test");
        board.display();
        verify(printStream).println(contains("1|2|mark test"));
    }


    @Test
    public void locationShouldBeUnavailableWhenLocationAlreadyMarked(){
        locations.set(2, "any string");

        assertThat(board.isAvailableLocation(3), is(false));
    }


    @Test
    public void locationShouldBeAvailableWhenLocationUnmarked(){
        assertThat(board.isAvailableLocation(2), is(true));
    }



}