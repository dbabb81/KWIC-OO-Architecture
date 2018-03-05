
import java.util.ArrayList;


/**
 *
 * @author david
 */
public class Alphabetizer {
    
    private ArrayList<ArrayList<Integer>> sortedIndexes = new ArrayList<>();
    private String word, comparison;
    
    public void alphabetize(ArrayList<String> inputText, ArrayList<ArrayList<Integer>> shiftedIndexes) {
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
//        for (int i = 0; i < sortedIndexes.size(); i++) {
//            System.out.println(sortedIndexes.get(i));
//        }
    }
    
    public ArrayList<ArrayList<Integer>> getIndexes() {
        return this.sortedIndexes;
    }
    
}
