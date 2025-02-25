import com.opencsv.CSVReader;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class Student {
    private String name;
    private int age;
    private String department;

    public Student(String name, int age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", department='" + department + "'}";
    }
}
public class CSVToStudent {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Hp\\OneDrive\\Desktop\\CapgiAssignments\\feature-25-02-25\\src\\main\\students.csv" ;
        List<Student> students = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            reader.readNext();
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                try {
                    String name = nextLine[0].trim();
                    int age = nextLine[1].trim().isEmpty() ? 0 : Integer.parseInt(nextLine[1].trim());
                    String department = nextLine[2].trim();
                    students.add(new Student(name, age, department));
                } catch (NumberFormatException e) {
                    System.err.println("Skipping invalid data: " + String.join(", ", nextLine));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
