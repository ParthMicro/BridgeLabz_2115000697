import java.util.Scanner;

public class MostFrequentCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        
        char result = mostFrequentCharacter(str);
        
        System.out.println("Most Frequent Character: '" + result + "'");
        
        sc.close();
    }
    
    public static char mostFrequentCharacter(String str) {
        int maxCount = 0;
        char mostFrequent = str.charAt(0);
        
        for (int i = 0; i < str.length(); i++) {
            int count = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    count++;
                }
            }
            
            if (count > maxCount) {
                maxCount = count;
                mostFrequent = str.charAt(i);
            }
        }
        
        return mostFrequent;
    }
}
