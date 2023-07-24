package day06;

import java.util.Scanner;

public class EExx04 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
	loopWhile:
	while(true) {
			
			System.out.println("enter the number");
			int inputnum = scan.nextInt();
			System.out.println("input number: " + inputnum);
	
			switch (inputnum) {
			case 0:
				break loopWhile; // loopWhile이라는 라벨의 while을 중지시킨다
			}
		}

	}

}
