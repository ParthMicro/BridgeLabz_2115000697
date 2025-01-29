import java.util.Scanner;

public class TemperatureConverter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter temperature: ");
        double temp = sc.nextDouble();
        
        System.out.print("Enter scale (C for Celsius, F for Fahrenheit): ");
        char scale = sc.next().toUpperCase().charAt(0);
        
        if (scale == 'C') {
            System.out.println(temp + " Celsius = " + (temp * 9/5 + 32) + " Fahrenheit");
        } else if (scale == 'F') {
            System.out.println(temp + " Fahrenheit = " + ((temp - 32) * 5/9) + " Celsius");
        } else {
            System.out.println("Invalid scale. Please use 'C' or 'F'.");
        }
    }
}
