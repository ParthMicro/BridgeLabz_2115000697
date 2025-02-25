import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.Base64;
import java.util.List;
public class EncryptDecryptCSV {
    private static final String CSV_FILE = "employees_encrypted.csv";
    private static SecretKey secretKey;
    public static void main(String[] args) throws Exception {
        secretKey = generateKey();
        writeEncryptedCSV();
        readDecryptedCSV();
    }
    private static SecretKey generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        return keyGen.generateKey();
    }
    private static String encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
    private static String decrypt(String encryptedData) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(decryptedBytes);
    }
    private static void writeEncryptedCSV() throws Exception {
        try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_FILE))) {
            String[] header = {"ID", "Name", "Department", "Salary", "Email"};
            writer.writeNext(header);
            String[][] employees = {
                    {"101", "Alice Johnson", "HR", "60000", "alice.johnson@example.com"},
                    {"102", "Bob Smith", "IT", "75000", "bob.smith@company.com"},
                    {"103", "Charlie Brown", "Finance", "70000", "charlie.brown@email.com"},
                    {"104", "Diana Prince", "Marketing", "65000", "diana.prince@org.com"}
            };
            for (String[] employee : employees) {
                employee[3] = encrypt(employee[3]);
                employee[4] = encrypt(employee[4]);
                writer.writeNext(employee);
            }
            System.out.println("Encrypted CSV written successfully: " + CSV_FILE);
        }
    }
    private static void readDecryptedCSV() throws Exception {
        try (CSVReader reader = new CSVReader(new FileReader(CSV_FILE))) {
            List<String[]> records = reader.readAll();
            System.out.println("\nDecrypted Employee Data:");
            for (int i = 0; i < records.size(); i++) {
                String[] row = records.get(i);
                if (i == 0) {
                    System.out.println(String.join(", ", row)); // Print header
                } else {
                    row[3] = decrypt(row[3]);
                    row[4] = decrypt(row[4]);
                    System.out.println(String.join(", ", row));
                }
            }
        }
    }
}
