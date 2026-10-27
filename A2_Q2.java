// -----------------------------------------------------------------------------------------------------------------------------------
// Assignment 2: Algorithm 2: ARTM Transit Fare Calculator
// Written by: Muhammad Hashim Ali (40265443)
// For COMP 248 Section S 2262 - Fall 2026
// Date: 2026-10-13
//
// The program asks the user for their name, ticket type, zones and quantity.
// It then calculates the total cost, including return trips for single tickets and a 5% discount for monthly passes if applicable.
// Finally, it displays a purchase summary with the total cost and any applicable discounts.
//
// -----------------------------------------------------------------------------------------------------------------------------------

import java.util.Scanner; // Import Scanner

public class A2_Q2 {

    public static void main(String[] args) {

        // Welcome message
        System.out.println("\\ --------------------------------------------------- /");
        System.out.println("/       Welcome to the ARTM Fare Calculator!          /");
        System.out.println("\\ --------------------------------------------------- /");

        int choice; // Choice of ticket
        int fareCount = 0; // Number of tickets or trips
        int returnCount = 0; // Number of return trips if applicable

        double unitPrice = 0.0; // Unit price of the selected ticket type
        double totalPrice = 0.0; // Total price of the selected ticket type
        double discountedAmount = 0.0; // The amount discounted.
        double subTotal = 0.0; // The subtotal before any discounts are applied

        String fareType, name, fareMessage; // Fare Type, User Name, and Fare Message
        String zone = ""; // Which zone(s) the user is traveling in (A, AB, ABC, or ABCD)

        boolean discountedFare = false; // boolean to see if user is eligible for a discount (3 or more months for monthly pass)

        Scanner scan = new Scanner(System.in);

        // Prompt the user for their name
        System.out.println("");
        System.out.print("Please enter your name: ");
        name = scan.nextLine();

        // Display the ticket type options to the user
        System.out.println("");
        System.out.println("Please choose a ticket type:");
        System.out.println("1. Single Trip");
        System.out.println("2. 10-Trip Package");
        System.out.println("3. Monthly Pass");
        System.out.println("4. Reduced Monthly Pass (ages 6-17, students 18+, ages 65+)");
        System.out.println("5. Exit");
        System.out.println("");

        // Prompt the user for their choice of ticket type
        System.out.print("Your choice: ");
        choice = scan.nextInt();

        // Only choices 1–4 require a zone.
        if (choice >= 1 && choice <= 4) {
            System.out.print("Please enter your zone(s): ");
            zone = scan.next();
            zone = zone.toUpperCase();
        }

        switch (choice) {
                // Single Trip
            case 1:
                fareType = "Single Trip";
                fareMessage = "How many trips? ";

                // Determine the unit price based on the zone(s) selected by the user
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

                // Prompt the user for the number of trips and return trips if applicable
                System.out.print(fareMessage);
                fareCount = scan.nextInt();

                // Ask the user if they are making return trips and get the number of return trips if applicable
                System.out.print("Are you making this trip today more than once? (yes/no): ");
                String returnTrip = scan.next();

                // If the user is making return trips, prompt them for the number of return trips
                if (returnTrip.equalsIgnoreCase("yes")) {
                    System.out.print("How many return trips? ");
                    returnCount = scan.nextInt();
                }

                // Calculate the total price based on the unit price and the number of trips and return trips
                totalPrice = unitPrice * (fareCount + returnCount);
                break;
            
                // 10-Trip Package
            case 2:
                fareType = "10-Trip Package";
                fareMessage = "How many packages? ";

                // ONLY ZONE A is valid for the 10-Trip Package, so check if the user selected Zone A and set the unit price accordingly
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

                // Calculate the total price based on the unit price and the number of packages purchased
                totalPrice = unitPrice * fareCount;
                break;

                // Monthly Pass
            case 3:
                fareType = "Monthly Pass";
                fareMessage = "How many months are you purchasing for? ";

                // Determine the unit price based on the zone(s) selected by the user
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

                // Validate the number of months entered by the user and ensure it is between 1 and 12
                if (fareCount < 1 || fareCount > 12) {
                    System.out.println("Invalid number of months. Please enter a value between 1 and 12.");
                    return;
                }
                
                // Calculate the subtotal based on the unit price and the number of months purchased
                subTotal = unitPrice * fareCount;

                // If the user is purchasing 3 or more months, apply a 5% discount to the subtotal and calculate the total price and discounted amount
                if (fareCount >= 3) {
                    discountedFare = true; // Set the discountedFare boolean to true to indicate that a discount has been applied
                    totalPrice = subTotal * 0.95; // Apply a 5% discount
                    discountedAmount = subTotal - totalPrice; // Calculate the amount discounted
                } else {
                    totalPrice = subTotal; // If the user is purchasing less than 3 months, the total price is equal to the subtotal
                }
                break;

                // Reduced Monthly Pass
            case 4:
                fareType = "Reduced Monthly Pass";
                fareMessage = "How many passes? ";

                // Determine the unit price based on the zone(s) selected by the user
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

                // Calculate the total price based on the unit price and the number of reduced monthly passes purchased
                totalPrice = unitPrice * fareCount;
                break;

                // Exit the program
            case 5:
                System.out.println("");
                System.out.println("Thank you for using the ARTM Fare Calculator. Have a great trip!");
                return;

                // Default case for invalid ticket type selection
            default:
                System.out.println("");
                System.out.println("Invalid selection. Please try again.");
                return;
        }

        // Display the purchase summary to the user, including their name, ticket type, zone(s), unit price, quantity, subtotal, any applicable discounts, and total price
        System.out.println("");
        System.out.println("------- Purchase Summary for " + name + " -------");
        System.out.println("Ticket type : " + fareType);
        System.out.println("Zone(s)     : " + zone);
        System.out.printf("Unit price  : $%.2f%n", unitPrice);

        // Display the quantity and subtotal for the Monthly Pass option, or just the quantity for other ticket types
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
        System.out.printf("Total       : $%.2f%n", totalPrice); // Display the total price to the user, rounded to 2 decimal places

        scan.close(); // Closing scanner
    }
}