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
        int mainLength = mainString.length();
        int subLength = subString.length();

        for (int i = 0; i <= mainLength - subLength; i++) {
            boolean match = true;

            for (int j = 0; j < subLength; j++) {
                if (mainString.charAt(i + j) != subString.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                count++;
                i += subLength - 1; 
            }
        }
        System.out.println("Occurrences of \"" + subString + "\" in the given string: " + count);
    }
}
