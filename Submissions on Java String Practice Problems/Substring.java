import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the main string: ");
        String mainString = sc.nextLine();
        
        System.out.print("Enter the substring: ");
        String subString = sc.nextLine();
        
        sc.close();
        
        int count = 0;
        int index = mainString.indexOf(subString);
        
        while (index != -1) {
            count++;
            index = mainString.indexOf(subString, index + subString.length());
        }
        
        System.out.println("Occurrences of \"" + subString + "\" in the given string: " + count);
    }
}
