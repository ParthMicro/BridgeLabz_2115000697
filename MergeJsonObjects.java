import org.json.JSONObject;
public class MergeJsonObjects {
    public static void main(String[] args) {
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("name", "Parth Goyal");
        jsonObject1.put("email", "parthgoyal123@gmail.com");
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("age", 22);
        jsonObject2.put("city", "Gwalior");
        JSONObject mergedJson = new JSONObject(jsonObject1, JSONObject.getNames(jsonObject1));
        for (String key : JSONObject.getNames(jsonObject2)) {
            mergedJson.put(key, jsonObject2.get(key));
        }
        System.out.println(mergedJson.toString());
    }
}
