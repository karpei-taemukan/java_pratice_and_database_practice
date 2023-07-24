package day07;

public class Ex05 {

	public static void main(String[] args) {
		/*	Array
		 * 	배열선언 같은 타입의 데이터를 하나의 변수에 저장하는 구조 
		 *  타입[] 이름 = {값1, 값2};
		 * 	타입 이름[] = {값1, 값2};
		 * */
	int[] arrNumber = {10, 20};
	int arrNum[] = {30,40};
	System.out.println(arrNum);
	System.out.println(arrNum[1]);
	
	System.out.println(arrNumber.length);
	for(int i=0; i<arrNum.length; i++) {
		System.out.println(arrNum[i]);
	}
	
	int [] number = {11,12,13,14,15};
//		| 11 | 12 | 13 | 14 | 15 |	
//index	  [0]  [1]	[2]  [3]  [4]
	int [] numArr = new int[5];
	System.out.println(numArr[0]);
	//  |	 |    |    |	|	 |
	// 크기가 5인 int 타입의 배열을 선언
	}
}
