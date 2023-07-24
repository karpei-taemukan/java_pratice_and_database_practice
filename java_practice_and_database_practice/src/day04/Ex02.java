package day04;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);
			System.out.println("[1] americano  [2] vanilla latte");
			System.out.println("select menu");
			int selectMenu = scan.nextInt();
			
			switch(selectMenu) {
			case 1:
				System.out.println("americano");
				break;
			case 2:
				System.out.println("vanilla latte");
				break;
			default: 
				System.out.println("wrong input");
			}
			
			System.out.println();
			
			int num1 = 10;
			if(num1 == 10) {
				int num2 = 20;
				System.out.println("if -> num2: " + num2);
			}
			else {
				int num2 = 20;
				System.out.println("else -> num2: " + num2);
			}
			
			System.out.println();
			
			int num3 = 10;
			
			switch(num3) {
			case 10:
				int num2 = 20;
				System.out.println(num2);
				break;
			default: 
				num2 = 50;
				System.out.println(num2);
			}
			
			
	}

}
