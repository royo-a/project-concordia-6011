package Calculator;

import java.util.Scanner;

public class Calculator {
    // --------------------------- Functions for tan(x) --------------------------------------
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
        // We are leaving 8 zeroes after the whole part so that we can add the fractional part without affecting the â¤µï¸�
        // whole part.
        number = wholePart * 100000000;
        // We add the fractional digits to the number in integer form
        number += fractionAsInteger;
        // We divide with 10e8 to get the fractional parts
        number/=100000000;

        return number;
    }

    private static double calculateCos(int angle) {
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

    private static double calculateSin(int angle) {
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

    public static double calculateTan(int angle) {
        double result = calculateSin(angle) / calculateCos(angle);
        if(result == Double.POSITIVE_INFINITY || result == Double.NEGATIVE_INFINITY){
            throw new ArithmeticException("TestSrc.Tangent for an angle which is 90 degree or" +
                    " any odd multiples of 90 degree doesn't exist.");
        }

        return roundTo8Digits(result);
    }

    // --------------------------- Functions for sin(x) --------------------------------------
    public static void function3or4() {

    }

   // --------------------------- Functions for ab^x --------------------------------------
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
	
	public static String checkValid(String input) {
//		this function validate the input and their types to be matched.
	
		if(input.equals("e")) {
			return input;
		}else {
			try {
				double tempa = Double.parseDouble(input);
//				ranging from -100000 to 100000
				if(tempa > -100000 && tempa <= 100000) {
					return input;
				}else {
					System.out.println("Please provide input ranging from -100000 to 100000");
				}
				
			}catch(NumberFormatException e) {
				System.out.println("Invalid Input - "+e);
			}
			System.out.println("Please enter again");
			return null;
		}
	}
	
	public static String function5or6(String a, String b, String x) {
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
			y = tempa*y;
			
		}else {
			tempb = Double.parseDouble(b);
			if(x.equals("e")) {
				tempx = 1;
			}else {
				tempx = Integer.parseInt(x);
			}
			
			if(tempb != 0.0) {
				y = f5Power(tempb,tempx);
				y = tempa*y;
			}else {
				y = 0;
			}
			
		}
//		Result -> a*b^x
		System.out.println("Result = "+ y +"\n");
		return Double.toString(y);
	}

	  /**
    // --------------------------- Functions for x^y --------------------------------------

	  /**
	 *Recursive Power Function.
	 *Divide and Conquer Algorithm.
	 */
	  
	  public static double basicPower(double x, int y) { // various cases
	    if (y == 0) {
	      return 1; 
	    } else if (y % 2 == 0)  { // if exponent is even
	      return basicPower(x, y / 2) * basicPower(x, y / 2); 
	    } else {
	      return x * basicPower(x, y / 2) * basicPower(x, y / 2); // if exponent is odd
	    }
	  }
	  
	  /**
	 * Function to calculate factorial of a numbers.
	 * Inputs an integer
	 * Returns integer 
	 */

	  public static int factorial(int number) {
	    int fact = 1;
	    for (int i = 1; i <= number; i++) { 
	      fact = fact * i; 
	    } 
	    return fact;
	  }
	  
	  /**
	 * Function to calculate power of base and exponent.
	 * Inputs three double values
	 * Returns the result of computation double value 
	 */
	 public static int iterations = 13;
	 
	  public static double decimalExp(double power, double baseValue, double expValue) {
	    int iteration = iterations;
	    float result = 1; 
	    int fatorial;
	    while (iteration > 0) {
	      fatorial = factorial(iteration);
	      result += basicPower(power, iteration) / fatorial;
	      iteration--;
	    }
	    if (baseValue < 0) {
	      return result * basicPower(-1.0, (int) expValue);
	    }
	    return result;
	  }
	  
	  /**
	 * Function to calculate log value of a number.
	 * Inputs a double number
	 * Returns a double value
	 */
	  
	  public static double logN(double number) {
	    if (number < 0)  {
	      number = -number;
	    }
	    double modNum1 = number - 1;
	    double modNum2 = number + 1;
	    double mix = modNum1 / modNum2;
	    double result = 0;
	    int iteration = 100;
	      if (iteration % 2 != 0) {
	        result += basicPower(mix, iteration) / iteration;
	      }
	      iteration--;
	    } 
	    return result * 2;
	  }
    public static void function7or8() {
		    double baseValue;
		    double exponentValue;
		    while(true) {
		    Scanner sc = new Scanner(System.in);
		    System.out.println("Enter the Base value:");
		    String base = sc.nextLine();
		    System.out.println("Enter the Exponent value:");
		    String exponent = sc.nextLine();
		    try {
		      baseValue = Double.parseDouble(base);
		      exponentValue = Double.parseDouble(exponent);
		      if (baseValue == 0.0) {
		        if (exponentValue == 0.0) {
		          System.out.println("\n Indeterminate - \"0 raised to the power 0\"");
		        } else {
		          System.out.println("0 to the power anything is 0");
		        }
		      } else {
		        double result = decimalExp(exponentValue * logN(baseValue), baseValue, exponentValue);
		        if ((baseValue > 0 && baseValue < 20) && (exponentValue > 0 && exponentValue < 5)) {
		          System.out.println(result - (result % 1)); //floor function (scratch)
		        } else {
		          System.out.println((result));
		        }
		      }
		    } catch (NumberFormatException e) {
		      System.out.println("Exception : Entered input is not a double value ");
		    }
		    }
}
