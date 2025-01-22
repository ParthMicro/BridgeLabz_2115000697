import java.util.Scanner;
public class BasicCalculator{
public static void main(String args[]){
Scanner sc = new Scanner(System.in);
System.out.println("Enter first number: ");
int num1 = sc.nextInt();
System.out.println("Enter second number: ");
int num2 = sc.nextInt();
int addition = num1 + num2;
int subtraction = num1 - num2;
int multiplication = num1 * num2;
int division = num1 / num2;
System.out.print("The addition, subtraction, multiplication and division value of 2 numbers " +num1+ " and " +num2+ " is " +addition+", " +subtraction + ", " + multiplication + ", and " + division);
}
}
