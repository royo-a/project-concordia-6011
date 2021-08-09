import java.util.*;
public class ScientificCalculator {
	
	private static long[] factorials = generateFactorials(19);

	// Can generate maximum 19! without overflow
	private static long[] generateFactorials(int maxTerm) {
		long[] factorials = new long[maxTerm + 1];
		factorials[0] = 1;
		factorials[1] = 1;
		for (int i = 2; i <= maxTerm; i++) {
			factorials[i] = i * factorials[i - 1];
		}

		return factorials;
	}

	private static double roundTo8Digits(double number) {
		// Get the part before the decimal.
		int wholePart = (int) number;
		// We only want to work with the digits after the decimal.
		// So we zero digits before the decimal.
		number = number - wholePart;
		// We cannot work directly on the fractional part.
		// We need to get them as integers to do math on them.
		// Get upto 9 digits of fractional part as integers so we can process them.
		long fractionAsInteger = (long) (number * 1000000000.0);
		// Get the 9th digit and check whether it is >= 5
		// If it is, we need to add 1 to the 8th digit to round the number
		int ninthDigit = (int) (fractionAsInteger % 10);
		fractionAsInteger /= 10;

		if (ninthDigit >= 5) {
			fractionAsInteger += 1;
		}

		// Now that our calculation is complete, we need to convert the fraction from integer -> fraction
		// We accommodate the whole part in the number first
		// We are leaving 8 zeroes after the whole part so that we can add the fractional part without affecting the ⤵️
		// whole part.
		number = wholePart * 100000000;
		// We add the fractional digits to the number in integer form
		number += fractionAsInteger;
		// We divide with 10e8 to get the fractional parts
		number/=100000000;

		return number;
	}

	private static double calculateCos(int angle, long[] factorials) {
		// Angles greater than 360 can be represented within 360. This makes the calculation faster.
		angle = angle % 360;

		// For both positive and negative angle, the results of cosine are the same.
		// We want to work with positive angles for easiness and reflect the sign later based on their quadrant.
		if (angle < 0) {
			// taking absolute value of angle
			angle *= -1;
		}

		// We'll convert the angles within 90 degree to further improve calculation accuracy and speed.
		// We also have to keep track of the quadrants to manually determine the sign.
		double quadrant = (double) angle/90;
		double signInQuadrant = 1;
		if(quadrant > 1 && quadrant <= 2){
			angle = 180-angle;
			signInQuadrant = -1;
		} else if(quadrant > 2 && quadrant <= 3){
			angle = angle-180;
			signInQuadrant = -1;
		} else if(quadrant > 3){
			angle = 360-angle;
		}

		// Calculation for Taylor series
		boolean shouldSubtract = true;
		double angleInRadian = angle * 3.141592654 / 180;
		double squareOfRadianAngle = angleInRadian * angleInRadian;
		double numerator = squareOfRadianAngle;
		int digitToFactorial = 2;
		double result = 1;
		for (int i = 1; i <= 9; i++) {
			double nTerm = numerator / factorials[digitToFactorial];
			if (shouldSubtract) {
				nTerm *= -1;
				shouldSubtract = false;
			} else {
				shouldSubtract = true;
			}
			result += nTerm;
			numerator = numerator * squareOfRadianAngle;
			digitToFactorial += 2;
		}

		result = roundTo8Digits(result);
		// For 0, don't return any sign
		return result == 0 ? result : result * signInQuadrant;
	}

	private static double calculateSin(int angle, long[] factorials) {
		// Angles greater than 360 can be represented within 360 in the quadrants.
		angle = angle % 360;

		// For both positive and negative angle, the results of cosine are the same, only their sign changes.
		// We want to work with positive angles for easiness and reflect the sign later based on their quadrant and
		// initial sign of input angle.
		double sign = 1;
		if (angle < 0) {
			// remember the sign
			sign = -1;
			// taking absolute value of angle
			angle *= -1;
		}

		// We'll convert the angles within 90 degree to further improve calculation accuracy and speed.
		// We also have to keep track of the quadrants to manually determine the sign.
		double quadrant = (double) angle/90;
		double signInQuadrant = 1;
		if(quadrant > 1 && quadrant <= 2){
			angle = 180-angle;
		} else if(quadrant > 2 && quadrant <= 3){
			angle = angle-180;
			signInQuadrant = -1;
		} else if(quadrant > 3){
			angle = 360-angle;
			signInQuadrant = -1;
		}

		// Calculation for Taylor series
		boolean shouldSubtract = true;
		double angleInRadian = angle * 3.141592654 / 180;
		double squareOfRadianAngle = angleInRadian * angleInRadian;
		double numerator = angleInRadian * angleInRadian * angleInRadian;
		int digitToFactorial = 3;
		double result = angleInRadian;
		for (int i = 1; i <= 9; i++) {
			double nTerm = numerator / factorials[digitToFactorial];
			if (shouldSubtract) {
				nTerm *= -1;
				shouldSubtract = false;
			} else {
				shouldSubtract = true;
			}
			result += nTerm;
			numerator = numerator * squareOfRadianAngle;
			digitToFactorial += 2;
		}

		result = roundTo8Digits(result);
		return result == 0 ? result : result * sign * signInQuadrant;
	}

	public static double calculateTan(int angle, long[] factorials) {
		double result = calculateSin(angle, factorials) / calculateCos(angle, factorials);
		if(result == Double.POSITIVE_INFINITY || result == Double.NEGATIVE_INFINITY){
			throw new ArithmeticException("Tangent for an angle which is 90 degree or" +
					" any odd multiples of 90 degree doesn't exist.");
		}

		return roundTo8Digits(result);
	}
	
	public static void function3or4() {
			
		}
	
	public static double powerHandler(double x, int n) {
//		recursive logic for power
		if(n==0) return 1;
		if(n==1) return x;
		if(n%2 == 0) 
			return powerHandler(x*x, n/2);
		return x*powerHandler(x*x, n/2);
	}
	
	public static double f5Power(double x, int n) {
		if(n < 0) {
//			if n is -ve 
			return 1.0/powerHandler(x,Math.abs(n));
		}
//		n is +ve
		return powerHandler(x,n);
	}
	
	
	public static double exponential(int n){
		int x = 1;
        double sum = 1;
        for (int i = n - 1; i > 0; --i )
            sum = 1 + x * sum / i;
  
        return sum;
    }
	
	public static String checkValid() {
//		this function validate the input and thier types to be matched.
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		
		if(a.equals("e")) {
			return a;
		}else {
			try {
				double tempa = Double.parseDouble(a);
//				ranging from -100000 to 100000
				if(tempa > -100000 && tempa <= 100000) {
					return a;
				}else {
					System.out.println("Please provide input ranging from -100000 to 100000");
				}
				
			}catch(NumberFormatException e) {
				System.out.println("Invalid Input of a - "+e);
			}
			System.out.println("Please enter again : ");
			return checkValid();
		}
	}
	
	public static void function5or6(String a, String b, String x) {
		double y;
		double tempa = 0, tempb = 0;
		int tempx = 0;
		
		if(a.equals("e")) {
			tempa = 1;
		}else {
			tempa = Long.parseLong(a);
		}
		
		if(b.equals("e")) {
			y = exponential(Integer.parseInt(x));
			
		}else {
			tempb = Double.parseDouble(b);
			if(x.equals("e")) {
				tempx = 1;
			}else {
				tempx = Integer.parseInt(x);
			}
			
			y = f5Power(tempb,tempx);
			
		}
//		Result -> a*b^x
		System.out.println("Result = "+ tempa* y +"\n");
	}
	
	public static void function7or8() {
		
	}
	
	public static void menu() {
		int choice = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("Avaiable Function");
		System.out.println("1. Function : tan(x) \n2. Function : sinh(x)\n3. Function : ab^x\n4. Function : x^y\n5. End");
		System.out.print("\nPlease enter your choice (enter function number) = ");
		try {
			choice = input.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("Please enter valid integers\n");
			menu();
		}
		
		
		switch(choice) {
		case 1:
			Scanner myScanner = new Scanner(System.in);
			System.out.println("Enter an angle in degrees(needs to be integer):");
			try {
				int angle = myScanner.nextInt();
				System.out.println(calculateTan(angle, factorials));
			} catch (InputMismatchException e) {
				System.out.println("Your input needs to be an integer in the range -2147483648" +
						" to 2147483647. Please try again.");
			} catch (ArithmeticException e){
				System.out.println(e.getMessage());
			}
			menu();
		case 2:
			System.out.println("\nDetails of sinh(x)");
			function3or4();
			menu();
		case 3:
//			taking magical number such as 'e' as input - every input has been taken in string 
			System.out.println("\nDetails of ab^x");
			String a,b,x;
			System.out.println("Please enter the value of ");
			
			System.out.print("a = ");
			a = checkValid();
			
			System.out.print("b = ");
			b = checkValid();
			
			System.out.print("x = ");
			x = checkValid();
			
			function5or6(a,b,x);
			menu();
		case 4:
			System.out.println("\nDetails of x^y");
			function7or8();
			menu();
		case 5:
			System.out.println("--------End--------");
			System.exit(0);
			break;
		default:
			System.out.println("Please enter valid number from 1 to 5\n");
			menu();
			break;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Adding menu to the scientific calculator
		
		System.out.println("--------Start--------");
		menu();
		
	}

}
