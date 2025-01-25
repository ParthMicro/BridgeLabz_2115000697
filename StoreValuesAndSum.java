import java.util.Scanner;

public class StoreValuesAndSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;

        while (true) {
            System.out.print("Enter a number (0 or negative number to stop): ");
            double input = sc.nextDouble();

            if (input <= 0 || index == 10) {
                break;
            }

            numbers[index] = input;
            index++;
        }

        for (int i = 0; i < index; i++) {
            total += numbers[i];
        }

        System.out.println("Entered numbers:");
        for (int i = 0; i < index; i++) {
            System.out.print(numbers[i] + " ");
        }

        System.out.println("\nSum of numbers: " + total);
        sc.close();
    }
}
