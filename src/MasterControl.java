
/**
 *
 * @author david
 */
public class MasterControl {
    
    private static Input input;
    private static CircularShifter circularShifter;
    private static Alphabetizer alphabetizer;
    private static Output output;
    private static final String SOURCE_FILE = "test.txt";
    private static long tStart;
    private static long tEnd;
    
    public static void main(String[] args) {
        tStart = System.nanoTime();
        input = new Input();
        input.parse(SOURCE_FILE);
        circularShifter = new CircularShifter();
        circularShifter.shift(input.getText(), input.getIndexes());
        alphabetizer = new Alphabetizer();
        alphabetizer.alphabetize(input.getText(), circularShifter.getIndexes());
        output = new Output();
        output.print(input.getText(), alphabetizer.getIndexes());
        tEnd = System.nanoTime();
        
        System.out.print("Finished in: ");
        System.out.print((tEnd - tStart) / 1e9);
        System.out.println(" seconds.");
    }
    
}
