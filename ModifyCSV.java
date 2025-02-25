import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import java.io.*;
import java.util.List;
public class ModifyCSV {
    public static void main(String[] args) {
        String inputFilePath = "C:\\Users\\Hp\\OneDrive\\Desktop\\CapgiAssignments\\feature-25-02-25\\employees.csv";
        String outputFilePath = "updated_employees.csv";
        try (
                CSVReader reader = new CSVReader(new FileReader(inputFilePath));
                CSVWriter writer = new CSVWriter(new FileWriter(outputFilePath))
        ) {
            List<String[]> records = reader.readAll();
            for (int i = 0; i < records.size(); i++) {
                String[] row = records.get(i);
                if (i > 0 && row[2].equalsIgnoreCase("IT")) {
                    double salary = Double.parseDouble(row[3]);
                    salary *= 1.10;
                    row[3] = String.format("%.2f", salary);
                }
                writer.writeNext(row);
            }
            System.out.println("Salaries updated successfully. New file: " + outputFilePath);
        } catch (IOException | CsvException | NumberFormatException e) {
            System.err.println("Error processing CSV file: " + e.getMessage());
        }
    }
}

