import java.util.Scanner;

public class SumUntil0 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double total = 0.0;
        double input;
        do {
            System.out.print("Enter a number (0 to stop): ");
            input = sc.nextDouble();
            total += input;
        } while (input != 0);
        System.out.println("The total sum is: " + total);
        sc.close();
    }
}
