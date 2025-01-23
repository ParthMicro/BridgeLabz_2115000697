import java.util.Scanner;

public class SumOfNaturalNum2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();
        if (n > 0) {
            int sumFormula = n * (n + 1) / 2;
            int sumLoop = 0;
            for (int i = 1; i <= n; i++) {
                sumLoop += i;
            }
            System.out.println("Sum using formula: " + sumFormula);
            System.out.println("Sum using loop: " + sumLoop);
            System.out.println("Both computations are " + (sumFormula == sumLoop ? "correct." : "incorrect."));
        } else {
            System.out.println("The number is not a natural number.");
        }
        sc.close();
    }
}
