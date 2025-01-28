import java.util.Random;
public class Matrix {
public static int[][] generateMatrix(int rows, int cols) {
Random random = new Random();
int[][] matrix = new int[rows][cols];
for (int i = 0; i < rows; i++) {
for (int j = 0; j < cols; j++) {
matrix[i][j] = random.nextInt(10);
}
}
return matrix;
}
public static int[][] addMatrices(int[][] a, int[][] b) {
int[][] result = new int[a.length][a[0].length];
for (int i = 0; i < a.length; i++) {
for (int j = 0; j < a[0].length; j++) {
result[i][j] = a[i][j] + b[i][j];
}
}
return result;
}
public static int[][] subtractMatrices(int[][] a, int[][] b) {
int[][] result = new int[a.length][a[0].length];
for (int i = 0; i < a.length; i++) {
for (int j = 0; j < a[0].length; j++) {
result[i][j] = a[i][j] - b[i][j];
}
}
return result;
}
public static int[][] multiplyMatrices(int[][] a, int[][] b) {
int[][] result = new int[a.length][b[0].length];
for (int i = 0; i < a.length; i++) {
for (int j = 0; j < b[0].length; j++) {
for (int k = 0; k < a[0].length; k++) {
result[i][j] += a[i][k] * b[k][j];
}
}
}
return result;
}
public static int determinant2x2(int[][] matrix) {
return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
}
public static void displayMatrix(int[][] matrix) {
for (int[] row : matrix) {
for (int value : row) {
System.out.print(value + " ");
}
System.out.println();
}
}
public static void main(String[] args) {
int[][] matrix1 = generateMatrix(2, 2);
int[][] matrix2 = generateMatrix(2, 2);
System.out.println("Matrix 1:");
displayMatrix(matrix1);
System.out.println("Matrix 2:");
displayMatrix(matrix2);
System.out.println("Addition:");
displayMatrix(addMatrices(matrix1, matrix2));
System.out.println("Subtraction:");
displayMatrix(subtractMatrices(matrix1, matrix2));
System.out.println("Multiplication:");
displayMatrix(multiplyMatrices(matrix1, matrix2));
System.out.println("Determinant of Matrix 1: " + determinant2x2(matrix1));
}
}
