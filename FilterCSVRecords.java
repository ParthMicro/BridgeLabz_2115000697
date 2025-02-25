import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
public class FilterCSVRecords {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Hp\\OneDrive\\Desktop\\CapgiAssignments\\feature-25-02-25\\src\\main\\student3.csv";
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;
            boolean isHeader = true;
            while ((nextLine = reader.readNext()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                int marks = Integer.parseInt(nextLine[2]);
                if (marks > 80) {
                    System.out.println("ID: " + nextLine[0] + ", Name: " + nextLine[1] + ", Marks: " + marks);
                }
            }
        } catch (IOException | CsvException | NumberFormatException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
    }
}
