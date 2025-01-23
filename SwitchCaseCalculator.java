import java.util.Scanner;

public class SwitchCaseCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double first, second;
        String op;

        System.out.print("Enter first number: ");
        first = sc.nextDouble();

        System.out.print("Enter operator (+, -, *, /): ");
        op = sc.next();

        System.out.print("Enter second number: ");
        second = sc.nextDouble();

        double result;

        switch (op) {
            case "+":
                result = first + second;
                System.out.println("Result: " + result);
                break;
            case "-":
                result = first - second;
                System.out.println("Result: " + result);
                break;
            case "*":
                result = first * second;
                System.out.println("Result: " + result);
                break;
            case "/":
                result = first / second;
                System.out.println("Result: " + result);
            default:
                System.out.println("Invalid Operator");
        }
        sc.close();
    }
}
