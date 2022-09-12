package com.diagorn.checksum;

/**
 * Utilities working with strings
 *
 * @author Diagorn
 */
public class StringUtils {

    /**
     * Checks if string contains only numbers and spaces
     */
    public static boolean isStringDigit(String string) {
        for (char c: string.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
