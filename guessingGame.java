import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class guessingGame {
    static int player1Score;
    static int player2Score;
    static int round = 0;
    static String[] fiveLetterWords = new String[15];
    static String[] sixLetterWords = new String[15];
    static String[] sevenLetterWords = new String[15];

    private static void readFile(String fileName) {
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))){
            int counter1 = 0;
            int counter2 = 0;
            int counter3 = 0;
            String word;
            while ((word = in.readLine()) != null){
                if (word.length() == 5){
                    fiveLetterWords[counter1++] = word;
                }
                if (word.length() == 6){
                    sixLetterWords[counter2++] = word;
                }
                if (word.length() == 7){
                    sevenLetterWords[counter3++] = word;
                }
            }
            System.out.println(Arrays.toString(fiveLetterWords));
            System.out.println(Arrays.toString(sixLetterWords));
            System.out.println(Arrays.toString(sevenLetterWords));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String get5LetterWord(){
        int theWordsLength = fiveLetterWords.length;
        int wordIndex = (int)(Math.random() * (theWordsLength));
        if (fiveLetterWords[wordIndex] == null){
            return(get5LetterWord());
        }
        return(fiveLetterWords[wordIndex]);
    }

    private static String get6LetterWord(){
        int theWordsLength = sixLetterWords.length;
        int wordIndex = (int)(Math.random() * (theWordsLength));
        if (sixLetterWords[wordIndex] == null){
            return(get6LetterWord());
        }
        return(sixLetterWords[wordIndex]);
    }

    private static String get7LetterWord(){
        int theWordsLength = sevenLetterWords.length;
        int wordIndex = (int)(Math.random() * (theWordsLength));
        if (sevenLetterWords[wordIndex] == null){
            return(get7LetterWord());
        }
        return(sevenLetterWords[wordIndex]);
    }

    private static void playTheGame(){
        while (round < 5){
            printTheRound();
            if (round < 3) {
                String word = get5LetterWord();
                System.out.println(word);
                round++;
            }
            if (round == 3){
                printTheRound();
                round++;
            }
            if (round == 4){
                printTheRound();
                round++;
            }
        }
    }

    private static void printTheRound(){
        System.out.println("THIS IS ROUND " + (round+1) + " !\n");
        if ((round + 1) == 4){
            System.out.println("DOUBLE POINTS!\n");
        }
        if ((round + 1) == 5){
            System.out.println("TRIPLE POINTS!\n");
        }
    }

    private static void printTheScore(){

    }

    public static void main(String[] args) {
        readFile("/Users/Athina/IdeaProjects/PersonalProjects/src/wordBank.txt");
        playTheGame();
    }
}
