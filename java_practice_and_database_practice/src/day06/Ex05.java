package day06;

import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int coffeeStock = 10;
		int coffeePrice = 300;
		
		while(true) {
		System.out.println("input money");
		int money = scan.nextInt();
		if(money==coffeePrice) {
			coffeeStock-=1;
		}
		else if(money > coffeePrice) {
		coffeeStock-=1;
		 money-=coffeePrice;
		 System.out.println(money);
		}
		else {
			System.out.println("no money");
		}
		if(coffeeStock<=0) {
			System.out.println("no stock");
			break;
			
		}
		}
	}

}
