package com.diagorn.lab6.utils;

public class StringUtils {
    public static String capitalizeFirstLetter(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
