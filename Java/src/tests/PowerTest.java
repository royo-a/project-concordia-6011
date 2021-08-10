import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

/**
 * SOEN 6011 - Function F7 x power y test cases This class is JUnit test class.
 * for Power.java
 */
public class PowerTest {
  /**
 * TC 1 Testing the log function Latest implementation of assertEquals.
 * double values Delta precision is added for test
 */
  @Test
public void testLog() {
    assertEquals(Power.logN(2), 0.6931471805599453, 1e-15);
  }

  /**
 * TC 2 Testing the log function Associated Functional Requirement: FUNR1.
 * implementation of assertEqulas for double values Delta precision is added for
 * test
 */
  @Test
public void testdecimalExp() {
    assertEquals(Power.decimalExp(2 * Power.logN(2), 2, 2), 4.0, 1e-15);
  }

  /**
 * TC 3 Testing Divide and Conquer Algorithm Power Law Product.
 */
  
  @Test
public void testPowerLawProduct() {
    double output1 = Power.decimalExp(2 * Power.logN(2), 2, 2);
    double output2 = Power.decimalExp(2 * Power.logN(2), 2, 2);
    double finalOutput = Power.decimalExp(4 * Power.logN(2), 2, 4);
    assertEquals(output1 * output2, finalOutput, 0.1);
  }

  /**
 * TC 4 Testing Divide and Conquer Algorithm Power Law Division.
 */
  @Test
public void testPowerLawDivision() {
    double output1 = Power.decimalExp(2 * Power.logN(2), 2, 2);
    double output2 = Power.decimalExp(2 * Power.logN(2), 2, 2);
    double finalOutput = Power.decimalExp(0 * Power.logN(2), 2, 0);
    assertEquals(output1 / output2, finalOutput, 1e-15);
  }

  /**
 * TC 5 Testing Factorial function.
 */
  @Test
public void testFactorial() {
    int factThree = 6;
    int fact = 3;
    assertEquals(Power.factorial(fact), factThree);
  }

  /**
 * TC 6 Associated Functional Requirement: FUNR2 Testing Factorial function.
 */

  @Test
public void testNumberPowerZero() {
    double result = 0.0;
    assertEquals(Power.basicPower(10, 0), result, 1);
  }

  /**
 * TC 7 Associated Functional Requirement: FUNR3 Testing Factorial function.
 */
  @Test
public void testZeroPowerN() {
    double result = 0.0;
    assertEquals(Power.basicPower(0.0, 10), result, 0.0);
  }

  /**
 * TC 7 Associated Functional Requirement: FUNR4 Testing Factorial function.
 */
  @Test
public void testNonNumberValues() {
    double result = 0.0;
    String test = "102";
    double input = Double.parseDouble(test);
    assertNotEquals(Power.basicPower(input, 10), result, 1);
  }

}
