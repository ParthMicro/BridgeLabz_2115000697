import java.util.Scanner;

public class RemoveCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        
        System.out.print("Enter the character to remove: ");
        char charToRemove = sc.next().charAt(0);
        
        String result = removeCharacter(str, charToRemove);
        
        System.out.println("Modified String: " + result);
        
        sc.close();
    }
    
    public static String removeCharacter(String str, char charToRemove) {
        return str.replaceAll(String.valueOf(charToRemove), "");
    }
}
