import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by lmarcich on 3/3/17.
 */
public class Main {

    public static void main(String[] args) {
        new Game(new BufferedReader(new InputStreamReader(System.in)), System.out, new Board(System.out, new String[9])).start();
    }

}
