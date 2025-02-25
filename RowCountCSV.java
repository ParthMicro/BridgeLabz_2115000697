import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
public class RowCountCSV {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Hp\\OneDrive\\Desktop\\CapgiAssignments\\feature-25-02-25\\employees.csv";
        int rowCount = -1;
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            while (reader.readNext() != null) {
                rowCount++;
            }
            if (rowCount >= 0) {
                System.out.println("Total number of records (excluding header): " + rowCount);
            } else {
                System.out.println("No records found in the CSV file.");
            }
        } catch (IOException | CsvException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
    }
}

