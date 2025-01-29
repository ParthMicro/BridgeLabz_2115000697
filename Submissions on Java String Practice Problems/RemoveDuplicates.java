import java.util.Scanner;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        sc.close();
        
        StringBuilder result = new StringBuilder();
        boolean[] seen = new boolean[256];
        
        for (char ch : input.toCharArray()) {
            if (!seen[ch]) {
                seen[ch] = true;
                result.append(ch);
            }
        }
        
        System.out.println("String after removing duplicates: " + result.toString());
    }
}
