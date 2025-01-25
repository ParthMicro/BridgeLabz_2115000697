import java.util.Scanner;

public class BMICalculator2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of persons: ");
        int numOfPersons = sc.nextInt();

        double[][] personData = new double[numOfPersons][3];
        String[] weightStatus = new String[numOfPersons];

        for (int i = 0; i < numOfPersons; i++) {
            System.out.println("Person " + (i + 1) + ":");
            while (true) {
                System.out.print("Enter weight (in kg): ");
                personData[i][0] = sc.nextDouble();
                if (personData[i][0] > 0) break;
                System.out.println("Please enter a positive value for weight.");
            }
            while (true) {
                System.out.print("Enter height (in cm): ");
                personData[i][1] = sc.nextDouble();
                if (personData[i][1] > 0) break;
                System.out.println("Please enter a positive value for height.");
            }

            double heightM = personData[i][1] / 100;
            personData[i][2] = personData[i][0] / Math.pow(heightM, 2);

            if (personData[i][2] < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] < 24.9) {
                weightStatus[i] = "Normal weight";
            } else if (personData[i][2] < 29.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        System.out.println("\nBMI Details:");
        for (int i = 0; i < numOfPersons; i++) {
            System.out.println("Person " + (i + 1) + ":");
            System.out.println("  Weight: " + personData[i][0] + " kg");
            System.out.println("  Height: " + personData[i][1] + " cm");
            System.out.printf("  BMI: %.2f\n", personData[i][2]);
            System.out.println("  Status: " + weightStatus[i]);
        }

        sc.close();
    }
}
