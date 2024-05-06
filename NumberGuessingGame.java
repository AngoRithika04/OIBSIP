
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 100;
    private static final int MAX_ATTEMPTS = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Game loop
        while (true) {
            // Generate a random number
            Random rand = new Random();
            int numberToGuess = rand.nextInt(MAX_RANGE - MIN_RANGE + 1) + MIN_RANGE;

            // Initialize attempts
            int attempts = 0;

            // Round loop
            while (attempts < MAX_ATTEMPTS) {
                // Prompt user to enter a number
                System.out.println("Enter a number between " + MIN_RANGE + " and " + MAX_RANGE + ":");
                int userGuess = scanner.nextInt();

                // Check if the user's guess is correct
                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Your guess is too low. Try again!");
                } else {
                    System.out.println("Your guess is too high. Try again!");
                }

                attempts++; // increment attempts
            }

            // Display score
            if (attempts == MAX_ATTEMPTS) {
                System.out.println("Sorry, you didn't guess the number. The correct answer was " + numberToGuess);
            } else {
                System.out.println("Your score is " + (MAX_ATTEMPTS - attempts) + " out of " + MAX_ATTEMPTS);
            }

            // Ask user if they want to play again
            System.out.println("Do you want to play again? (Y/N)");
            String response = scanner.next();
            if (response.equalsIgnoreCase("n")) {
                break;
            }
        }

        scanner.close(); // close the scanner
        System.out.println("Thank you for playing!");
    }
}