import java.util.Scanner;

public class BonusOfEmployees {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the employee's salary: ");
        double salary = sc.nextDouble();
        System.out.print("Enter the years of service: ");
        int yearsOfService = sc.nextInt();
        if (yearsOfService > 5) {
            double bonus = 0.05 * salary;
            System.out.println("Bonus amount: " + bonus);
        } else {
            System.out.println("No bonus for less than 6 years of service.");
        }
        sc.close();
    }
}
