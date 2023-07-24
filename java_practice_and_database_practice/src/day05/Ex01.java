package day05;

public class Ex01 {

	public static void main(String[] args) {
			/* 반복문 - for문
			 * for(int i=0; i < 10; i++){
			 * 		조건식	조건식 	증감식	
			 * 		i가 10보다 작을때 반복실행
			 * }
			 * */
		
		for(int i=0; i<11; i++) {
			System.out.println("i = " + i);
			/* 1. int i = 0 초기화식
			 * 2. i < 5; 조건 확인
			 * 3. System.out.println("i = " + i); 실행
			 * 4. i++ 증가식 실행 i=0 => i=1
			 * 5. i < 5; 조건 확인
			 * 6. System.out.println("i = " + i); 실행
			 * 7. 만약 i 가 5라면 -->i<5;가 false 반복문 종료
			 * */
		}	
		
	}

}
