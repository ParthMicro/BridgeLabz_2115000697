import java.util.Scanner;

public class CheckNumber2 {

    public static boolean isPositive(int number) {
        return number >= 0;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static int compare(int number1, int number2) {
        if (number1 > number2) {
            return 1;
        } else if (number1 == number2) {
            return 0;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];

        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
        }

        System.out.println("\nNumber Analysis:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + numbers[i] + " is ");
            if (isPositive(numbers[i])) {
                System.out.print("positive");
                if (isEven(numbers[i])) {
                    System.out.println(" and even.");
                } else {
                    System.out.println(" and odd.");
                }
            } else {
                System.out.println("negative.");
            }
        }

        int comparisonResult = compare(numbers[0], numbers[numbers.length - 1]);
        System.out.print("\nComparison of the first and last elements: ");
        if (comparisonResult == 1) {
            System.out.println("The first element is greater than the last element.");
        } else if (comparisonResult == 0) {
            System.out.println("The first and last elements are equal.");
        } else {
            System.out.println("The first element is less than the last element.");
        }

        sc.close();
    }
}
