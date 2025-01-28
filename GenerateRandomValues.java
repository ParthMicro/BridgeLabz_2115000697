import java.util.Random;

public class GenerateRandomValues {

    public static void main(String[] args) {
        int size = 5;
        int[] randomNumbers = generate4DigitRandomArray(size);
        
        System.out.println("Generated 4-digit random values:");
        for (int number : randomNumbers) {
            System.out.println(number);
        }
        
        double[] results = findAverageMinMax(randomNumbers);
        
        System.out.printf("\nAverage: %.2f\n", results[0]);
        System.out.println("Minimum: " + (int) results[1]);
        System.out.println("Maximum: " + (int) results[2]);
    }

    public static int[] generate4DigitRandomArray(int size) {
        int[] randomNumbers = new int[size];
        Random random = new Random();
        
        for (int i = 0; i < size; i++) {
            randomNumbers[i] = 1000 + random.nextInt(9000);
        }
        
        return randomNumbers;
    }

    public static double[] findAverageMinMax(int[] numbers) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (int number : numbers) {
            sum += number;
            min = Math.min(min, number);
            max = Math.max(max, number);
        }
        
        double average = (double) sum / numbers.length;
        return new double[]{average, min, max};
    }
}
