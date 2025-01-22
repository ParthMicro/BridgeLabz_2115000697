import java.util.Scanner;
public class ConvertDistance{
public static void main(String args[]){
Scanner sc = new Scanner(System.in);
int kiloMeters = sc.nextInt();
double miles = kiloMeters / 1.6;
System.out.print("The total miles is " + miles + " mile for the given " + kiloMeters); 
}
}
