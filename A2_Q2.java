// -----------------------------------------------------------------------------------------------------------------------------------
// Assignment 2: Algorithm 2: ARTM Transit Fare Calculator
// Written by: Muhammad Hashim Ali (40265443)
// For COMP 248 Section S 2262 - Fall 2026
// Date: 2026-10-13
// -----------------------------------------------------------------------------------------------------------------------------------

import java.util.Scanner;

public class A2_Q2 {

    public static void main(String[] args) {

        System.out.println("\\ --------------------------------------------------- /");
        System.out.println("/       Welcome to the ARTM Fare Calculator!          /");
        System.out.println("\\ --------------------------------------------------- /");

        int choice;
        int fareCount = 0;
        int returnCount = 0;

        double unitPrice = 0.0;
        double totalPrice = 0.0;
        double discountedAmount = 0.0;
        double subTotal = 0.0;

        String fareType, name, fareMessage;
        String zone = "";

        boolean discountedFare = false;

        Scanner scan = new Scanner(System.in);

        System.out.println("");
        System.out.print("Please enter your name: ");
        name = scan.nextLine();

        System.out.println("");
        System.out.println("Please choose a ticket type:");
        System.out.println("1. Single Trip");
        System.out.println("2. 10-Trip Package");
        System.out.println("3. Monthly Pass");
        System.out.println("4. Reduced Monthly Pass (ages 6-17, students 18+, ages 65+)");
        System.out.println("5. Exit");
        System.out.println("");

        System.out.print("Your choice: ");
        choice = scan.nextInt();

        // Only choices 1–4 require a zone.
        if (choice >= 1 && choice <= 4) {
            System.out.print("Please enter your zone(s): ");
            zone = scan.next();
            zone = zone.toUpperCase();
        }

        switch (choice) {

            case 1:
                fareType = "Single Trip";
                fareMessage = "How many trips? ";

                if (zone.equals("A")) {
                    unitPrice = 3.75;
                } else if (zone.equals("AB")) {
                    unitPrice = 5.00;
                } else if (zone.equals("ABC")) {
                    unitPrice = 7.00;
                } else if (zone.equals("ABCD")) {
                    unitPrice = 9.50;
                } else {
                    System.out.println("Invalid zone selection. Please try again.");
                    return;
                }

                System.out.print(fareMessage);
                fareCount = scan.nextInt();

                System.out.print("Are you making this trip today more than once? (yes/no): ");
                String returnTrip = scan.next();

                if (returnTrip.equalsIgnoreCase("yes")) {
                    System.out.print("How many return trips? ");
                    returnCount = scan.nextInt();
                }

                totalPrice = unitPrice * (fareCount + returnCount);
                break;

            case 2:
                fareType = "10-Trip Package";
                fareMessage = "How many packages? ";

                if (zone.equals("A")) {
                    unitPrice = 34.25;
                } else {
                    System.out.println("");
                    System.out.println("The 10-Trip Package is only available for Zone A.");
                    System.out.println("");
                    System.out.println("Thank you for using the ARTM Fare Calculator. Have a great trip!");
                    return;
                }

                System.out.print(fareMessage);
                fareCount = scan.nextInt();

                totalPrice = unitPrice * fareCount;
                break;

            case 3:
                fareType = "Monthly Pass";
                fareMessage = "How many months are you purchasing for? ";

                if (zone.equals("A")) {
                    unitPrice = 104.50;
                } else if (zone.equals("AB")) {
                    unitPrice = 164.50;
                } else if (zone.equals("ABC")) {
                    unitPrice = 200.50;
                } else if (zone.equals("ABCD")) {
                    unitPrice = 275.50;
                } else {
                    System.out.println("Invalid zone selection. Please try again.");
                    return;
                }

                System.out.print(fareMessage);
                fareCount = scan.nextInt();

                if (fareCount < 1 || fareCount > 12) {
                    System.out.println("Invalid number of months. Please enter a value between 1 and 12.");
                    return;
                }

                subTotal = unitPrice * fareCount;

                if (fareCount >= 3) {
                    discountedFare = true;
                    totalPrice = subTotal * 0.95;
                    discountedAmount = subTotal - totalPrice;
                } else {
                    totalPrice = subTotal;
                }
                break;

            case 4:
                fareType = "Reduced Monthly Pass";
                fareMessage = "How many passes? ";

                if (zone.equals("A")) {
                    unitPrice = 62.75;
                } else if (zone.equals("AB")) {
                    unitPrice = 98.75;
                } else if (zone.equals("ABC")) {
                    unitPrice = 120.25;
                } else if (zone.equals("ABCD")) {
                    unitPrice = 165.25;
                } else {
                    System.out.println("Invalid zone selection. Please try again.");
                    return;
                }

                System.out.print(fareMessage);
                fareCount = scan.nextInt();

                totalPrice = unitPrice * fareCount;
                break;

            case 5:
                System.out.println("");
                System.out.println("Thank you for using the ARTM Fare Calculator. Have a great trip!");
                return;

            default:
                System.out.println("");
                System.out.println("Invalid selection. Please try again.");
                return;
        }

        System.out.println("");
        System.out.println("------- Purchase Summary for " + name + " -------");
        System.out.println("Ticket type : " + fareType);
        System.out.println("Zone(s)     : " + zone);
        System.out.printf("Unit price  : $%.2f%n", unitPrice);

        if (choice == 3) {
            System.out.println("Quantity    : " + fareCount + " month(s)");
            System.out.printf("Subtotal    : $%.2f%n", subTotal);
        } else {
            System.out.println("Quantity    : " + (fareCount + returnCount));
        }

        if (discountedFare) {
            System.out.printf("Loyalty discount (5%%): -$%.2f%n", discountedAmount);
        }

        System.out.println("-------------------------");
        System.out.printf("Total       : $%.2f%n", totalPrice);

        scan.close();
    }
}