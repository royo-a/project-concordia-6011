package TestSrc;

import java.util.Scanner;
/**
 * SOEN 6011 F5 = ab^x
 * @author Shagun Shagun
 *
 */
public class Function5 {
	
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter value for a = ");
		String a = sc.next();
		a = checkValid(a);
		while(a == null) {
			System.out.println("Please enter value for a = ");
			a = sc.next();
			a =checkValid(a);
		}
		System.out.println("Please enter value for b = ");
		String b = sc.next();
		b = checkValid(b);
		while(b == null) {
			System.out.println("Please enter value for b = ");
			b = sc.next();
			b =checkValid(b);
		}
		System.out.println("Please enter value for x = ");
		String x = sc.next();
		x = checkValid(x);
		while(x == null) {
			System.out.println("Please enter value for x = ");
			x = sc.next();
			x =checkValid(x);
		}
//		function5or6("2","2","3");
		String result =  "Result is " + function5or6(a,b,x);
		
	}

}
