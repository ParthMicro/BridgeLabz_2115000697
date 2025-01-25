import java.util.Scanner;

public class MarksAndPercentage2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numOfStudents = sc.nextInt();

        int[][] marks = new int[numOfStudents][3];
        double[] percentages = new double[numOfStudents];
        char[] grades = new char[numOfStudents];

        for (int i = 0; i < numOfStudents; i++) {
            System.out.println("Enter marks for Student " + (i + 1) + ":");

            for (int j = 0; j < 3; j++) {
                String subject = (j == 0) ? "Physics" : (j == 1) ? "Chemistry" : "Maths";
                while (true) {
                    System.out.print("Enter marks in " + subject + ": ");
                    marks[i][j] = sc.nextInt();
                    if (marks[i][j] >= 0) break;
                    System.out.println("Please enter positive values for marks.");
                }
            }

            int totalMarks = marks[i][0] + marks[i][1] + marks[i][2];
            percentages[i] = totalMarks / 3.0;

            if (percentages[i] >= 80.0) {
                grades[i] = 'A';
            } else if (percentages[i] >= 70.0) {
                grades[i] = 'B';
            } else if (percentages[i] >= 60.0) {
                grades[i] = 'C';
            } else if (percentages[i] >= 50.0) {
                grades[i] = 'D';
            } else if (percentages[i] >= 40.0) {
                grades[i] = 'E';
            } else {
                grades[i] = 'F';
            }
        }

        System.out.println("\nStudent Marks, Percentages, and Grades:");
        for (int i = 0; i < numOfStudents; i++) {
            System.out.println("Student " + (i + 1) + ":");
            System.out.println("  Physics: " + marks[i][0]);
            System.out.println("  Chemistry: " + marks[i][1]);
            System.out.println("  Maths: " + marks[i][2]);
            System.out.printf("  Percentage: %.2f%%\n", percentages[i]);
            System.out.println("  Grade: " + grades[i]);
        }

        sc.close();
    }
}
