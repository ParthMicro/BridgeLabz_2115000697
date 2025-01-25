import java.util.Scanner;

public class EmployeeBonus {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numEmployees = 10;
        double[] salary = new double[numEmployees];
        double[] yearsOfService = new double[numEmployees];
        double[] newSalary = new double[numEmployees];
        double[] bonus = new double[numEmployees];

        double totalBonus = 0.0;
        double totalOldSalary = 0.0;
        double totalNewSalary = 0.0;

        for (int i = 0; i < numEmployees; i++) {
            while (true) {
                System.out.print("Enter salary for employee " + (i + 1) + ": ");
                salary[i] = sc.nextDouble();

                System.out.print("Enter years of service for employee " + (i + 1) + ": ");
                yearsOfService[i] = sc.nextDouble();

                if (salary[i] <= 0 || yearsOfService[i] < 0) {
                    System.out.println("Invalid input. Please enter valid salary and years of service.");
                    i--;
                    break;
                }

                if (yearsOfService[i] > 5) {
                    bonus[i] = salary[i] * 0.05;
                } else {
                    bonus[i] = salary[i] * 0.02;
                }

                newSalary[i] = salary[i] + bonus[i];

                totalBonus += bonus[i];
                totalOldSalary += salary[i];
                totalNewSalary += newSalary[i];

                break;
            }
        }

        System.out.println("\nEmployee Bonus Details:");
        for (int i = 0; i < numEmployees; i++) {
            System.out.println("Employee " + (i + 1) + " - Salary: " + salary[i] + ", Years of Service: " + yearsOfService[i]
                    + ", Bonus: " + bonus[i] + ", New Salary: " + newSalary[i]);
        }

        System.out.println("\nTotal Bonus Payout: " + totalBonus);
        System.out.println("Total Old Salary: " + totalOldSalary);
        System.out.println("Total New Salary: " + totalNewSalary);
        sc.close();
    }
}
