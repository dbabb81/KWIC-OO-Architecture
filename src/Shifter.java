
import java.util.ArrayList;


/**
 *
 * @author david
 */
public interface Shifter {
    
    void shift(ArrayList<String> input, ArrayList<Integer> indexes);
    ArrayList<ArrayList<Integer>> getShiftedIndexes();
    
}
