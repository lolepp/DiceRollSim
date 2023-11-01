package main;

import java.util.Random;
import java.util.Scanner;

public class Main { // Class which will execute the main method to practice some statistics
    
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    
    private static boolean running = true;
    private static boolean repeat = false;
    private static int numberOfDiceRolls = 0;


    public static boolean getRunning() {
        return running;
    }

    public static void setRunning(boolean bool) {
        running = bool;
    }

    public static boolean getRepeat() {
        return repeat;
    }

    public static void setRepeat(boolean bool) {
        repeat = bool;
    }

    public static int getNumberOfDiceRolls() {
        return numberOfDiceRolls;
    }

    public static void setNumberOfDiceRolls(int i) {
        numberOfDiceRolls = i;
    }

    public static void rollDiceQuestion() {
        System.out.println("Do you want to roll some dice? (y/n)");
    }
    
    public static char scannerRollDice() {
        return scanner.next().charAt(0);
    }

    public static int[] timesOfDice() {
        int[] timesOfDice = new int[6];
        for (int i = 0; i < timesOfDice.length; i++) {
            
        }
        return timesOfDice;
    }

    public static void main(String[] args) {
        int time1 = 0;
        int time2 = 0;
        int time3 = 0;
        int time4 = 0;
        int time5 = 0;
        int time6 = 0;
        
        rollDiceQuestion();
        char c = scannerRollDice();

        while (getRunning()) { // Main entry in loop 
            if (c == 'y' || c == 'Y') {
                double diceAccumulation = 0;
                if (!getRepeat()) {

                }
            } else {

            }
        }
    }


    public static void main1(String[] args) { // call all necessary methods so the dice roll simulator can begin with all the dialogue and scanner inputs needed
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Do you want to roll some dice? (y/n)");
        char diceRoll = scanner.next().charAt(0);
        boolean running = true;
        boolean repeat = false;
        int numberOfDiceRolls = 0;
        int time1 = 0;
        int time2 = 0;
        int time3 = 0;
        int time4 = 0;
        int time5 = 0;
        int time6 = 0;
        final double ONETOSIX = 0.1666;
        while (running) {
            if (diceRoll == 'y' || diceRoll == 'Y') {
                double diceAccumulation = 0;
                if (!(repeat)) {
                    System.out.println("How many dice do you want to roll?");
                    numberOfDiceRolls = scanner.nextInt();
                }
                System.out.println("Here are your dice rolls:");
                for (int i = 0; i <= numberOfDiceRolls - 1; i++) {
                    int randomDiceRoll = random.nextInt(1, 7);

                    switch (randomDiceRoll) {
                        case 1:
                            time1++;
                            break;
                        case 2:
                            time2++;
                            break;
                        case 3:
                            time3++;
                            break;
                        case 4:
                            time4++;
                            break;
                        case 5:
                            time5++;
                            break;
                        case 6:
                            time6++;
                            break; 
                    }
                    diceAccumulation += randomDiceRoll;
                    System.out.print(randomDiceRoll);
                    if (numberOfDiceRolls > 1 && (i != numberOfDiceRolls - 1)) {
                        System.out.print(", ");
                    }
                }

                
                double diceAverage = ((double) (diceAccumulation / numberOfDiceRolls));
                double diceDeviation = (3.5 - diceAverage);
                diceDeviation = Math.abs(diceDeviation);
                
                double portion1 = (double) time1 / numberOfDiceRolls;
                double portion2 = (double) time2 / numberOfDiceRolls;
                double portion3 = (double) time3 / numberOfDiceRolls;
                double portion4 = (double) time4 / numberOfDiceRolls;
                double portion5 = (double) time5 / numberOfDiceRolls;
                double portion6 = (double) time6 / numberOfDiceRolls ;

                System.out.println();
                System.out.println("Just as a reminder, you rolled " + numberOfDiceRolls + " dice.");
                System.out.println("This is how often you rolled a '1': " + time1 + ". That equals " + (portion1 * 100) + " %.");
                System.out.println("This is how often you rolled a '2': " + time2 + ". That equals " + (portion2 * 100) + " %.");
                System.out.println("This is how often you rolled a '3': " + time3 + ". That equals " + (portion3 * 100) + " %.");
                System.out.println("This is how often you rolled a '4': " + time4 + ". That equals " + (portion4 * 100) + " %.");
                System.out.println("This is how often you rolled a '5': " + time5 + ". That equals " + (portion5 * 100) + " %.");
                System.out.println("This is how often you rolled a '6': " + time6 + ". That equals " + (portion6 * 100) + " %.");
                System.out.println("And to remind you of another fact, 1/6 equals " + ONETOSIX*100 + " %.");
                System.out.println("Your last dice roll average equaled to: " + diceAverage);
                System.out.println("The deviation of the theoretical average point of 3.5 equals to: " + diceDeviation);
                System.out.println("The deviation times one hundred equals to: " + diceDeviation * 100);
                System.out.println("So anyway, ...");
                System.out.println("Do you want to roll the dice once again or repeat what you just did? (y/n/r)");
                char anotherRoll = scanner.next().charAt(0);
                if (anotherRoll == 'y' || anotherRoll == 'Y') {
                    repeat = false;
                } else if (anotherRoll == 'r' || anotherRoll == 'R') {
                    repeat = true;
                } else {
                    System.out.println("You failed!");
                    running = false;
                }
                time1 = 0;
                time2 = 0;
                time3 = 0;
                time4 = 0;
                time5 = 0;
                time6 = 0;
            } else {
                System.out.println("You failed!");
                running = false;
            }
        }
        scanner.close();
    }
}
