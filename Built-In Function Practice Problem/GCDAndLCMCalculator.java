import java.util.Scanner;

public class GCDAndLCMCalculator {

    public static void main(String[] args) {
        int num1 = takeInput("Enter the first number: ");
        int num2 = takeInput("Enter the second number: ");
        
        int gcd = calculateGCD(num1, num2);
        int lcm = calculateLCM(num1, num2, gcd);
        
        displayResult("The GCD of " + num1 + " and " + num2 + " is: " + gcd);
        displayResult("The LCM of " + num1 + " and " + num2 + " is: " + lcm);
    }

    public static int takeInput(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.print(prompt);
        return sc.nextInt();
    }

    public static int calculateGCD(int num1, int num2) {
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }

    public static int calculateLCM(int num1, int num2, int gcd) {
        return (num1 * num2) / gcd;
    }

    public static void displayResult(String message) {
        System.out.println(message);
    }
}
