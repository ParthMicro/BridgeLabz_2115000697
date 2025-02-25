import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DetectDuplicateCSV {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Hp\\OneDrive\\Desktop\\CapgiAssignments\\feature-25-02-25\\src\\main\\employees3.csv";
        Map<String, String[]> recordMap = new HashMap<>();
        Set<String[]> duplicateRecords = new LinkedHashSet<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();
            boolean isHeader = true;

            for (String[] row : records) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String id = row[0].trim();

                if (recordMap.containsKey(id)) {
                    duplicateRecords.add(row);
                    duplicateRecords.add(recordMap.get(id));
                } else {
                    recordMap.put(id, row);
                }
            }

            if (duplicateRecords.isEmpty()) {
                System.out.println("No duplicate records found.");
            } else {
                System.out.println("Duplicate Records Found:");
                for (String[] duplicate : duplicateRecords) {
                    System.out.println(String.join(", ", duplicate));
                }
            }
        } catch (IOException | CsvException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
    }
}
