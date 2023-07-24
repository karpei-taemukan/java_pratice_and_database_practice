package day15;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatch {

	public static void main(String[] args) {
		/*예외처리*/

		Member[] memarr = new Member[3];

		String mid=null;
		
		try {
			/*	실행코드 <= 예외가 발생할 수 있다
			 * */
			mid = memarr[0].getId();
			
		}
		catch(/*에외 상황*/NullPointerException e){
		System.out.println("Exception");
		mid="te:st";
		}
		
		System.out.println("ID: "+mid);
		System.out.println(mid.split(":")[0]);
		
		int num =0;
		try {
		int result = 10/num;
		System.out.println(result);
		System.out.println(memarr[0].getId());
		}
		catch (ArithmeticException e) {
			System.out.println("ArithmeticException Exception");
		}
		catch(NullPointerException e){
			System.out.println("NullPointerException Exception");
			}
		catch (Exception e) {
			System.out.println("All Exception");
		}
		
		
		
		try {
			Scanner scanner  = new Scanner(System.in);
			int scanVal = scanner.nextInt();
			
			
		}
		
		
		catch (InputMismatchException e) {
			System.out.println("only number");
		}
		
	finally {
		System.out.println("must run");
	}		
		
	}

}
