package tests;

import TestSrc.Tangent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;

class TangentTest {

    // Test-ID: 01
    /* Tests the method that generates factorials.
       In this test, the returned array containing the factorials is checked.
     */
    @Test
    void generateFactorials() {
        long[] factorials = Tangent.generateFactorials(5);
        long[] expected = new long[]{1, 1, 2, 6, 24, 120};
        Assertions.assertArrayEquals(expected, factorials);
    }

    // Test-ID: 02
    /* Tests the method that rounds the digits to 7 decimal places.
       In this test, the returned rounded decimal is checked.
     */
    @Test
    void roundTo7Digits() {
        double result = Tangent.roundTo7Digits(2.14167894567);
        Assertions.assertEquals(2.1416789, result);

        result = Tangent.roundTo7Digits(2.14167899567);
        Assertions.assertEquals(2.1416790, result);
    }

    // Test-ID: 03
    /* Tests the method that calculates the cosine.
       In this test, the returned decimal is checked.
     */
    @Test
    void calculateCos() {
        double result = Tangent.calculateCos(45);
        Assertions.assertEquals(0.7071068, result);
        result = Tangent.calculateCos(90);
        Assertions.assertEquals(0, result);
        result = Tangent.calculateCos(0);
        Assertions.assertEquals(1, result);
        result = Tangent.calculateCos(89);
        Assertions.assertEquals(0.0174524, result);

    }

    // Test-ID: 04
    /* Tests the method that calculates the sine.
       In this test, the returned decimal is checked.
     */
    @Test
    void calculateSin() {
        double result = Tangent.calculateSin(45);
        Assertions.assertEquals(0.7071068, result);
        result = Tangent.calculateSin(90);
        Assertions.assertEquals(1, result);
        result = Tangent.calculateSin(0);
        Assertions.assertEquals(0, result);
        result = Tangent.calculateSin(89);
        Assertions.assertEquals(0.9998477, result);
    }

    // Test-ID: 05
    /* Tests the method that calculates the cosine.
       In this test, the returned decimal is checked for all corner cases.
     */
    @Test
    void calculateTan() {
        double result = Tangent.calculateTan(45);
        // An exception is thrown for 90 degrees
        Assertions.assertEquals(1, result);
        Exception exception = Assertions.assertThrows(ArithmeticException.class, ()->{
            Tangent.calculateTan(90);
        });

        // Testing general cases
        result = Tangent.calculateTan(0);
        Assertions.assertEquals(0, result);
        result = Tangent.calculateTan(89);
        Assertions.assertEquals(57.289983, result);
        result = Tangent.calculateTan(25);
        Assertions.assertEquals(0.4663077, result);

        // Testing for negative value
        result = Tangent.calculateTan(-25);
        Assertions.assertEquals(-0.4663077, result);

        // Testing for highest value
        result = Tangent.calculateTan(-2147483648);
        Assertions.assertEquals(1.2799417, result);

        // Testing for highest value
        result = Tangent.calculateTan(2147483647);
        Assertions.assertEquals(-1.3270449, result);
    }
}