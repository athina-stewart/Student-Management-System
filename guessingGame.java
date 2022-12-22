import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class guessingGame {
    static int player1Score;
    static int player2Score;

    private static void readFile() {
        try {
            BufferedReader in = new BufferedReader(new FileReader("wordBank.tx"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        readFile();
    }
}
