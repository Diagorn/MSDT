package com.diagorn.checksum;

import com.diagorn.checksum.exception.snils.SnilsChecksumException;
import com.diagorn.checksum.exception.snils.SnilsEmptyException;
import com.diagorn.checksum.exception.snils.SnilsLengthException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CheckSumTest {

    @Test
    void checkNullString() {
        assertThrows(SnilsEmptyException.class, () -> {
            CheckSum.validateSnils(null);
        });
    }

    @Test
    void checkEmptyString() {
        assertThrows(SnilsEmptyException.class, () -> {
            CheckSum.validateSnils("");
        });
    }

    @Test
    void checkNonDigitsString() {
        assertThrows(IllegalArgumentException.class, () -> {
            CheckSum.validateSnils("123-456-789-o1");
        });
    }

    @Test
    void checkTooLongSnils() {
        assertThrows(SnilsLengthException.class, () -> {
            CheckSum.validateSnils("123-456-789-010");
        });
    }

    @Test
    void checkTooShortSnils() {
        assertThrows(SnilsLengthException.class, () -> {
            CheckSum.validateSnils("123-456-789");
        });
    }

    @Test
    void checkInvalidSum() {
        assertThrows(SnilsChecksumException.class, () -> {
            CheckSum.validateSnils("123-456-789-01");
        });
    }

    @Test
    void checkValidSum() {
        CheckSum.validateSnils("116-973-385 89");
    }

    @Test
    void getCheckSum() {
        assertEquals(89, CheckSum.getCheckSum("11697338589"));
    }

    @Test
    void getExpectedCheckSum() {
        assertEquals(89, CheckSum.getExpectedChecksum("11697338589"));
    }

    @Test
    void getActualInfo() {
        assertEquals("", CheckSum.getActualInfo("116-973-385 89"));
    }
}
