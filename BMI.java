import java.util.Scanner;

public class BMI {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfPersons = 10;

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
        }

        calculateBMI(weights, heights, bmis);
        determineBMIStatus(bmis, statuses);

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

    public static void calculateBMI(double[] weights, double[] heights, double[] bmis) {
        for (int i = 0; i < weights.length; i++) {
            double heightM = heights[i] / 100;
            bmis[i] = weights[i] / Math.pow(heightM, 2);
        }
    }

    public static void determineBMIStatus(double[] bmis, String[] statuses) {
        for (int i = 0; i < bmis.length; i++) {
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
    }
}
