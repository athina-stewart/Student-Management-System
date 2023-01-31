/**
 *  PiDigitDistribution.java
 *
 * Version:
 *     17.0.2
 *
 * Revisions:
 *     1-11/19/2022
 */

/**
 *
 *
 * @author      Athina Stewart
 * @author      Shreya Jadhav
 */

import java.io.*;

public class PiDigitDistribution extends Thread{
    /** The class NumberEqualCube tests if a number has the following property:
     * the sum of each digit raised the power of the number of digits in the
     * number is equal to the number
     * @param         number          the index of pi being tested
     * @param         endNum          the last index in a range of numbers to
     *                                be tested by oe thread
     * @param         numberOfThreads the number of threads used to determine
     *                                the frequency of distribution of the
     *                                digits of pi
     * @param         piArray         array to store the digits of pi as string
     *                                characters
     * @param         id                    unique id of thread
     * @param         distributionArray     array to store the
     *                                      distribution of digits per thread
     * @param         sumSet           array to store frequency of the total
     *                                 distribution of digits
     */
    private final int id;
    static int numberOfThreads;
    private static int number;
    private static int endNum;
    private static char[] piArray;
    private final int[] distributionArray;
    private static int[] sumSet = new int[10];


    public static int getNumberOfThreads() {
        /** The method returns the number of threads
         */
        return numberOfThreads;
    }

    public static void setNumberOfThreads(int numberOfThreads) {
        /** The method sets the number of threads
         */
        PiDigitDistribution.numberOfThreads = numberOfThreads;
    }

    public PiDigitDistribution(int id, int[] distributionArray) {
        /** Constructor for a thread
         */
        this.id = id;
        this.distributionArray = distributionArray;
    }

    @Override
    public void run(){
        /** Override of default Thread run method
         */

        for (int i = number; i < endNum; i++){
            for (int j = 0; j < 10; j++) {
                if (Integer.parseInt(String.valueOf(piArray[i])) == j) {
                    distributionArray[j]++;
                }
            }
        }
    }

    public static String readFile(){
        /** This method reads the first million digits of pi
         * @param         digits          stores the digits of pi
         * @param         line            stores each line in the file
         * @param         input           the buffered reader object
         */
        BufferedReader input;
        String digits = null;

        try {
            String line;
            input = new BufferedReader(
                    new FileReader(
                            "milliondigitsofpi.txt"));
            while ((line = input.readLine()) != null) {
                digits = line.replace(".", "");
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("ExceptionType occurred: " +
                    e.getMessage());
        }
        return digits;
    }

    public static void CreateThreads(){
        /** The method creates the required number of threads and returns
         * the distribution of the digits of pi after each thread is
         * completed
         * @param         sum                   verifies the sum of the
         *                                      distribution of the digits
         * @param         numberOfProcessesPerThread number of tests per thread
         * @param         piArray               the digits of pi represented as
         *                                      a char array
         * @param         numbers               object of piOddEvenImprovement
         * @param         sumSet                an array storing the
         *                                      distribution of the digits of
         *                                      pi
         * @param         counter,counter2,counter3  for-loop counter variables
         * @param         numberOfNumbers            number of numbers to be
         *                                           tested
         */
        int sum = 0;
        String numberOfNumbers = readFile();
        piArray = numberOfNumbers.toCharArray();
        int numberOfProcessesPerThread = numberOfNumbers.length() / numberOfThreads;
        int count = 0;
        while (endNum < numberOfNumbers.length()) {
            endNum = endNum + numberOfProcessesPerThread;
            if ((numberOfNumbers.length() - endNum) < numberOfProcessesPerThread) {
                endNum = endNum + (numberOfNumbers.length() - endNum);
            }
            PiDigitDistribution numbers = new PiDigitDistribution(count, new int[10]);
            numbers.start();
            try {
                numbers.join();
                int counter = 0;
                for (int distributionPerDigit : numbers.distributionArray) {
                    sumSet[counter] += distributionPerDigit;
                    counter++;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            number = endNum;
        }
        System.out.println("Distribution of the first million digits of pi: ");
        for (int counter2 = 0; counter2 < 10; counter2 ++){
            System.out.println(counter2 + ": " + sumSet[counter2]);
        }
        System.out.println("\nTotal sum of digits: ");
        for (int counter3 = 0; counter3 < 10; counter3++){
            sum += sumSet[counter3];
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        /** This is the main method
         * @param         start                      marker set before executing
         *                                           the program
         * @param         end                        marker set after executing
         *                                           the program
         * @param         executionTime              the time taken to execute
         *                                           the program
         */
        if (args.length != 1){
            System.out.println("Please enter an appropriate argument for the "+
                    "number of threads.");
            return;
        }
        setNumberOfThreads(Integer.parseInt(args[0]));

        long start = System.nanoTime();
        CreateThreads();
        long end = System.nanoTime();
        long executionTime = end - start;
        System.out.println("Execution time is: " + (executionTime/0.0000000001) + " seconds.");
    }

}
