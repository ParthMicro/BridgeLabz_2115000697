import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class SortCSV {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();
            if (records.size() <= 1) {
                System.out.println("Not enough records to sort.");
                return;
            }
            String[] header = records.remove(0);
            records.sort((a, b) -> Double.compare(Double.parseDouble(b[3]), Double.parseDouble(a[3])));
            System.out.println(Arrays.toString(header));
            for (int i = 0; i < Math.min(5, records.size()); i++) {
                System.out.println(Arrays.toString(records.get(i)));
            }
        } catch (IOException | CsvException | NumberFormatException e) {
            System.err.println("Error processing CSV file: " + e.getMessage());
        }
    }
}
