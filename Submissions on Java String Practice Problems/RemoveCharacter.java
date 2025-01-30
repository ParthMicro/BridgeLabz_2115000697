import java.util.Scanner;

public class RemoveCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        System.out.print("Enter the character to remove: ");
        char charToRemove = sc.next().charAt(0);
        sc.close();

        char[] resultArray = new char[str.length()];
        int index = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != charToRemove) {
                resultArray[index++] = str.charAt(i);
            }
        }
        System.out.print("Modified String: ");
        for (int i = 0; i < index; i++) {
            System.out.print(resultArray[i]);
        }
        System.out.println();
    }
}
