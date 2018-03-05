
import java.util.ArrayList;


/**
 *
 * @author david
 */
public class CircularShifter {
    
    private ArrayList<ArrayList<Integer>> indexesOfShiftedLines = new ArrayList<>();
    private ArrayList<Integer> indexesOfShiftedWords;
    
    public void shift(ArrayList<String> inputText, ArrayList<Integer> lineIndexes) {
        for (int i = 0; i < lineIndexes.size(); i++) {
            int size = 0;
            if (i != lineIndexes.size() - 1) {
                size = lineIndexes.get(i + 1) - lineIndexes.get(i);
            } else {
                size = inputText.size() - lineIndexes.get(i);
            }
            int indexOfFirstWord = lineIndexes.get(i);
            for (int j = 0; j < size; j++) {
                indexesOfShiftedWords = new ArrayList<>();
                for (int k = 0; k < size; k++) {
                    indexesOfShiftedWords.add(indexOfFirstWord + ((j + k) % size));
                }
                indexesOfShiftedLines.add(indexesOfShiftedWords);
            }
        }
//        for (int i = 0; i < indexesOfShiftedLines.size(); i++) {
//            System.out.println(indexesOfShiftedLines.get(i));
//        }
    }
    
    public ArrayList<ArrayList<Integer>> getIndexes() {
        return this.indexesOfShiftedLines;
    }
    
}
