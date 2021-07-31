import java.util.InputMismatchException;
import java.util.Scanner;

public class ScientificCalculator {
	
	public static void function1or2() {
		
	}
	
	public static void function3or4() {
			
		}
	
	public static void function5or6() {
		
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
			System.out.println("\nDetails of tan(x)");
			function1or2();
			menu();
		case 2:
			System.out.println("\nDetails of sinh(x)");
			function3or4();
			menu();
		case 3:
			System.out.println("\nDetails of ab^x");
			function5or6();
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
