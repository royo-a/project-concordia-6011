import TestSrc.FunctionF4;
import org.junit.Assert;
import org.junit.Test;

public class FunctionF4Test {
	
	FunctionF4 gammaFunction;
	
	// Test to check if the input value is negative integer.	
	@Test
	public void testNegativeInputValue() {
		double input = -5;
		String message = "Input cannot be zero or negative integer.";
		Assert.assertEquals(FunctionF4.gamma(input), message);
	}
	
	// Test to check if the input value is zero.	
	@Test
	public void testZeroInputValue() {
		double input = 0;
		String message = "Input cannot be zero or negative integer.";
		Assert.assertEquals(FunctionF4.gamma(input), message);
	}
	
	// Test to check if the input value is positive integer.
	@Test
	public void testPositiveInputValue() {
		double input = 2.0;
		String message = "Result is: 1";
		Assert.assertEquals(FunctionF4.gamma(input), message);	
	}
	
	// Test to check if the input value is not a half-integer value.	
	@Test
	public void testNotHalfIntegerValue() {
		double input = 3.34;
		String message = "Input can only be either positive integer or half-integer values. (E.g: 0.5, 1, 1.5, 2, 2.5,...";
		Assert.assertEquals(FunctionF4.gamma(input), message);
	}
	
	// Test to check if the input value is not a half-integer value.	
	@Test
	public void testHalfIntegerValue() {
		double input = 1.5;
		String message = "Result is: 0.885";
		Assert.assertEquals(FunctionF4.gamma(input), message);
	}

}