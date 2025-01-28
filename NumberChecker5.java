import java.util.Scanner;

public class NumberChecker5 {

    public static int[] findFactors(int number) {
        int[] factors = new int[number / 2]; 
        int count = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                factors[count] = i;
                count++;
            }
        }
        int[] result = new int[count];
        System.arraycopy(factors, 0, result, 0, count);  
        return result;
    }

    public static int findGreatestFactor(int[] factors) {
        int greatestFactor = Integer.MIN_VALUE;
        for (int factor : factors) {
            if (factor > greatestFactor) {
                greatestFactor = factor;
            }
        }
        return greatestFactor;
    }

    public static int sumFactors(int[] factors) {
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }

    public static int productFactors(int[] factors) {
        int product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }

    public static double productOfCubeOfFactors(int[] factors) {
        double product = 1;
        for (int factor : factors) {
            product *= Math.pow(factor, 3);
        }
        return product;
    }

    public static boolean isPerfectNumber(int number) {
        int[] factors = findFactors(number);
        int sum = sumFactors(factors);
        return sum == number;
    }

    public static boolean isAbundantNumber(int number) {
        int[] factors = findFactors(number);
        int sum = sumFactors(factors);
        return sum > number;
    }

    public static boolean isDeficientNumber(int number) {
        int[] factors = findFactors(number);
        int sum = sumFactors(factors);
        return sum < number;
    }

    public static boolean isStrongNumber(int number) {
        int originalNumber = number;
        int sumOfFactorial = 0;

        while (number > 0) {
            int digit = number % 10;
            sumOfFactorial += factorial(digit);
            number /= 10;
        }
        return sumOfFactorial == originalNumber;
    }

    public static int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int[] factors = findFactors(number);

        System.out.println("Factors of " + number + ":");
        for (int factor : factors) {
            System.out.print(factor + " ");
        }
        System.out.println();

        System.out.println("Greatest factor: " + findGreatestFactor(factors));
        System.out.println("Sum of factors: " + sumFactors(factors));
        System.out.println("Product of factors: " + productFactors(factors));
        System.out.println("Product of cube of factors: " + productOfCubeOfFactors(factors));

        if (isPerfectNumber(number)) {
            System.out.println(number + " is a Perfect number.");
        } else {
            System.out.println(number + " is not a Perfect number.");
        }

        if (isAbundantNumber(number)) {
            System.out.println(number + " is an Abundant number.");
        } else {
            System.out.println(number + " is not an Abundant number.");
        }

        if (isDeficientNumber(number)) {
            System.out.println(number + " is a Deficient number.");
        } else {
            System.out.println(number + " is not a Deficient number.");
        }

        if (isStrongNumber(number)) {
            System.out.println(number + " is a Strong number.");
        } else {
            System.out.println(number + " is not a Strong number.");
        }

        sc.close();
    }
}
