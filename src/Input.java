
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author david
 */
public class Input {
    
    private final ArrayList<String> inputText = new ArrayList<>();
    private final ArrayList<Integer> lineIndexes = new ArrayList<>();
    private BufferedReader reader;
    private String line;
    
    public void parse(String file) {
        /* This reads the source file and inserts the words into an
           array list of strings.  The indexes for each line of text
           are inserted into an array list of integers.
        */
        try {
            reader = new BufferedReader(new FileReader(file));
            line = reader.readLine();
            while (line != null) {
                String[] words = line.split(" ");
                lineIndexes.add(inputText.size());
                for (String word : words) {
                    inputText.add(word);
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException exc) {
            System.err.println("Error: Could not open file " + file);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Error: Could not read file " + file);
            System.exit(1);
        }
    }
    
    public ArrayList<String> getText() {
        /* This passes the text from the source file to the
           next process, either the circular shifter or the
           alphabetizer.
        */
        return this.inputText;
    }
    
    public ArrayList<Integer> getLineIndexes() {
        /* Passes the indexes of each line of text to the
           circular shifter for further manipulation.
        */
        return this.lineIndexes;
    }
    
}
