package com.diagorn.lab6.utils;

/**
 * String utilities
 *
 * @author Diagorn
 */
public class StringUtils {
    /**
     * Returns a string with a capital 1st letter
     *
     * letter -> Letter
     * String -> String
     *
     * @param str - given string
     * @return capitalized first letter
     */
    public static String capitalizeFirstLetter(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
