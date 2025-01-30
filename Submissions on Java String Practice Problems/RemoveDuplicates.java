import java.util.Scanner;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        sc.close();

        char[] result = new char[input.length()]; 
        int index = 0;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            boolean isDuplicate = false;

            for (int j = 0; j < index; j++) {
                if (result[j] == ch) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                result[index++] = ch;
            }
        }

        System.out.print("String after removing duplicates: ");
        for (int i = 0; i < index; i++) {
            System.out.print(result[i]);
        }
        System.out.println();
    }
}
