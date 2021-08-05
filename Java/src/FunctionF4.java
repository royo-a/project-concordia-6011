import java.util.Scanner;

class FunctionF4 {
	public static void gamma() {		
		int number, fact = 1;		
		System.out.print("\nPlease enter the value of x: ");
		Scanner scan = new Scanner(System.in);
		
		number = scan.nextInt();
		
		if (number > 0) {
			for(int i = 1; i < number; i++) {
				fact = fact * i;
			}
			System.out.println("\nResult = " + fact);
		} else {
			System.out.println("\nNumber cannot be negative");			
		}		
	}    
}