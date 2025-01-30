import java.util.Scanner;

public class ToggleCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        sc.close();

        char[] charArray = input.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            
            if (ch >= 'A' && ch <= 'Z') { 
                charArray[i] = (char) (ch + 32);
            } else if (ch >= 'a' && ch <= 'z') { 
                charArray[i] = (char) (ch - 32);
            }
        }

        String toggledString = new String(charArray);

        System.out.println("Toggled case string: " + toggledString);
    }
}
