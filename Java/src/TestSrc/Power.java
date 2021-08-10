import java.util.Scanner;

/**
 * SOEN 6011 F7 X power Y function implementation.
 *created by Pavit Srivatsan
 */

public class Power {
  public static int iterations = 13;
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
    while (iteration > 0) {
      if (iteration % 2 != 0) {
        result += basicPower(mix, iteration) / iteration;
      }
      iteration--;
    } 
    return result * 2;
  }

  /**
 * Function main.
 */
  public static void main(String[] args) {
    double baseValue;
    double exponentValue;
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
      sc.close();
    } catch (NumberFormatException e) {
      System.out.println("Exception : Entered input is not a double value ");
    }
  }
}
