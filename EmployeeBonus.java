import java.util.Random;

public class EmployeeBonus {

    public static double[][] getEmployeeData(int numEmployees) {
        Random rand = new Random();
        double[][] employeeData = new double[numEmployees][2];

        for (int i = 0; i < numEmployees; i++) {
            employeeData[i][0] = 10000 + (rand.nextInt(90000));
            employeeData[i][1] = 1 + rand.nextInt(20);
        }
        return employeeData;
    }

    public static double[][] calculateNewSalaryAndBonus(double[][] employeeData) {
        double[][] updatedData = new double[employeeData.length][3];

        for (int i = 0; i < employeeData.length; i++) {
            double oldSalary = employeeData[i][0];
            double yearsOfService = employeeData[i][1];
            double bonus = 0;

            if (yearsOfService > 5) {
                bonus = oldSalary * 0.05;
            } else {
                bonus = oldSalary * 0.02;
            }

            double newSalary = oldSalary + bonus;

            updatedData[i][0] = oldSalary;
            updatedData[i][1] = bonus;
            updatedData[i][2] = newSalary;
        }
        return updatedData;
    }

    public static void displayEmployeeData(double[][] updatedData) {
        double totalOldSalary = 0, totalNewSalary = 0, totalBonus = 0;

        for (int i = 0; i < updatedData.length; i++) {
            totalOldSalary += updatedData[i][0];
            totalBonus += updatedData[i][1];
            totalNewSalary += updatedData[i][2];

            System.out.println("Employee " + (i + 1) + ":");
            System.out.println("  Old Salary: " + updatedData[i][0]);
            System.out.println("  Bonus: " + updatedData[i][1]);
            System.out.println("  New Salary: " + updatedData[i][2]);
            System.out.println();
        }

        System.out.println("Total Old Salary: " + totalOldSalary);
        System.out.println("Total Bonus: " + totalBonus);
        System.out.println("Total New Salary: " + totalNewSalary);
    }

    public static void main(String[] args) {
        int numEmployees = 10;

        double[][] employeeData = getEmployeeData(numEmployees);

        double[][] updatedData = calculateNewSalaryAndBonus(employeeData);

        displayEmployeeData(updatedData);
    }
}
