import java.util.Scanner;

public class MarksAndPercentage {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numOfStudents = sc.nextInt();

        int[] physicsMarks = new int[numOfStudents];
        int[] chemistryMarks = new int[numOfStudents];
        int[] mathsMarks = new int[numOfStudents];
        double[] percentages = new double[numOfStudents];
        char[] grades = new char[numOfStudents];

        for (int i = 0; i < numOfStudents; i++) {
            System.out.println("Enter marks for Student " + (i + 1) + ":");

            while (true) {
                System.out.print("Enter marks in Physics: ");
                physicsMarks[i] = sc.nextInt();
                if (physicsMarks[i] >= 0) break;
                System.out.println("Please enter positive values for marks.");
            }

            while (true) {
                System.out.print("Enter marks in Chemistry: ");
                chemistryMarks[i] = sc.nextInt();
                if (chemistryMarks[i] >= 0) break;
                System.out.println("Please enter positive values for marks.");
            }

            while (true) {
                System.out.print("Enter marks in Maths: ");
                mathsMarks[i] = sc.nextInt();
                if (mathsMarks[i] >= 0) break;
                System.out.println("Please enter positive values for marks.");
            }

            int totalMarks = physicsMarks[i] + chemistryMarks[i] + mathsMarks[i];
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
            System.out.println("  Physics: " + physicsMarks[i]);
            System.out.println("  Chemistry: " + chemistryMarks[i]);
            System.out.println("  Maths: " + mathsMarks[i]);
            System.out.printf("  Percentage: %.2f%%\n", percentages[i]);
            System.out.println("  Grade: " + grades[i]);
        }

        sc.close();
    }
}
