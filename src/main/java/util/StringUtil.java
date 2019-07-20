package util;

public class StringUtil {

    public static boolean isValid(String s) {
        return s != null && !s.isEmpty() && !s.isBlank();
    }
}
