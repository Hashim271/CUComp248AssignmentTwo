// -----------------------------------------------------------------------------------------------------------------------------------
// Assignment 2: Algorithm 1: Calories Burned Calculator
// Written by: Muhammad Hashim Ali (40265443)
// For COMP 248 Section S 2262 - Fall 2026
// Date: 2026-10-10
//
// The program asks the user to choose a difficulty level and enter their adventurer name.
// It then gices the user tthree puzzles to solve and adjusts their score based on their answers and difficulty.
// Finally, it displays their score and outcome, and asks if they want to save their score to the Hall of Fame.
//
// -----------------------------------------------------------------------------------------------------------------------------------

import java.util.Scanner; // Import Scanner

public class A2_Q1 {

    public static void main(String[] args) {

        // Welcome message
        System.out.println("\\---------------------------------------------/");
        System.out.println("/     Welcome to the COMP-248 Escape Room!    /");
        System.out.println("\\---------------------------------------------/");
        System.out.println("");

        final int BASE_SCORE = 100; // Base score for the game
        int choice; // Variable to store the user's choice of difficulty level
        double multiplier, score = BASE_SCORE; // Initialize score with base score

        // Create a Scanner object to read input
        Scanner scan = new Scanner(System.in);

        // Display the difficulty level options to the user
        System.out.println("Choose your difficulty level:");
        System.out.println("1  - Easy (score multiplier: x1.0)");
        System.out.println("2  - Medium (score multiplier: x1.5)");
        System.out.println("3  - Hard (score multiplier: x2.0)");

        // Prompt the user for their choice of difficulty level
        System.out.print("your choice: ");
        choice = scan.nextInt();
        String difficultyLevel;

        // Determine the score multiplier based on the user's choice
        if (choice == 1) {
            multiplier = 1.0;
            difficultyLevel = "Easy";
        } else if (choice == 2) {
            multiplier = 1.5;
            difficultyLevel = "Medium";
        } else {
            multiplier = 2.0;
            difficultyLevel = "Hard";
        }

        // Prompt the user for their adventurer name
        System.out.print("Enter your adventurer name: ");
        String name = scan.next();

        // Puzzle 1: The Combination Lock
        System.out.println("");
        System.out.println("--- Puzzle 1: The Combinantion Lock ---");
        System.out.println("A rusty lock hangs on the door. The sum of the first 5 even");
        System.out.print("numbers is your code. Enter it: ");
        int code = scan.nextInt(); // Users code

        // Evaluate the user's input for the combination lock puzzle and rounded the score to 2 decimal places
        if (code == 30) {
            System.out.println("Click! The lock opens. [0 pts]");
        } else if (code >= 25 && code <= 35) {
            System.out.printf("So close... the lock rattles but holds. [-10 x %.1f = -%.2f pts]%n", multiplier, (10 * multiplier));
            score = score - (10 * multiplier);
        } else if (code >= 15 && code <= 45) {
            System.out.printf("The lock doesn't budge. [-20 x %.1f = -%.2f pts]%n", multiplier, (20 * multiplier));
            score = score - (20 * multiplier);
        } else {
            System.out.printf("You pull the wrong lever and trigger a trap! [-30 x %.1f = -%.2f pts]%n", multiplier, (30 * multiplier));
            score = score - (30 * multiplier);
        }

        // Puzzle 2: The Colour Panel
        System.out.println("");
        System.out.println("--- Puzzle 2: The Colour Panel ---");
        System.out.println("\"...The one that is neither a primary colour of light nor");
        System.out.print("warm-toned is your key. Enter your choice:\" ");
        String colour = scan.next();

        // Evaluate the user's input for the colour panel puzzle and rounded the score to 2 decimal places
        if (colour.equalsIgnoreCase("GREEN")) { // Ignore case sensitivity
            System.out.printf("The panel hisses and slides open [+15 x %.1f = +%.2f pts]%n", multiplier, (15 * multiplier));
            score = score + (15 * multiplier);
        } else if (colour.equalsIgnoreCase("RED") || colour.equalsIgnoreCase("YELLOW")) { // Ignore case sensitivity
            System.out.printf("The panel doesn't budge. [-15 x %.1f = -%.2f pts]%n", multiplier, (15 * multiplier));
            score = score - (15 * multiplier);
        } else if (colour.equalsIgnoreCase("BLUE")) { // Ignore case sensitivity
            System.out.printf("Too warm - you feel the heat of a wrong choice. [-10 x %.1f = -%.2f pts]%n", multiplier, (10 * multiplier));
            score = score - (10 * multiplier);
        } else {
            System.out.printf("That's not even on the panel. [-20 x %.1f = -%.2f pts]%n", multiplier, (20 * multiplier));
            score = score - (20 * multiplier);
        }

        // Puzzle 3: The Year Vault
        System.out.println("");
        System.out.println("--- Puzzle 3: The Year Vault ---");
        System.out.print("\"I am the year Concordia University was founded. What year?\" ");
        int yearFounded = scan.nextInt();

        // Evaluate the user's input for the year vault puzzle
        if (yearFounded == 1974) {
            System.out.printf("The vault swings open - you're free! [+20 x %.1f = +%.2f pts]%n", multiplier, (20 * multiplier));
            score = score + (20 * multiplier);
        } else if (yearFounded >= 1969 && yearFounded <= 1979) {
            System.out.printf("The vault hums but won't open. [-10 x %.1f = -%.2f pts]%n", multiplier, (10 * multiplier));
            score = score - (10 * multiplier);
        } else if (yearFounded >= 1964 && yearFounded <= 1984) {
            System.out.printf("A wrong combination - alarms flicker. [-20 x %.1f = -%.2f pts]%n", multiplier, (20 * multiplier));
            score = score - (20 * multiplier);
        } else {
            System.out.printf("BOOM! The vault locks permanently. [-35 x %.1f = -%.2f pts]%n", multiplier, (35 * multiplier));
            score = score - (35 * multiplier);
        }

        // Determine the user's outcome based on their final score
        String userOutcome;

        if (score >= 110.00) {
            userOutcome = "MASTER ESCAPIST - You solved everything perfectly!";
        } else if (score >= 80.00 && score < 109.99) {
            userOutcome = "ESCAPED - You made it out, a little roughed up.";
        } else if (score >= 50.00 && score < 79.99)     {
            userOutcome = "BARELY OUT - You stumbled to freedom.";
        } else {
            userOutcome = "TRAPPED - The room has claimed another victim.";
        }

        // Display the final results to the user
        System.out.println("");
        System.out.println("------- Final Result for " + name + " -------");
        System.out.println("Difficulty   : " + difficultyLevel + " (x" + multiplier + ")");
        System.out.printf("Final Score  : %.2f%n", score);
        System.out.println("Outcome      : " + userOutcome);

        // Prompt the user to save their score to the Hall of Fame
        System.out.println("");
        System.out.print("Would you like to save your score to the Hall of Fame? (yes/no): ");

        String saveScore = scan.next();

        // Display a message based on the user's choice to save their score
        if (saveScore.equalsIgnoreCase("yes")) { // Ignore case sensitivity
            System.out.printf("Your score of %.2f has been recorded. Glory awaits!%n", score);
        } else {
            System.out.printf("Maybe next time. Your score was %.2f.%n", score);
        }

        // Closing message
        System.out.println("");
        System.out.print("Thanks for playing the COMP-248 Escape Room. See you next time!");

        // Close the scanner
        scan.close();

    }
}