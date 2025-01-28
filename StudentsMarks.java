import java.util.Random;
public class StudentsMarks {
public static int[][] generateScores(int students) {
Random random = new Random();
int[][] scores = new int[students][3];
for (int i = 0; i < students; i++) {
for (int j = 0; j < 3; j++) {
scores[i][j] = random.nextInt(100);
}
}
return scores;
}

public static double[][] calculateTotalsAndPercentages(int[][] scores) {
double[][] results = new double[scores.length][3];
for (int i = 0; i < scores.length; i++) {
int total = scores[i][0] + scores[i][1] + scores[i][2];
double percentage = Math.round((total / 3.0) * 100.0) / 100.0;
results[i][0] = total;
results[i][1] = percentage;
results[i][2] = percentage >= 80 ? 1 : percentage >= 70 ? 2 : percentage >= 60 ? 3 : percentage >= 50 ? 4 : 5;
}
return results;
}
public static void displayResults(int[][] scores, double[][] results) {
System.out.println("Student\tPhysics\tChemistry\tMath\tTotal\tPercentage\tGrade");
for (int i = 0; i < scores.length; i++) {
System.out.printf("%d\t%d\t%d\t\t%d\t%.2f\t%.2f\t\t%.0f\n", i + 1, scores[i][0], scores[i][1], scores[i][2], results[i][0], results[i][1], results[i][2]);
}
}
public static void main(String[] args) {
int students = 5;
int[][] scores = generateScores(students);
double[][] results = calculateTotalsAndPercentages(scores);
displayResults(scores, results);
}
}
