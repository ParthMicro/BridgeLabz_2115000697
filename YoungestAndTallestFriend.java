import java.util.Scanner;

public class YoungestAndTallestFriend {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] friends = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age for " + friends[i] + ": ");
            ages[i] = sc.nextInt();
            System.out.print("Enter height for " + friends[i] + ": ");
            heights[i] = sc.nextDouble();
        }

        int youngestAge = ages[0];
        String youngestFriend = friends[0];
        double tallestHeight = heights[0];
        String tallestFriend = friends[0];

        for (int i = 1; i < 3; i++) {
            if (ages[i] < youngestAge) {
                youngestAge = ages[i];
                youngestFriend = friends[i];
            }
            if (heights[i] > tallestHeight) {
                tallestHeight = heights[i];
                tallestFriend = friends[i];
            }
        }

        System.out.println("The youngest friend is " + youngestFriend + " with age " + youngestAge);
        System.out.println("The tallest friend is " + tallestFriend + " with height " + tallestHeight);
	sc.close();
    }
}
