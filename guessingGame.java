import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class guessingGame {
    static int player1Score;
    static int player2Score;
    static int round = 0;
    static String[] fiveLetterWords = new String[15];
    static String[] sixLetterWords = new String[15];
    static String[] sevenLetterWords = new String[15];
    static final Scanner in = new Scanner(System.in);

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

    private static void chooseTheRound(){
        if (round < 3) {
            String word = get5LetterWord();
            playTheGame(word);
        }
        if (round == 3){
            String word = get6LetterWord();
            playTheGame(word);
        }
        if (round == 4){
            String word = get7LetterWord();
            playTheGame(word);
        }
    }

    private static void playTheGame(String word){
        int count = 0;
        while (count < 5){
            String playerGuess;
            printTheRound();
            System.out.println(word);
            playerGuess = getGuess();
            char[] playerGuessAsCharacters = playerGuess.toCharArray();
            if (playerGuess.equals(word)){
                System.out.println("Congratulations! You guessed the word.");
                round++;
                return;
            }
            for (int index= 0; index < playerGuessAsCharacters.length; index++){
                int guessIndex = playerGuess.indexOf(word.charAt(index));
                if (playerGuess.charAt(index) == word.charAt(index)){
                    System.out.print("*");
                }
                else if ((guessIndex >= 0) &&
                        (playerGuess.charAt(index) != word.charAt(index))){
                    System.out.print("_");
                }
                if (guessIndex == -1){
                    System.out.print("X");
                }
            }
            count++;
            System.out.println("\nYou have " + (5-count) + " guesses remaining.");
        }
        System.out.println("You did not guess the word.");
        round++;
    }

    private static String getGuess(){
        System.out.println("Your guess: ");
        String guess = in.nextLine();
        if (guess.length()!=5){
            System.out.println("Your word is not the correct length");
            return getGuess();
        }
        return guess;
    }

    private static void printTheRound(){
        System.out.println("\nTHIS IS ROUND " + (round+1) + "!");
        System.out.println("Enter a 5 letter word.");
        if ((round + 1) == 4){
            System.out.println("\nDOUBLE POINTS!");
            System.out.println("Enter a 6 letter word.");
        }
        if ((round + 1) == 5){
            System.out.println("\nTRIPLE POINTS!");
            System.out.println("Enter a 7 letter word.");
        }
    }

    private static void printTheScore(){

    }

    public static void main(String[] args) {
        readFile("/Users/Athina/IdeaProjects/PersonalProjects/src/wordBank.txt");
        while(round<5) {
            chooseTheRound();
        }
    }
}
