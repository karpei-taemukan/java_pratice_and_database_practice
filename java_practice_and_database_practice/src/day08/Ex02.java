package day08;

import java.util.Iterator;
import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		Scanner scans = new Scanner(System.in);
		System.out.println("과목수 입력>>");
		int size = scans.nextInt();
		int[] scores =new int[size];
		for(int i=0; i< scores.length; i++) {
			System.out.println((i+1)+"번째 과목의 점수");
			scores[i] = scans.nextInt(); 
		}
		for(int i=0; i< scores.length; i++) {
		System.out.println("Score [" + i +"]: " + scores[i]);
	}
		int max=scores[0];
		int min=scores[0];
		
		
		for(int i=0; i<scores.length; i++) {
			if(max < scores[i]) {
				max=scores[i];
			}
			if(min > scores[i]) {
				min=scores[i];
			}
			
			
		}
		
		
		System.out.println(max);
		System.out.println(min);
		
	}

}
