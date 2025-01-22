import java.util.Scanner;
public class TriangleArea{
public static void main(String[]args){
Scanner sc = new Scanner(System.in);
System.out.println("Base of Triangle in cm: ");
float baseInCm = sc.nextFloat();
float baseInInches = baseInCm / (float)2.54;
System.out.println("Height of Triangle in cm: ");
float heightInCm = sc.nextFloat();
float heightInInches = heightInCm / (float)2.54;
float areaInCm=(baseInCm * heightInCm)/(float)2;
float areaInInches=(baseInInches * heightInInches)/(float)2;
System.out.println("The area of triangle with base "+baseInCm+"cm and height "+heightInCm+"cm is "+areaInCm+" sqaure cm and in inches is "+areaInInches+" sqaure inches.");
}
}
