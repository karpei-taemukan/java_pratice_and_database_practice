package day09;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		 Scanner scan = new Scanner(System.in);
		 String menulist[] = {"[0] end order","[1] americano(2000)", "[2] vanilla latte(3500)", "[3] ice tea(3000)"};
		 int sales[] = {0,2000,3500,3000};
		 int totalPrice = 0;
		 int totalPrice2 = 0;
		 int size=menulist.length;
		 int orderCount[]=new int[size];
		 
		 
		 menuwhile:while(true) {
			 for(int i=0; i<size; i++) {
			 System.out.println(menulist[i]);
			
			 }
				System.out.print("Select Menu>> ");
				int selectMenu = scan.nextInt();
				 if(selectMenu >= 0 && selectMenu < size) {
					 System.out.println("Selected Menu: " + menulist[selectMenu]);
					 System.out.println("Selected Menu Price: " + sales[selectMenu]);
					 
					 orderCount[selectMenu]=orderCount[selectMenu]+1;
	
					 totalPrice+=sales[selectMenu];
					 if(selectMenu==0) {
						 break menuwhile;
					 }
				 }
				 else {
					 System.out.println("re-choice");
		 }
				 
				 for(int i=0; i<size; i++) {
					if(orderCount[i] >0) {
					 System.out.println(orderCount[i]+"cup");
					 totalPrice2 += orderCount[i]*sales[i];
					 totalPrice = totalPrice2;
				 }
				 }
				 }
		 System.out.println("payment price: " + totalPrice);
	}

}
