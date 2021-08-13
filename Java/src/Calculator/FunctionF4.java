package Calculator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FunctionF4 {
	/**
	 * This function calculates the gamma function and displays the
	 * result based on user input.
	 * @param input
	 * @return
	 */
	public static String gamma(double input) {					
		try {						
			String inputStringValue = "" + input;
			String [] splittedInputValue = inputStringValue.split("\\.");
			
			if (input <= 0)
				return "Input cannot be zero or negative integer.";
			
			else if (splittedInputValue[1].length() > 1)
				return errorMessage();
			else if (splittedInputValue[1].length() == 1 && !splittedInputValue[1].equals("0")) {
				if (splittedInputValue[1].equals("5"))
					return ("Result is: " + resultOfHalfIntegerValue(input));
				else
					return errorMessage();
			}
				
			else
				return ("Result is: " + resultOfIntegerValue(input));
		} catch(InputMismatchException e) {
			return ("Your input needs to be a positive integer.");
		}		
	}
		
	/**
	 * This function is executed for a half positive integer input values.
	 * E.g: 0.5, 1.5, 2.5, ... 
	 * @param num
	 * @return
	 */
	public static double resultOfHalfIntegerValue(double num) {
//		if (num == 0.5)
//			return 1.77;
//		else
//			return ((num - 1) * resultOfHalfIntegerValue(num - 1));
		double fact = 1.77;
		double result = 1;
		
		
		for(int i = 1; i < num; i++) {						
			double value = num - i;			
			result *= value;			
		}
		return fact * result;
		
	}
	
	/**
	 * This function is executed for a positive integer input values.
	 * @param num
	 * @return
	 */
	public static double resultOfIntegerValue(double num) {
//		if (num == 1)
//			return 1;
//		else
//			return ((num - 1) * resultOfIntegerValue(num - 1));
		double fact = 1.0;
		
		for(int i = 1; i < num; i++) {
			fact = fact * i;
		}
		
		return fact;		
	}
	
	/**
	 * Displays an error message.
	 * @return
	 */
	public static String errorMessage() {
		return ("Input can only be either positive integer or half-integer values. (E.g: 0.5, 1, 1.5, 2, 2.5,...");
	}		
}