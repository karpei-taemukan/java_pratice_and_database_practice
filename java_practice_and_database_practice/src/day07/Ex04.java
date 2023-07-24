package day07;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String orderList = ""; // 주문한 매뉴이름들이 저장될 변수
		boolean menuOpen = true; 
		int amount = 0;
		int Acup=0;
		int Vcup=0;
		int Icup=0;
		
		while(menuOpen) { // while 문 시작
			System.out.println("[1] americano(2000) [2] vanilla latte(3500) [3] ice tea(3000) [0] end order");
			System.out.print("Select Menu>> ");
			int selectMenu = scan.nextInt();
			switch(selectMenu) { // switch 문 시작 
			case 1:
				System.out.println("ordered [americano] ");
				orderList += "[americano] ";
				amount+=2000;
				Acup++;
				break;
			case 2: 
				System.out.println("ordered [vanilla latte]");
				orderList+="[vanilla latte] ";
				amount+=3500;
				Vcup++;
				break;
			case 3:
				System.out.println("ordered [ice tea]");
				orderList+="[ice tea] ";
				amount+=3000;
				Icup++;
				break;
			case 0:
				System.out.println("[end order]");
				menuOpen=false;
				break;
			default:
			    System.out.println("wrong order");
			} // switch 문 종료
		} // while 문 종료	
		if(orderList != "") {
		System.out.println("ordered menu is ");
		System.out.println("[americano" + " X " + Acup + "]");
		System.out.println("[vanilla latte" + " X " + Vcup + "]");
		System.out.println("[ice teaice tea" + " X " + Icup + "]");
		
		System.out.println("payment amount is "+"$ "+amount);
		}
		else {System.out.println("no ordered menu");}	
	}

}
