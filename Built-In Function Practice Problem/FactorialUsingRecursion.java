import java.util.Scanner;

public class FactorialUsingRecursion {

    public static void main(String[] args) {
        int num = takeInput("Enter a number to calculate its factorial: ");
        int result = calculateFactorial(num);
        displayResult("The factorial of " + num + " is: " + result);
    }

    public static int takeInput(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.print(prompt);
        return sc.nextInt();
    }

    public static int calculateFactorial(int num) {
        if (num == 0 || num == 1) {
            return 1;
        }
        return num * calculateFactorial(num - 1);
    }

    public static void displayResult(String message) {
        System.out.println(message);
    }
}
