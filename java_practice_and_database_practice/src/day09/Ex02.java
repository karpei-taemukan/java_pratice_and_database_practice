package day09;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		 Scanner scan = new Scanner(System.in);
		 String menulist[] = {"[0] end order:0","[1] americano:2000", "[2] vanilla latte:3500", "[3] ice tea:3000"};
		 
		 String s0[] = menulist[0].split(":"); 
		 String Ts0 = s0[0]; // "[0] end order"
		 int Is0 = Integer.parseInt(s0[1]); // "0" => 0
		 
		 
		 
	}

}
