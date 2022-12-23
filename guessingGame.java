import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class guessingGame {
    static int player1Score;
    static int player2Score;
    static String[] fiveLetterWords = new String[100000];
    static String[] sixLetterWords = new String[100000];
    static String[] sevenLetterWords = new String[100000];

    private static void readFile(String fileName) {
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))){
            int counter1 = 0;
            int counter2 = 0;
            int counter3 = 0;
            while (in.readLine() != null){
                if (in.readLine().length() == 5){
                    fiveLetterWords[counter1++] = in.readLine();
                }
                if (in.readLine().length() == 6){
                    sixLetterWords[counter2++] = in.readLine();
                }
                if (in.readLine().length() == 7){
                    sevenLetterWords[counter3++] = in.readLine();
                }
            }
            System.out.println(Arrays.toString(fiveLetterWords));
            System.out.println(Arrays.toString(sixLetterWords));
            System.out.println(Arrays.toString(sevenLetterWords));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getWord(){
        return("");
    }

    private static void playTheGame(){

    }

    private static void printTheRound(){

    }

    private static void printTheScore(){

    }

    public static void main(String[] args) {
        readFile("/Users/Athina/IdeaProjects/PersonalProjects/src/wordBank.txt");
    }
}
