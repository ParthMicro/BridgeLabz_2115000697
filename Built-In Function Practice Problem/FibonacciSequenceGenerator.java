import java.util.Scanner;

public class FibonacciSequenceGenerator {

    public static void main(String[] args) {
        int terms = takeInput("Enter the number of terms for the Fibonacci sequence: ");
        generateFibonacci(terms);
    }

    public static int takeInput(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.print(prompt);
        return sc.nextInt();
    }

    public static void generateFibonacci(int terms) {
        int a = 0, b = 1;
        
        System.out.println("Fibonacci sequence up to " + terms + " terms:");
        
        for (int i = 1; i <= terms; i++) {
            System.out.print(a + " ");
            int nextTerm = a + b;
            a = b;
            b = nextTerm;
        }
    }
}
