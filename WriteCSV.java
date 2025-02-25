import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
public class WriteCSV {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        String[][] employees = {
                {"ID", "Name", "Department", "Salary"},
                {"101", "Alice Johnson", "HR", "60000"},
                {"102", "Bob Smith", "IT", "75000"},
                {"103", "Charlie Brown", "Finance", "70000"},
                {"104", "Diana Prince", "Marketing", "65000"},
                {"105", "Edward Wilson", "Operations", "72000"}
        };
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            for (String[] employee : employees) {
                writer.writeNext(employee);
            }
            System.out.println("CSV file created successfully: " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing to CSV file: " + e.getMessage());
        }
    }
}
