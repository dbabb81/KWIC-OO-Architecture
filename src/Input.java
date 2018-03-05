
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
    
    private ArrayList<String> inputText = new ArrayList<>();
    private ArrayList<Integer> lineIndexes = new ArrayList<>();
    private BufferedReader reader;
    private String line;
    
    public void parse(String file) {
        try {
            reader = new BufferedReader(new FileReader(file));
            line = reader.readLine();
            while (line != null) {
                String[] words = line.split(" ");
                lineIndexes.add(inputText.size());
                for (int i = 0; i < words.length; i++) {
                    inputText.add(words[i]);
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
        return this.inputText;
    }
    
    public ArrayList<Integer> getIndexes() {
        return this.lineIndexes;
    }
    
}
