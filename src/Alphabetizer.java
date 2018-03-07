
import java.util.ArrayList;


/**
 *
 * @author david
 */
public class Alphabetizer implements Sorter {
    
    private final ArrayList<ArrayList<Integer>> sortedIndexes = new ArrayList<>();
    private String word, comparison;
    
    @Override
    public void sort(ArrayList<String> inputText, ArrayList<ArrayList<Integer>> shiftedIndexes) {
        /* Retreives text from the original input and uses the indexes
           from the shifted lines to compare each first word to determine
           the alphabetical order.  The sorted indexes are placed into an array list.
        */
        for (int i = 0; i < shiftedIndexes.size(); i++) {
            sortedIndexes.add(shiftedIndexes.get(i));
        }
        for (int i = 1; i < sortedIndexes.size(); i++) {
            word = inputText.get(sortedIndexes.get(i).get(0));
            int index = 0;
            for (index = i - 1; index >= 0; index--) {
                comparison = inputText.get(sortedIndexes.get(index).get(0));
                if (word.compareTo(comparison) < 0) {
                    sortedIndexes.set(index + 1, sortedIndexes.get(index));
                } else {
                    break;
                }
            }
            sortedIndexes.set(index + 1, shiftedIndexes.get(i));
        }
    }
    
    @Override
    public ArrayList<ArrayList<Integer>> getSortedIndexes() {
        /* Passes the array list of sorted indexes to the output
           class for the final processing.
        */
        return this.sortedIndexes;
    }
    
}
