import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchCSVRecords {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Hp\\OneDrive\\Desktop\\CapgiAssignments\\feature-25-02-25\\employees.csv";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee name to search: ");
        String searchName = scanner.nextLine().trim();
        boolean found = false;
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;
            boolean isHeader = true;
            while ((nextLine = reader.readNext()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                String name = nextLine[1].trim();
                if (name.equalsIgnoreCase(searchName)) {
                    System.out.println("Employee Found!");
                    System.out.println("Department: " + nextLine[2]);
                    System.out.println("Salary: " + nextLine[3]);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Employee not found.");
            }
        } catch (IOException | CsvException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
