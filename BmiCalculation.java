import java.util.Scanner; 
 
public class BmiCalculation { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter your weight (in kg): "); 
        double weight = sc.nextDouble(); 
        System.out.print("Enter your height (in cm): "); 
        double heightCm = sc.nextDouble(); 
        double heightM = heightCm / 100; 
        double bmi = weight / Math.pow(heightM, 2); 
        String status; 
        if (bmi < 18.5) { 
            status = "Underweight"; 
        } else if (bmi < 24.9) { 
            status = "Normal weight"; 
        } else if (bmi < 29.9) { 
            status = "Overweight"; 
        } else { 
            status = "Obese"; 
        } 
        System.out.printf("Your BMI is: %.2f\n", bmi); 
        System.out.println("Your weight status is: " + status); 
    } 
} 
