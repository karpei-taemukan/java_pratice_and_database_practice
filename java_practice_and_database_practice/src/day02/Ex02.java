package day02;

import java.util.BitSet;

public class Ex02 {

	public static void main(String[] args) {
		
		/*  		비교연산자
		 * 		> < >= <= == != 
		 * */
		
		int num1 = 10;
		int num2 = 20;
		boolean result;
		
		result = num1 > num2;
		System.out.println(num1 + " > " +num2+ " = " + result);
		
		result = num1 < num2;
		System.out.println(num1 + " < " +num2+ " = " + result);
		
		result = num1 >= num2;
		System.out.println(num1 + " >= " +num2+ " = " + result);
		
		result = num1 <= num2;
		System.out.println(num1 + " <= " +num2+ " = " + result);

		result = num1 == num2;
		System.out.println(num1 + " == " +num2+ " = " + result);
	
		result = num1 != num2;
		System.out.println(num1 + " != " +num2+ " = " + result);
		
		/* 			논리연산자 
		 * 			1. AND ( && ) 둘 다 true 이여야 true 
		 * 			2. OR  ( || ) 둘 다 false 이여야 false
		 * 			3. NOT ( ! )  결과값 반대로 만듦
		 * */
			System.out.println("\n AND");
			System.out.println((10 < 20) && (10 > 20) );
			System.out.println("\n OR");
			System.out.println((10 < 20) || (10 > 20));
			System.out.println("\n NOT");
			System.out.println(!(10 < 20));
	
	}
	

}
