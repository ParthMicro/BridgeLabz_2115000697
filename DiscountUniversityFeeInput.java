import java.util.Scanner;
public class DiscountUniversityFeeInput{
public static void main(String args[]){
Scanner sc = new Scanner(System.in);
System.out.println("Enter fee: ");
int fee = sc.nextInt();
System.out.println("Enter the discount percent offered: ");
int discountPercent = sc.nextInt();
int discount = (fee * discountPercent) / 100;
int discountedFee = fee - discount;
System.out.print("The discount amount is INR " + discount + " and final discounted fee is INR " + discountedFee);
}
}
