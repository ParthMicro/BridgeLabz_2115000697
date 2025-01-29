import java.util.Scanner;

public class VowelsAndConsonants {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input = sc.nextLine().toLowerCase();
        sc.close();

        int vowels = 0, consonants = 0;
        for (char ch : input.toCharArray()) {
            if ("aeiou".contains(ch + "")) vowels++;
            else if (Character.isLetter(ch)) consonants++;
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
}
