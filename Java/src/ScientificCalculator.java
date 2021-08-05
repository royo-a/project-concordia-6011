import java.util.*;
public class ScientificCalculator {
	
	public static void function1or2() {
		
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
			System.out.println("\nDetails of tan(x)");
			function1or2();
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
