import java.util.Scanner;

public class UnitConverter3 {

    public static double convertFarhenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double convertPoundsToKilograms(double pounds) {
        double pounds2kilograms = 0.453592;
        return pounds * pounds2kilograms;
    }

    public static double convertKilogramsToPounds(double kilograms) {
        double kilograms2pounds = 2.20462;
        return kilograms * kilograms2pounds;
    }

    public static double convertGallonsToLiters(double gallons) {
        double gallons2liters = 3.78541;
        return gallons * gallons2liters;
    }

    public static double convertLitersToGallons(double liters) {
        double liters2gallons = 0.264172;
        return liters * liters2gallons;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter temperature in Fahrenheit: ");
        double fahrenheit = sc.nextDouble();
        System.out.println("Temperature in Celsius: " + convertFarhenheitToCelsius(fahrenheit));

        System.out.print("Enter temperature in Celsius: ");
        double celsius = sc.nextDouble();
        System.out.println("Temperature in Fahrenheit: " + convertCelsiusToFahrenheit(celsius));

        System.out.print("Enter weight in pounds: ");
        double pounds = sc.nextDouble();
        System.out.println("Weight in kilograms: " + convertPoundsToKilograms(pounds));

        System.out.print("Enter weight in kilograms: ");
        double kilograms = sc.nextDouble();
        System.out.println("Weight in pounds: " + convertKilogramsToPounds(kilograms));

        System.out.print("Enter volume in gallons: ");
        double gallons = sc.nextDouble();
        System.out.println("Volume in liters: " + convertGallonsToLiters(gallons));

        System.out.print("Enter volume in liters: ");
        double liters = sc.nextDouble();
        System.out.println("Volume in gallons: " + convertLitersToGallons(liters));

        sc.close();
    }
}
