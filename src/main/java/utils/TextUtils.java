package utils;

public class TextUtils {

    public static final String HEADER_BRACKET_STARS = "[********************************]";

    public static void printEmptyLines(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i < n; i++) {
            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder.toString());
    }
}
