package day02;

import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		/* Scanner 클래스 */
	Scanner scan =       new               Scanner(System.in);
//   타입   객체이름  메모리에 객체정보올림             생성자	

	System.out.print("enter string  ");
	String s = scan.nextLine();
	System.out.println(s);
		
	System.out.print("enter integer  ");
	int b = scan.nextInt(); // 정수를 입력받는 기능
	System.out.println(b);
 
}
}