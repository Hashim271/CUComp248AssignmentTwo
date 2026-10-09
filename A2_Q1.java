// -----------------------------------------------------------------------------------------------------------------------------------
// Assignment 2: Algorithm 1: Calories Burned Calculator
// Written by: Muhammad Hashim Ali (40265443)
// For COMP 248 Section S 2262 - Fall 2026
// Date: 2026-10-10
//
//
//
// -----------------------------------------------------------------------------------------------------------------------------------

import java.util.Scanner; // Import Scanner

public class A2_Q1 {

    public static void main(String[] args) {

        // Welcome message
        System.out.println("\\---------------------------------------------/");
        System.out.println("/     Welcome to the COMP-248 Escape Room!    /");
        System.out.println("\\---------------------------------------------/");

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

        // Determine the score multiplier based on the user's choice
        if (choice == 1) {
            multiplier = 1.0;
        } else if (choice == 2) {
            multiplier = 1.5;
        } else {
            multiplier = 2.0;
        }

        // Prompt the user for their adventurer name
        System.out.print("Enter your adventurer name: ");
        String name = scan.next();

        System.out.println("");
        System.out.println("--- Puzzle 1: The Combinantion Lock ---");
        System.out.println("\"A rusty lock hangs on the door. The sum of the first 5 even");
        System.out.print("numbers is your code. Enter it:\" ");
        int code = scan.nextInt();

        if (code == 30) {
            System.out.println("Click! The lock opens. [0 pts]");
        } else if (code >= 25 && code <= 35) {
            System.out.println("So close... the lock rattles but holds. [-10 x" + multiplier + " = -" + (10 * multiplier) + " pts]");
            score = score - (10 * multiplier);
        } else if (code < 25 || code > 35) {
            System.out.println("The lock doesn't budge.");
        }

    }
}