import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
public class MergeJsonFiles {
    public static void main(String[] args) {
        try {
            String file1Path = "C:\\Users\\Hp\\OneDrive\\Desktop\\CapgiAssignments\\feature-26-02-25\\src\\main\\file2.json";
            String file2Path = "C:\\Users\\Hp\\OneDrive\\Desktop\\CapgiAssignments\\feature-26-02-25\\src\\main\\file3.json";
            String json1Str = new String(Files.readAllBytes(Paths.get(file1Path)));
            String json2Str = new String(Files.readAllBytes(Paths.get(file2Path)));
            JSONObject json1 = new JSONObject(json1Str);
            JSONObject json2 = new JSONObject(json2Str);
            JSONObject mergedJson = new JSONObject(json1, JSONObject.getNames(json1));
            for (String key : JSONObject.getNames(json2)) {
                mergedJson.put(key, json2.get(key));
            }
            System.out.println(mergedJson.toString(4));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
