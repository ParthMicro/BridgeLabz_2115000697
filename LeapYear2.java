import java.util.Scanner;
public class LeapYear2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter year : ");
        int year = sc.nextInt();
        if((year >= 1582) && ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) ){
            System.out.println("Given year is a Leap Year");
        }
        else{
            System.out.println("Given year is not a Leap Year");
}
}
}
