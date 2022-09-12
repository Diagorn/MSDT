package com.diagorn.checksum;

import com.diagorn.checksum.exception.snils.SnilsChecksumException;
import com.diagorn.checksum.exception.snils.SnilsEmptyException;
import com.diagorn.checksum.exception.snils.SnilsLengthException;

/**
 * Utils class for snils checksum validation
 *
 * @author Diagorn
 */
public class CheckSum {

    /**
     * length of snils string containing only numbers
     */
    private static final int SNILS_LENGTH = 11;

    /**
     * Checks if snils is valid
     *
     * @param snils - string to be checked
     *
     * @throws SnilsEmptyException if passed snils is null or empty
     * @throws SnilsLengthException if passed snils length is more or less than SNILS_LENGTH
     * @throws SnilsChecksumException if actual checksum is not equal to expected one
     * @throws IllegalArgumentException if passed string is not numeric
     */
    public static void validateSnils(String snils) {

        if (snils == null || snils.isEmpty()) {
            throw new SnilsEmptyException();
        }

        snils = snils
                .replaceAll(" ", "")
                .replaceAll("-", "");

        if (!StringUtils.isStringDigit(snils)) {
            throw new IllegalArgumentException("Snils '" + snils + "' has not only digits");
        }

        if (snils.length() != SNILS_LENGTH) {
            throw new SnilsLengthException("Snils length appears to be " + snils.length() + " instead of " + snils.length());
        }

        int checkDigit = getCheckSum(snils);
        int expectedSum = getExpectedChecksum(snils);

        if (expectedSum != checkDigit) {
            throw new SnilsChecksumException("Expected sum - " + expectedSum + ", actual sum - " + checkDigit + " for snils " + snils);
        }
    }

    /**
     * Get the checksum of snils
     *
     * @param snils - valid snils which has no spaces and/or dashes in it
     * @return snils checksum
     */
    public static int getCheckSum(String snils) {
        int sum = 0;
        for (int i = 0; i < SNILS_LENGTH - 2; i++) {
            sum += (snils.charAt(i) - '0') * (SNILS_LENGTH - 2 - i);
        }
        int checkDigit = 0;
        if (sum < 100) {
            checkDigit = sum;
        } else if (sum > 101) {
            checkDigit = sum % 101;
            if (checkDigit == 100) {
                checkDigit = 0;
            }
        }
        return checkDigit;
    }

    /**
     * Extracts the expected checksum from given snils
     *
     * @param snils given snils
     * @return expected checksum
     */
    public static int getExpectedChecksum(String snils) {
        return Integer.parseInt(snils.substring(SNILS_LENGTH - 2));
    }

    /**
     * Get actual information that snils is containing
     * Always returns an empty string because the last two characters are the checksum
     * and the first nine are just a random number
     *
     * @param snils - snils
     * @return empty string
     */
    public static String getActualInfo(String snils) {
        return "";
    }
}
