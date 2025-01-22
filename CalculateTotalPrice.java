import java.util.Scanner;
public class CalculateTotalPrice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the unit price (INR): ");
        double unitPrice = sc.nextDouble();
        System.out.println("Enter the quantity: ");
        int quantity = sc.nextInt();
        double totalPrice = unitPrice * quantity;
        System.out.println("The total purchase price is INR " + totalPrice + " if the quantity is " + quantity + " and unit price is INR " + unitPrice);
        sc.close();
    }
}
