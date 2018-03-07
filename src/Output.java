
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;


/**
 *
 * @author david
 */
public class Output {
    
    private LinkedList<String> sortedOutput = new LinkedList<>();
    private List<String> noise = Arrays.asList("a", "an", "the", "and", "or", "of", "to", "be", "is", "in", "out", "by", "as", "at", "off");

    public void print(ArrayList<String> inputText, ArrayList<ArrayList<Integer>> sortedIndexes) {
        for (int i = 0; i < sortedIndexes.size(); i++) {
            String output = "";
            for (int j = 0; j < sortedIndexes.get(i).size(); j++) {
                output += inputText.get(sortedIndexes.get(i).get(j));
                output += " ";
            }
            sortedOutput.add(output);
        }
        Collections.sort(sortedOutput, Collator.getInstance(Locale.US));
        Collections.sort(sortedOutput, (String o1, String o2) -> {
            
            if(getValue(o1.charAt(0)) != ' ')
            {
                if (getValue(o1.charAt(0)) > getValue(o2.charAt(0))) 
                {
                    return 1;
                }
                if (getValue(o1.charAt(0)) < getValue(o2.charAt(0)))            
                {
                    return -1;
                }
            }
           
            return 0;
        });
        for (String item : sortedOutput) {
            
            String searchWord = item.substring(0, item.indexOf(" "));
            
             if(!ignoreCase(searchWord, noise))
            {
                System.out.println(item);
            }
            
        }
    }
    
    private boolean ignoreCase(String searchWord, List<String> noise)
    {
        for(String i : noise)
        {
            if(i.equalsIgnoreCase(searchWord))
            {
                return true;
            }
        }
        
        return false;
    }
    
    private int getValue(char letter) {
        /*  Assigns a unique integer value to each character
            in the list.
        */
        switch (letter) {
            case ' ':
                return 0;
            case '0':
                return 1;
            case '1':
                return 2;
            case '2':
                return 3;
            case '3':
                return 4;
            case '4':
                return 5;
            case '5':
                return 6;
            case '6':
                return 7;
            case '7':
                return 8;
            case '8':
                return 9;
            case '9':
                return 10;
            case 'a':
                return 11;
            case 'A':
                return 12;
            case 'b':
                return 13;
            case 'B':
                return 14;
            case 'c':
                return 15;
            case 'C':
                return 16;
            case 'd':
                return 17;
            case 'D':
                return 18;
            case 'e':
                return 19;
            case 'E':
                return 20;
            case 'f':
                return 21;
            case 'F':
                return 22;
            case 'g':
                return 23;
            case 'G':
                return 24;
            case 'h':
                return 25;
            case 'H':
                return 26;
            case 'i':
                return 27;
            case 'I':
                return 28;
            case 'j':
                return 29;
            case 'J':
                return 30;
            case 'k':
                return 31;
            case 'K':
                return 32;
            case 'l':
                return 33;
            case 'L':
                return 34;
            case 'm':
                return 35;
            case 'M':
                return 36;
            case 'n':
                return 37;
            case 'N':
                return 38;
            case 'o':
                return 39;
            case 'O':
                return 40;
            case 'p':
                return 41;
            case 'P':
                return 42;
            case 'q':
                return 43;
            case 'Q':
                return 44;
            case 'r':
                return 45;
            case 'R':
                return 46;
            case 's':
                return 47;
            case 'S':
                return 48;
            case 't':
                return 49;
            case 'T':
                return 50;
            case 'u':
                return 51;
            case 'U':
                return 52;
            case 'v':
                return 53;
            case 'V':
                return 54;
            case 'w':
                return 55;
            case 'W':
                return 56;
            case 'x':
                return 57;
            case 'X':
                return 58;
            case 'y':
                return 59;
            case 'Y':
                return 60;
            case 'z':
                return 61;
            default:
                return 62;
        }
    }
    
}
