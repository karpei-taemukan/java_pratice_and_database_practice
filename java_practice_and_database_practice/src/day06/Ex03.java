package day06;

import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean run = true;
		while(run) {
			
			System.out.println("enter the number");
			int inputnum = scan.nextInt();
			System.out.println("input number: " + inputnum);
			//if(inputnum == 0) {
		//		break; // while문을 중지시킨다
		//	}
			switch (inputnum) {
			case 0:
				run=false;
				break; // switch 문을 중지시킨다
			}
		}
	}

}
