import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Think of a number between 1 and 100, and I will try to guess it.");
        
        int low = 1;
        int high = 100;
        
        boolean guessedCorrectly = false;
        
        while (!guessedCorrectly) {
            int guess = generateGuess(low, high);
            
            System.out.println("Is the number " + guess + "? (Enter 'high', 'low', or 'correct')");
            String feedback = sc.nextLine().toLowerCase();
            
            if (feedback.equals("high")) {
                high = guess - 1;
            } else if (feedback.equals("low")) {
                low = guess + 1;
            } else if (feedback.equals("correct")) {
                guessedCorrectly = true;
                System.out.println("Yay! I guessed your number: " + guess);
            } else {
                System.out.println("Invalid input. Please enter 'high', 'low', or 'correct'.");
            }
        }
        
        sc.close();
    }

    public static int generateGuess(int low, int high) {
        Random random = new Random();
        return random.nextInt(high - low + 1) + low;
    }
}
