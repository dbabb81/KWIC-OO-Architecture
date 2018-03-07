
import java.util.ArrayList;


/**
 *
 * @author david
 */
public interface Sorter {
    
    void sort(ArrayList<String> input, ArrayList<ArrayList<Integer>> indexes);
    ArrayList<ArrayList<Integer>> getSortedIndexes();
    
}
