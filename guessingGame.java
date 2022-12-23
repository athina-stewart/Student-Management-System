import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
        String word = (fiveLetterWords[wordIndex]);
        String[] newArray = new String[fiveLetterWords.length -1];
        for (int index = 0; index < newArray.length; index++){
            if (fiveLetterWords[index] != null && !fiveLetterWords[index].equals(word) ){
                newArray[index] = fiveLetterWords[index];
            }
        }
        fiveLetterWords = newArray;
        return(word);
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
        String word;
        if (round < 3) {
            System.out.println("\n\nPLAYER 1");
            word = get5LetterWord();
            player1Score = player1Score + playTheGame(word);

            System.out.println("\n\nPLAYER 2");
            word = get5LetterWord();
            player2Score = player2Score + playTheGame(word);
            round++;
            printTheScore();
        }
        if (round == 3){
            System.out.println("PLAYER 1");
            word = get6LetterWord();
            player1Score = player1Score + playTheGame(word);

            System.out.println("PLAYER 2");
            word = get6LetterWord();
            player2Score = player2Score + playTheGame(word);
            playTheGame(word);
            round++;
            printTheScore();

        }
        if (round == 4){
            System.out.println("PLAYER 1");
            word = get7LetterWord();
            player1Score = player1Score + playTheGame(word);

            System.out.println("PLAYER 2");
            word = get7LetterWord();
            player2Score = player2Score + playTheGame(word);
            round++;
            printTheScore();
        }
    }

    private static int playTheGame(String word){
        int count = 0;
        while (count < 5){
            String playerGuess;
            printTheRound();
            System.out.println(word);
            playerGuess = getGuess();
            char[] playerGuessAsCharacters = playerGuess.toCharArray();
            if (playerGuess.equals(word)){
                System.out.println("Congratulations! You guessed the word.");
                return 10;
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
        return 0;
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
        System.out.println("\n\n---------------------");
        System.out.println("Player 1 Score: " + player1Score);
        System.out.println("                                ");
        System.out.println("                                ");
        System.out.println("Player 2 Score: " + player2Score);
        System.out.println("---------------------");
    }

    public static void main(String[] args) {
        readFile("/Users/Athina/IdeaProjects/PersonalProjects/src/wordBank.txt");
        System.out.println("\nWELCOME TO THE GUESSING GAME");
        while(round<5) {
            chooseTheRound();
        }
        System.out.println("GAME OVER");
    }
}
