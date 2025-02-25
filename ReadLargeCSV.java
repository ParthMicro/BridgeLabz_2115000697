import java.io.*;
public class ReadLargeCSV {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Hp\\OneDrive\\Desktop\\CapgiAssignments\\feature-25-02-25\\large_employees.csv";
        int batchSize = 100;
        int totalRecords = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            int batchCount = 0;
            while ((line = reader.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                batchCount++;
                totalRecords++;
                if (batchCount == batchSize) {
                    System.out.println("Processed " + totalRecords + " records...");
                    batchCount = 0;
                }
            }
            System.out.println("Finished processing " + totalRecords + " records.");
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        }
    }
}

