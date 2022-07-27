import java.util.*;
public class Recursion{
	
	public static void main(String[] args){
		System.out.println(sumOfNaturalNumber(10));
		System.out.println(factorial(10));
		System.out.println(sumOfDigits(1011));
		System.out.println(powerOfNum(-2,12));
		System.out.println(taylorSeries(1,10));
		System.out.println(taylorSeriesUsingHomerRuleIterative(1,10));
		System.out.println(taylorSeriesUsingHomerRuleRecursion(1,10));
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
	
	private static int fact=1;
	private static int pow=1;
	
	public static double taylorSeries(int e, int x){
		if(x==0){
			return 1;
		} else {
			double result = taylorSeries(e,x-1);
			fact*=x;
			pow*=e;
			return result + (double)pow/fact;
		}
	}
	
	//Taylor series using homer's rule-Iterative Version
	
	private static double sumOfTaylor=1;
	public static double taylorSeriesUsingHomerRuleIterative(int x, int n){
		for(;n>0;n--){
			sumOfTaylor=1+((double)x/n)*sumOfTaylor;
		}
		return sumOfTaylor;
	}
	
	//Taylor series using homer's rule-Recursive Version
	
	private static double sumOfTaylorRecursion=1;
	public static double taylorSeriesUsingHomerRuleRecursion(int x, int n){
		if(n==0){
			return sumOfTaylorRecursion;
		} else {
			sumOfTaylorRecursion=1+((double)x/n)*sumOfTaylorRecursion;
			return taylorSeriesUsingHomerRuleRecursion(x,n-1);
		}
	}
	
}