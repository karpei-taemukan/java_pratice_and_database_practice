package day04;

public class Ex01 {

	public static void main(String[] args) {
		/*	조건문 - switch case 
		 * 
		 * 	{} 안은 공통영역
		 * 
		 * 		switch(조건 변수(boolean 타입x)){
		 * 
		 * 			case 변수값1(조건 변수==변수값1):       
		 * 				조건 변수==변수값1 일때 실행		   
		 * 				break;						   
		 * 			case 변수값2(조건 변수==변수값2):	   
		 * 				조건 변수==변수값1 일때 실행				
		 * 				break;
		 * 			case 변수값n(조건 변수==변수값n):
		 * 				조건 변수==변수값n 일때 실행
		 * 				break;
		 * 			default: 		
		 *  			조건변수와 일치 case없을 때 실행
		 * 
		 * 	}
		 * */
			int num=5;
			switch(num) {
			case 5:
				System.out.println("num = 5");
				///break;
			case 1:
				System.out.println("num = 1");
				break;
			default:
				System.out.println("num = null");
			}
	}}
