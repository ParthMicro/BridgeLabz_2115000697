import java.util.Scanner;

public class ChocolatesDivision {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the total number of chocolates: ");
        int numberOfChocolates = sc.nextInt();

        System.out.print("Enter the number of children: ");
        int numberOfChildren = sc.nextInt();

        findChocolatesAndRemainder(numberOfChocolates, numberOfChildren);

        sc.close();
    }

    public static void findChocolatesAndRemainder(int numberOfChocolates, int numberOfChildren) {
        int chocolatesPerChild = numberOfChocolates / numberOfChildren;
        int remainingChocolates = numberOfChocolates % numberOfChildren;

        System.out.println("Each child will get " + chocolatesPerChild + " chocolates.");
        System.out.println("The remaining chocolates are: " + remainingChocolates);
    }
}
