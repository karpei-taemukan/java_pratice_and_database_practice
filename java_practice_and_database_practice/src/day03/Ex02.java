package day03;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		int num=45;
		if(num>50) {
			System.out.println("50 UP");
		}
		else if(num>40){
			System.out.println("40 UP");
		}
		else {
			System.out.println("END");
		}
	System.out.println("-------------------------------------------");
	int num1=100;
	if(num1>50) {System.out.println("50 UP");}
	if(num1>40) {System.out.println("40 UP");}
	if(num1>30) {System.out.println("30 UP");}
	System.out.println("-------------------------------------------");
	
	/*Scanner scan = new Scanner(System.in);
	System.out.println("enter the score");
	int score = scan.nextInt();
	
	if(score >= 90 && score >= 0) {
		if(score>100) {System.out.println("wrong score");}
		if(score>=95 && score <=100) {
		System.out.println("A+");
		}
		else {
			System.out.println("A0");
		}
	}
	else if(score>=80) {
		if(score>=85 && score <=90) {
			System.out.println("B+");
			}
			else {
				System.out.println("B0");
			}
	}
	else if(score>=70) {
		if(score>=75 && score <=80) {
			System.out.println("C+");
			}
			else {
				System.out.println("C0");
			}
	}
	else {
		System.out.println("OUT");
	}*/
	
	Scanner scan = new Scanner(System.in);
	System.out.println("enter the score");
	int score = scan.nextInt();
	String grade = null;
	if(score >= 90 && score >= 0) {
		
		if(score>=95 && score <=100) {
		grade="A+";
		}
		else {
		grade="A0";
		}
	}
	else if(score>=80) {
		if(score>=85 && score <=90) {
			grade="B+";
			}
			else {
				grade="B0";
			}
	}
	else if(score>=70) {
		if(score>=75 && score <=80) {
			grade="C+";
			}
			else {
				grade="C0";
			}
	}
	else {
		System.out.println("OUT");
	}
	System.out.println("SCORE: " + grade);
	
	}

}
