import static org.junit.Assert.*;

import org.junit.Test;

public class ShagunFunction5or6 {

	@Test
	public void test() {
//		fail("Not yet implemented");
		ScientificCalculator test1 = new ScientificCalculator();
		test1.function5or6("1", "e", "4");
		test1.function5or6("10", "10", "-4");
		test1.function5or6("2", "20", "-2");
		test1.function5or6("3", "e", "10");
		test1.function5or6("5", "0", "1");
		test1.function5or6("1", "e", "0");
		test1.function5or6("a", "e", "b");
		test1.function5or6("2", "1", "0");
	}

}
