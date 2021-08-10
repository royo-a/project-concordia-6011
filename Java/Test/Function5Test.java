import static org.junit.Assert.*;

import TestSrc.Function5;
import org.junit.Test;
/**
 * SOEN 6011 Test Cases for F5 = ab^x
 * @author Shagun Shagun
 *
 */
public class Function5Test {

//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}

	@Test
    public void testCheckInput() {
        assertEquals("e", Function5.checkValid("e"));
        assertEquals("10", Function5.checkValid("10"));
        assertEquals("-12", Function5.checkValid("-12"));
	}
	
	@Test
    public void testMagicalNumbere() {
        double sum = Function5.exponential(10);
        String result = Double.toString(sum);
        assertEquals(result, Function5.function5or6("1", "e", "10"));
	}
	
	@Test
    public void testfunction5or6AsWhole() {
        assertEquals("128.0", Function5.function5or6("2", "2", "6"));
        assertEquals("-128.0", Function5.function5or6("-2", "2", "6"));
	}
	
	@Test
    public void testNegativeF5PowerFunction() {
        assertEquals(1024.0, Function5.f5Power(-2,10),1);
        assertEquals(-512.0, Function5.f5Power(-2,9),1);
	}
	
	@Test
    public void testBigIntegerPower() {
		assertEquals("Infinity", Function5.function5or6("20", "2", "6000"));
        assertEquals("-Infinity", Function5.function5or6("-2", "2", "10000"));
	}
	
	@Test
    public void testAnythingPowerZero() {
		assertEquals("20.0", Function5.function5or6("20", "2", "0"));
        assertEquals("0.0", Function5.function5or6("2", "0", "0"));
	}
	
}
