import java.util.Scanner;

public class AthleteRounds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first side (in meters): ");
        double side1 = sc.nextDouble();

        System.out.print("Enter the second side (in meters): ");
        double side2 = sc.nextDouble();

        System.out.print("Enter the third side (in meters): ");
        double side3 = sc.nextDouble();

        double perimeter = side1 + side2 + side3;
        int rounds = calculateRounds(perimeter, 5000);

        System.out.println("The athlete needs to complete " + rounds + " rounds to cover 5 km.");

        sc.close();
    }

    public static int calculateRounds(double perimeter, double distance) {
        return (int) Math.ceil(distance / perimeter);
    }
}
