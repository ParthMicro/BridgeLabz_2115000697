import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;
public class ValidateCSV {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Hp\\OneDrive\\Desktop\\CapgiAssignments\\feature-25-02-25\\src\\main\\employees2.csv";
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String phoneRegex = "^\\d{10}$";
        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();
            boolean isHeader = true;
            for (String[] row : records) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                String email = row[3].trim();
                String phone = row[4].trim();
                boolean validEmail = emailPattern.matcher(email).matches();
                boolean validPhone = phonePattern.matcher(phone).matches();
                if (!validEmail || !validPhone) {
                    System.out.println("Invalid row: " + String.join(", ", row));
                    if (!validEmail) {
                        System.out.println("  Invalid Email: " + email);
                    }
                    if (!validPhone) {
                        System.out.println("  Invalid Phone: " + phone);
                    }
                }
            }
        } catch (IOException | CsvException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
    }
}
