import java.util.Scanner;

public class BMICalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of persons: ");
        int numOfPersons = sc.nextInt();

        double[] weights = new double[numOfPersons];
        double[] heights = new double[numOfPersons];
        double[] bmis = new double[numOfPersons];
        String[] statuses = new String[numOfPersons];

        for (int i = 0; i < numOfPersons; i++) {
            System.out.println("Person " + (i + 1) + ":");
            System.out.print("Enter weight (in kg): ");
            weights[i] = sc.nextDouble();
            System.out.print("Enter height (in cm): ");
            heights[i] = sc.nextDouble();

            double heightM = heights[i] / 100;
            bmis[i] = weights[i] / Math.pow(heightM, 2);

            if (bmis[i] < 18.5) {
                statuses[i] = "Underweight";
            } else if (bmis[i] < 24.9) {
                statuses[i] = "Normal weight";
            } else if (bmis[i] < 29.9) {
                statuses[i] = "Overweight";
            } else {
                statuses[i] = "Obese";
            }
        }
        System.out.println("\nBMI Details:");
        for (int i = 0; i < numOfPersons; i++) {
            System.out.println("Person " + (i + 1) + ":");
            System.out.println("  Weight: " + weights[i] + " kg");
            System.out.println("  Height: " + heights[i] + " cm");
            System.out.printf("  BMI: %.2f\n", bmis[i]);
            System.out.println("  Status: " + statuses[i]);
        }

        sc.close();
    }
}
