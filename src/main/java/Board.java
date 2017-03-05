
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lmarcich on 3/3/17.
 */
public class Board {


    private List<String> locations;
    private List<String> originalLocations;
    private PrintStream out;


    public Board(PrintStream out, List<String> locations){
        this.out = out;
        this.locations = locations;
        this.originalLocations = new ArrayList<String>(locations);
    }


    public void placeMarkAtLocation(String mark, int location){
        locations.set(location - 1, mark);
    }


    public boolean isAvailableLocation(int location){
        int index = location - 1;
        return locations.get(index).equals(originalLocations.get(index));
    }



    public void display(){
        String boardString = String.format(
                        "%s|%s|%s\n" +
                        "-----\n" +
                        "%s|%s|%s\n" +
                        "-----\n" +
                        "%s|%s|%s", locations.toArray());

        out.println(boardString);
    }


}
