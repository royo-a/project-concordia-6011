import static org.junit.Assert.*;

import org.junit.Test;

public class ShagunFunction5or6 {
//Testing for function5or6, function 5 y(x)=ab^x
	@Test
	public void test() {
//		fail("Not yet implemented");
		ScientificCalculator checkFunctionality = new ScientificCalculator();
		
		checkFunctionality.function5or6("10", "2", "10");
		checkFunctionality.function5or6("20", "12", "5");
		checkFunctionality.function5or6("-180", "6", "-2");
		checkFunctionality.function5or6("-64", "2", "4");
		
		checkFunctionality.function5or6("4", "e", "10");
		checkFunctionality.function5or6("24", "e", "1");
		checkFunctionality.function5or6("10", "e", "0");
		checkFunctionality.function5or6("-5", "e", "10");
	}

}
