import java.util.Scanner;

public class SumOfNaturalNumbersCompare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a natural number greater than zero.");
            sc.close();
            return;
        }

        int sumRecursive = calculateSumRecursive(n);
        int sumFormula = calculateSumUsingFormula(n);

        System.out.println("Sum using recursion: " + sumRecursive);
        System.out.println("Sum using formula: " + sumFormula);

        if (sumRecursive == sumFormula) {
            System.out.println("The results from both methods are correct");
        } else {
            System.out.println("The results do not match. Please check the implementation.");
        }

        sc.close();
    }

    public static int calculateSumRecursive(int n) {
        if (n == 1) {
            return 1;
        }
        return n + calculateSumRecursive(n - 1);
    }

    public static int calculateSumUsingFormula(int n) {
        return n * (n + 1) / 2;
    }
}
