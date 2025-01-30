import java.util.Scanner;

public class AnagramCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first string: ");
        String str1 = sc.nextLine();

        System.out.print("Enter the second string: ");
        String str2 = sc.nextLine();
        sc.close();

        if (areAnagrams(str1, str2)) {
            System.out.println("The strings are anagrams of each other.");
        } else {
            System.out.println("The strings are not anagrams of each other.");
        }
    }

    public static boolean areAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int[] count1 = new int[256];
        int[] count2 = new int[256];

        for (int i = 0; i < str1.length(); i++) {
            count1[str1.charAt(i)]++;
            count2[str2.charAt(i)]++;
        }

        for (int i = 0; i < 256; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }
        return true;
    }
}
