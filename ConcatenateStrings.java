public class ConcatenateStrings {
    public static void main(String[] args) {
        String[] strings = {"I", " am", " currently", " pursuing", " B.tech", " in", " Computer", " Science."};

        String concatenatedString = concatenateStrings(strings);
        System.out.println("Concatenated string: " + concatenatedString);
    }

    public static String concatenateStrings(String[] strings) {
        StringBuffer sb = new StringBuffer();

        for (String str : strings) {
            sb.append(str);
        }

        return sb.toString();
    }
}
