import java.util.Scanner;

public class UnitConverter2 {

    public static double convertYardsToFeet(double yards) {
        double yards2feet = 3;
        return yards * yards2feet;
    }

    public static double convertFeetToYards(double feet) {
        double feet2yards = 0.333333;
        return feet * feet2yards;
    }

    public static double convertMetersToInches(double meters) {
        double meters2inches = 39.3701;
        return meters * meters2inches;
    }

    public static double convertInchesToMeters(double inches) {
        double inches2meters = 0.0254;
        return inches * inches2meters;
    }

    public static double convertInchesToCentimeters(double inches) {
        double inches2cm = 2.54;
        return inches * inches2cm;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter distance in yards: ");
        double yards = sc.nextDouble();
        System.out.println("Distance in feet: " + convertYardsToFeet(yards));

        System.out.print("Enter distance in feet: ");
        double feet = sc.nextDouble();
        System.out.println("Distance in yards: " + convertFeetToYards(feet));

        System.out.print("Enter length in meters: ");
        double meters = sc.nextDouble();
        System.out.println("Length in inches: " + convertMetersToInches(meters));

        System.out.print("Enter length in inches: ");
        double inches = sc.nextDouble();
        System.out.println("Length in meters: " + convertInchesToMeters(inches));

        System.out.print("Enter length in inches: ");
        inches = sc.nextDouble();
        System.out.println("Length in centimeters: " + convertInchesToCentimeters(inches));

        sc.close();
    }
}
