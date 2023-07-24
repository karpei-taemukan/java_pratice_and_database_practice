package day05;

import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Start Number");
		int startNum = scan.nextInt();
		System.out.println("End Number");
		int endNum = scan.nextInt();
		int sum=0;
		
		for(int i=startNum; i<=endNum; i++){
			System.out.println(i+" ");
			if(i%3!=0) {
				continue;
			}
			sum+=i;
		}
		System.out.println("\nFinish");
		System.out.println("sum: "+ sum);
	}

}
