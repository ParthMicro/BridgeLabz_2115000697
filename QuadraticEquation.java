import java.util.Scanner;

public class QuadraticEquation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the coefficient a: ");
        double a = sc.nextDouble();
        System.out.print("Enter the coefficient b: ");
        double b = sc.nextDouble();
        System.out.print("Enter the coefficient c: ");
        double c = sc.nextDouble();

        findRoots(a, b, c);

        sc.close();
    }

    public static void findRoots(double a, double b, double c) {
        double delta = Math.pow(b, 2) - 4 * a * c;

        if (delta > 0) {
            double root1 = (-b + Math.sqrt(delta)) / (2 * a);
            double root2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.printf("The equation has two roots: %.2f and %.2f\n", root1, root2);
        } else if (delta == 0) {
            double root = -b / (2 * a);
            System.out.printf("The equation has one root: %.2f\n", root);
        } else {
            System.out.println("The equation has no real roots.");
        }
    }
}
