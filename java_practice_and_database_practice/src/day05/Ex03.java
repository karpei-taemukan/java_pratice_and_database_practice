package day05;

import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		int k;
		int sum=0;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("input number");
		
		int StartNum = scan.nextInt();
		int EndNum = scan.nextInt();
		
		for(k=StartNum; k<=EndNum; k++) {
			sum+=k;
			
		}
		   System.out.println();
		   
		System.out.println(sum);
	}

}
