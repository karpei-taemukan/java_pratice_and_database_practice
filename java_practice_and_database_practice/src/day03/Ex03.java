package day03;

import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
	/*	Scanner scan = new Scanner(System.in);
		System.out.println("[1] americano(2000) [2] vanilla latte(3500)");
		System.out.print("money?");
		int money = scan.nextInt();
		System.out.print("select menu?");
		int selectMenu = scan.nextInt();
		if(selectMenu==1) {
			System.out.println("[1] americano(2000)");
			money-=2000;
		}
		else if(selectMenu==2){
		System.out.println("[2] vanilla latte(3500)");
		money-=3500;
		}
		System.out.println("balance: " + money);
		
		while(money >= 2000) {
			System.out.print("select menu?");
			int selectMenu1 = scan.nextInt();
			if(selectMenu1==1) {
				System.out.println("[1] americano(2000)");
				money-=2000;
			}
			else if(selectMenu1==2){
			System.out.println("[2] vanilla latte(3500)");
			money-=3500;
			}
			System.out.println("balance: " + money);
		}
		System.out.println("end order"); */
		
		Scanner scan = new Scanner(System.in);
		System.out.println("[1] americano(2000) [2] vanilla latte(3500)");
		
		System.out.print("select menu?");
		int selectMenu = scan.nextInt();
		boolean menuCheck = true;
		
	
			while(selectMenu != 1 && selectMenu != 2) {
				System.out.println("[1] americano(2000) [2] vanilla latte(3500)");
				
				System.out.print("select menu?");
				int selectMenu1 = scan.nextInt();
				if(selectMenu1 == 1 && selectMenu1 == 2) {
					break;
				}
				break;
				
			}
		
		/*
		 * int coffeePrice = 0;
		 * 
		 * if(selectMenu==1) {
			System.out.println("[1] americano(2000)");
		}
		
		else if(selectMenu==2){
		System.out.println("[2] vanilla latte(3500)");
		}
		
		else {
		System.out.println("wrong choice");
		menuCheck = false;
		}
		if(menuCheck){
		System.out.println("[1] card only [2] cash only");
		int pay = scan.nextInt();
		
		if(pay==1) {
		System.out.println("end payment");
		}
		
		if(pay==2) {
			System.out.print("money?");
			int money = scan.nextInt();
			System.out.println("balance: " + (money-coffee));
			}

		System.out.println("end order");
		}}
		}
		 * */
		if(menuCheck) {
		System.out.println("[1] card only [2] cash only");
		int pay = scan.nextInt();
		
		if(pay == 1) {
		if(selectMenu==1) {
			System.out.println("[1] americano(2000)");
		}
		else if(selectMenu==2){
		System.out.println("[2] vanilla latte(3500)");
		}
		else {
			System.out.println("wrong choice");
		}
		
		System.out.println("end payment");
		}
		else if(pay == 2) {
			System.out.print("money?");
			int money = scan.nextInt();
			if(selectMenu==1) {
				System.out.println("[1] americano(2000)");
				money-=2000;
			}
			else if(selectMenu==2){
			System.out.println("[2] vanilla latte(3500)");
			money-=3500;
			}
			System.out.println("balance: " + money);
			}

		}
		System.out.println("end order");
	}

}
