package com.controlhome.myhome.util;

public class StringUtil {

    public static boolean isValid(String s) {
        return s != null && !s.isEmpty() && !s.isBlank();
    }
}
