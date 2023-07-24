package day03;

public class Ex01 {

	public static void main(String[] args) {
			/*     		조건문
			 * if(조건1) { 조건1==true	
			 * }
			 * else if(조건2){
			 * 조건1==false && 조건2==true
			 * }
			 * else if(조건3){
			 * 조건1,2==false && 조건3==true
			 * }
			 * else{
			 * 조건1,2,3==false
			 * }
			 * */
			int score = 90;
			if(score >=90) {
				System.out.println("A");
			}else if(score >=80) {System.out.println("B");}
			else {System.out.println("C");}
			
			// 변수 사용범위
			int num1 = 1;
			int num2 = 2;
			
			if(num1 < num2) {
				int num3 = 3;
				System.out.println(num3);
				num2+=2;
				System.out.println(num2);
			}
				System.out.println(num2);
	}

}
