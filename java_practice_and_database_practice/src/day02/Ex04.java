package day02;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("enter first integer  ");
		int num1 = scan.nextInt();
		System.out.print("enter second integer  ");
		int num2 = scan.nextInt();
		
		System.out.println();
		System.out.println("+:"+(num1+num2));
		System.out.println("-:"+(num1-num2));
		System.out.println("*:"+(num1*num2));
		System.out.println("/:"+(num1/num2));
		
	}

}
