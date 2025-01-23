import java.util.Scanner;

public class FactorialUsingFor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n >= 0) {
            int factorial = 1;
            for (int i = 1; i <= n; i++) {
                factorial = factorial * i;
            }
            System.out.println("Factorial of " + n + " is " + factorial);
        } else {
            System.out.println("The number is not a positive integer.");
        }
        sc.close();
    }
}
