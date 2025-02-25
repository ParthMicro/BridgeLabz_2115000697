import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class StudentTwo {
    int id;
    String name;
    int age;
    int marks;
    String grade;

    public StudentTwo(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void setMarksAndGrade(int marks, String grade) {
        this.marks = marks;
        this.grade = grade;
    }
}

public class MergeCSV {
    public static void main(String[] args) {
        String file1 = "C:\\Users\\Hp\\OneDrive\\Desktop\\CapgiAssignments\\feature-25-02-25\\src\\main\\student1.csv";
        String file2 = "C:\\Users\\Hp\\OneDrive\\Desktop\\CapgiAssignments\\feature-25-02-25\\src\\main\\student2.csv";
        String outputFile = "merged_students.csv";

        Map<Integer, StudentTwo> studentMap = new HashMap<>();

        try (CSVReader reader = new CSVReader(new FileReader(file1))) {
            List<String[]> rows = reader.readAll();
            rows.remove(0);
            for (String[] row : rows) {
                int id = Integer.parseInt(row[0].trim());
                String name = row[1].trim();
                int age = Integer.parseInt(row[2].trim());
                studentMap.put(id, new StudentTwo(id, name, age));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (CSVReader reader = new CSVReader(new FileReader(file2))) {
            List<String[]> rows = reader.readAll();
            rows.remove(0);
            for (String[] row : rows) {
                int id = Integer.parseInt(row[0].trim());
                int marks = Integer.parseInt(row[1].trim());
                String grade = row[2].trim();
                if (studentMap.containsKey(id)) {
                    studentMap.get(id).setMarksAndGrade(marks, grade);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {
            writer.writeNext(new String[]{"ID", "Name", "Age", "Marks", "Grade"});
            for (StudentTwo student : studentMap.values()) {
                writer.writeNext(new String[]{
                        String.valueOf(student.id),
                        student.name,
                        String.valueOf(student.age),
                        String.valueOf(student.marks),
                        student.grade
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("CSV files merged successfully! Check " + outputFile);
    }
}
