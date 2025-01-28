import java.util.Scanner;

public class TrigonometricFunctions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter an angle in degrees: ");
        double angle = sc.nextDouble();

        calculateTrigonometricFunctions(angle);

        sc.close();
    }

    public static void calculateTrigonometricFunctions(double angle) {
        double radians = Math.toRadians(angle);

        double sine = Math.sin(radians);
        double cosine = Math.cos(radians);
        double tangent = Math.tan(radians);

        System.out.println("Sine of " + angle + "°: " + sine);
        System.out.println("Cosine of " + angle + "°: " + cosine);
        System.out.println("Tangent of " + angle + "°: " + tangent);
    }
}
