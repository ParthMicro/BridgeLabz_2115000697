import java.util.Scanner;

public class TwoDimensionalToOneDimensional {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        
        System.out.print("Enter number of columns: ");
        int columns = sc.nextInt();
        
        int[][] matrix = new int[rows][columns];
        
        System.out.println("Enter elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Enter element at position (" + i + "," + j + "): ");
                matrix[i][j] = sc.nextInt();
            }
        }
        
        int[] array = new int[rows * columns];
        int index = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[index++] = matrix[i][j];
            }
        }
        
        System.out.println("1D Array after copying elements from 2D array:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        sc.close();
    }
}
