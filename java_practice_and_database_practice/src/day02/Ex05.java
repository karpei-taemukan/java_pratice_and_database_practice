package day02;

import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	
	int coffeePrice = 3000;
	
	boolean bool = true;
	
	
	while(bool) {
		
		System.out.print("가진 돈 입력: ");
		
		int money = scan.nextInt();
		
		int rest = money - coffeePrice;
		
		if(money==0) {bool=false;}
		if(money<3000) {System.out.println("잔액부족"); bool=false;}
		else {
		System.out.println("잔액: "+ rest);
		System.out.print("재주문?");
		String str = scan.next();
		if("네".equals(str)) {
			System.out.println("잔액: "+ rest);
		}
		
		else if("아니오".equals(str)) {bool=false;}
		
		}
		

	
	}
	}

}
