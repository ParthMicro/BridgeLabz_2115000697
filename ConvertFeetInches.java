import java.util.Scanner;
public class ConvertFeetInches{
public static void main(String args[]){
Scanner sc = new Scanner(System.in);
System.out.println("Enter your height in centimeters: ");
double heightInCm = sc.nextDouble();
double heightInInches = heightInCm / 2.54;
double heightInFeet = heightInInches / 12;
System.out.print("Your height in cm is " + heightInCm + " while in feet is " + heightInFeet + " and inches is " + heightInInches );
}
}
