package com.company;

import java.util.*;
public class ScientificCalculator {
	private static long[] factorials = generateFactorials(19);

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
		// So we remove anything before the decimal.
		number = number - wholePart;
		// We cannot work directly on the fractional part.
		// We need to get them as integers to do math on them.
		// Get upto 10 digits of fractional part as integers so we can process them.
		long numberWholePart = (long) (number * 1000000000.0);
		// Get the last digit and check whether it is >= 5
		// If it is, we need to add 1 to the last digit to round the number
		int remainder = (int) (numberWholePart % 10);
		numberWholePart /= 10;

		if (remainder >= 5) {
			numberWholePart += 1;
		}

		// Now that our calculation is complete, we need to turn the number back to fraction
		// We accomodate the whole part in the number first
		number = wholePart * 100000000;
		// We add the fractional digits to the number as integers
		number += numberWholePart;
		// We divide with 10e9 to get the fractional parts
		number/=100000000;
//        number = (double) numberWholePart / 1000000000;
//        number += wholePart;

		return number;
	}

	private static double calculateCos(int angle, long[] factorials) {
		// Angles greater than 360 can be represented within 360 in the quadrants.
		// We first convert the angles within 360 degrees.
		angle = angle % 360;

		// For both positive and negative cos angle, the results are the same.
		// We want to work with positive angles and reflect the sign later based on their quadrant.
		if (angle < 0) {
			// make the angle positive for calculation
			angle *= -1;
		}

		// We'll convert the angles within 90 degree to improve calculation accuracy.
		// We also have to keep track of the quadrants to determine the sign.
		double quadrant = (double) angle/90;
		double quadrantSign = 1;
		if(quadrant > 1 && quadrant <= 2){
			angle = 180-angle;
			quadrantSign = -1;
		} else if(quadrant > 2 && quadrant <= 3){
			angle = angle-180;
			quadrantSign = -1;
		} else if(quadrant > 3){
			angle = 360-angle;
		}

		boolean shouldSubtract = true;
		double angleInRadian = angle * 3.141592654 / 180;
		double angleInRadianSquare = angleInRadian * angleInRadian;
		double numerator = angleInRadianSquare;
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
			numerator = numerator * angleInRadianSquare;
			digitToFactorial += 2;
		}

		result = roundTo8Digits(result);
		return result == 0 ? result : result * quadrantSign;
	}

	private static double calculateSin(int angle, long[] factorials) {
		// Angles greater than 360 can be represented within 360 in the quadrants.
		// We first convert the angles within 360 degrees.
		angle = angle % 360;

		// For the same angle, the results are the same, only their sign changes.
		// We want to work with positive angles and reflect the sign later in the result.
		double sign = 1;
		if (angle < 0) {
			// remember the sign
			sign = -1;
			// make the angle positive for calculation
			angle *= -1;
		}

		// We'll convert the angles within 90 degree to improve calculation accuracy.
		// We also have to keep track of the quadrants to determine the sign.
		double quadrant = (double) angle/90;
		double quadrantSign = 1;
		if(quadrant > 1 && quadrant <= 2){
			angle = 180-angle;
		} else if(quadrant > 2 && quadrant <= 3){
			angle = angle-180;
			quadrantSign = -1;
		} else if(quadrant > 3){
			angle = 360-angle;
			quadrantSign = -1;
		}

		boolean shouldSubtract = true;
		double angleInRadian = angle * 3.141592654 / 180;
		double angleInRadianSquare = angleInRadian * angleInRadian;
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
			numerator = numerator * angleInRadianSquare;
			digitToFactorial += 2;
		}

		result = roundTo8Digits(result);
		return result == 0 ? result : result * sign * quadrantSign;
	}

	public static double calculateTangent(int angle, long[] factorials) {
		return roundTo8Digits(calculateSin(angle, factorials) / calculateCos(angle, factorials));
	}
	
	public static void function3or4() {		
		FunctionF4.gamma();
	}
	
	public static float power(float b, float x) {
	    if (x < 0) {
	    	return power(b, x+1)/b;
	    }else if(x == 0) {
	    	return 1;
	    }else {
	    	return b*power(b, x-1);
		}
	  }
	
	public static float exponential(int n){
		int x = 1;
        float sum = 1;
        for (int i = n - 1; i > 0; --i )
            sum = 1 + x * sum / i;
  
        return sum;
    }
	
	public static String checkValid() {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		
		if(a.equals("e")) {
			return a;
		}else {
			try {
				float tempa = Float.parseFloat(a);
				return a;
			}catch(NumberFormatException e) {
				System.out.println("Invalid Input of a - "+e);
			}
			System.out.println("Please enter again : ");
			return checkValid();
		}
	}
	
	public static void function5or6(String a, String b, String x) {
		float y = 0;
		float tempa = 0, tempb = 0, tempx = 0;
		
		if(a.equals("e")) {
			tempa = 1;
		}else {
			tempa = Float.parseFloat(a);
		}
		
		if(b.equals("e")) {
			y = exponential(Integer.parseInt(x));
			
		}else {
			tempb = Float.parseFloat(b);
			if(x.equals("e")) {
				tempx = 1;
			}else {
				tempx = Float.parseFloat(x);
			}
		    y = power(tempb, tempx);
		}
		
	
		
		y = tempa * y;
		System.out.println("Result = "+y+"\n");
	}
	
	public static void function7or8() {
		
	}
	
	public static void menu() {
		int choice = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("Available Function");
		System.out.println("1. Function : tan(x) \n2. Function : Γ(x) \n3. Function : ab^x\n4. Function : x^y\n5. End");
		System.out.print("\nPlease enter your choice (enter function number) = ");
		try {
			choice = input.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("Please enter valid integers\n");
			menu();
		}
		
		
		switch(choice) {
		case 1:
			calculateTangent(25, factorials);
			menu();
		case 2:
			System.out.println("\nDetails of Γ(x)");
			function3or4();
			menu();
		case 3:
			System.out.println("\nDetails of ab^x");
			String a,b,x;
			System.out.println("Please enter the value of ");
			
			System.out.print("a = ");
			a = checkValid();
//			a = input.next();
			
			System.out.print("b = ");
			b = checkValid();
//			b = input.next();
			
			System.out.print("x = ");
			x = checkValid();
//			x = input.next();
			
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
