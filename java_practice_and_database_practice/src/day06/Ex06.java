package day06;

import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int coffeeTotal = 0;
		while(true) {
		System.out.println("[1] Americano(2000) [2] Vanilla latte(3500)");
		System.out.println("Select menu");
		int selectMenu = scan.nextInt();
		System.out.println("input money");
		int money = scan.nextInt();
		int coffeePrice = 0;
		switch(selectMenu) {
	
		case 1:
			coffeePrice=2000;
			coffeeTotal+= coffeePrice;
			break;
		case 2:
			coffeePrice=3500;
			coffeeTotal+=coffeePrice;
			break;
		default:
			System.out.println("Wrong choice");
			break;
		}
		System.out.println("Change: " + (money - coffeePrice));
		
		if(coffeeTotal >= 10000) {
			break;
		}

	}
		
	}
}
