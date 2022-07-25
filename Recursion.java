import java.util.*;
public class Recursion{
	
	public static void main(String[] args){
		System.out.println(sumOfNaturalNumber(10));
		System.out.println(factorial(10));
		System.out.println(sumOfDigits(1011));
		System.out.println(powerOfNum(-2,12));
	}
	
	public static int sumOfNaturalNumber(int x){
		if(x==0){
			return 0;
		} else{
			return x+sumOfNaturalNumber(x-1);
		}
		
	}
	
	public static int factorial(int x){
		if(x==1||x==0){
			return 1;
		} else {
			return x*factorial(x-1);
		}
	}
	
	public static int sumOfDigits(int x){
		if(x<=0){
			return 0;
		} else {
			return (x%10)+sumOfDigits(x/10);
		}
	}
	
	public static int powerOfNum(int x, int pow){
		if(pow==0){
			return 1;
		}else {
			return x*powerOfNum(x,pow-1);
		}
	}
	
}