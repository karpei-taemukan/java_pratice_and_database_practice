package day02;

public class Ex01 {

	public static void main(String[] args) {
/*                 연산자
 *              = + - / % *
 * */
		
		int num1;
		num1 = 10;
		
		int num2=2;
		int num3=3;
		num2 = 20;
		num3 = num3 + 30;
		// 1. num3 + 30 => 3 + 30 
		// 2. num3=33;
		System.out.println(num2);
		System.out.println(num3);
		
		int score = 80;
		
		int result;
		
		result = score + 10;
		System.out.println("+ "+result);
		
		result = score - 20;
		System.out.println("- "+result);
		
		result = score * 30;
		System.out.println("* "+result);
		
		result = score / 40;
		System.out.println("/ "+result);
		
		result = score % 50;
		System.out.println("% "+result);
	}

}
