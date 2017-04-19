import gol.GameBoard;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cortman on 4/18/17.
 */
public class GameBoardTest {

    @Test
    public void computesCorrectXAndYForCell() {
        int[] coords = GameBoard.computeCoords(0,0); //the first cell should start at 0,0
        assertArrayEquals(new int[] {0,0}, coords);

        //2nd cell should be at x:20, y:0
        coords = GameBoard.computeCoords(0,1);
        assertArrayEquals(new int[] {20,0}, coords);

        //3rd cell in 2nd row should be at x:40, y:20
        coords = GameBoard.computeCoords(1,2);
        assertArrayEquals(new int[] {40,20}, coords);

    }

}