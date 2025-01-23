import java.util.Scanner;

public class HarshadNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
	System.out.println("Enter a number: ");
        int number = sc.nextInt();
        int sum = 0;
        int originalNumber = number;

        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }

        if (originalNumber % sum == 0) {
            System.out.println(originalNumber + " is a Harshad number.");
        } else {
            System.out.println(originalNumber + " is not a Harshad number.");
        }
        sc.close();
    }
}
