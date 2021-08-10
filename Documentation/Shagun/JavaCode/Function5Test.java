import static org.junit.Assert.*;

import org.junit.Test;
/**
 * SOEN 6011 Test Cases for F5 = ab^x
 * @author Shagun Shagun
 *
 */
public class Function5Test {
	
	/**
	 * ID = TC1
	 * Test Case = checking the input given by user using checkValid
	 * Function Included = checkValid
	 */
	@Test
    public void testCheckInput() {
        assertEquals("e", Function5.checkValid("e"));
        assertEquals("10", Function5.checkValid("10"));
        assertEquals("-12", Function5.checkValid("-12"));
	}
	
	/**
	 * ID = TC2
	 * Test  Case =  the calculation for magical number such as "e"
	 * Function Included = exponential, function5or6
	 */
	@Test
    public void testMagicalNumbere() {
        double sum = Function5.exponential(10);
        String result = Double.toString(sum);
        assertEquals(result, Function5.function5or6("1", "e", "10"));
	}
	
	/**
	 * ID = TC3
	 * Test  Case =  the calculation for positive and negative numbers
	 * Function Included = function5or6
	 */
	@Test
    public void testfunction5or6AsWhole() {
        assertEquals("128.0", Function5.function5or6("2", "2", "6"));
        assertEquals("-128.0", Function5.function5or6("-2", "2", "6"));
	}
	
	/**
	 * ID = TC4
	 * Test  Case =  testing power function for the constant as base to the power x
	 * Function Included = f5Power
	 */
	@Test
    public void testNegativeF5PowerFunction() {
        assertEquals(1024.0, Function5.f5Power(-2,10),1);
        assertEquals(-512.0, Function5.f5Power(-2,9),1);
	}
	
	/**
	 * ID = TC5
	 * Test  Case =  testing bigInteger for ab^x function
	 * Function Included = function5or6
	 */
	@Test
    public void testBigIntegerPower() {
		assertEquals("Infinity", Function5.function5or6("20", "2", "6000"));
        assertEquals("-Infinity", Function5.function5or6("-2", "2", "10000"));
	}
	
	/**
	 * ID = TC5
	 * Test  Case =  testing function with 0 as base and 0 in power
	 * Function Included = function5or6
	 */
	@Test
    public void testAnythingPowerZero() {
		assertEquals("20.0", Function5.function5or6("20", "2", "0"));
        assertEquals("0.0", Function5.function5or6("2", "0", "0"));
	}
	
}
