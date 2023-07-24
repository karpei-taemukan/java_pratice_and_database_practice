package day04;

import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("input string");
		String strVal = scan.next();
		System.out.println("String Value: " + strVal);
	/*	switch(strVal) {
		case "A":
			System.out.println("Switch A");
			break;
		case "B":
			System.out.println("Switch B");
			break;
		case "C":
			System.out.println("Switch C");
			break;
		default:
			System.out.println("Switch Default");
		}*/
		if(strVal.equals("A")) { 
// strVal == "A" 처럼 String은 참조형 변수 => 메모리 주소 저장 // 메모리에 직접 저장(직접변수) x    
			System.out.println("if A");
			System.out.println(strVal == "A");
			System.out.println(strVal.equals("A"));
		}
		else if(strVal.equals("B")) {
			System.out.println("if B");
			System.out.println(strVal == "B");
			System.out.println(strVal.equals("B"));
		}
		else if(strVal.equals("C")) {
			System.out.println("if C");
			System.out.println(strVal == "C");
			System.out.println(strVal.equals("C"));
		}
		else {
			System.out.println("if Default");
		}
			
	}

}
