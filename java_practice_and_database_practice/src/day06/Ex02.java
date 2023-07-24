package day06;

public class Ex02 {

	public static void main(String[] args) {
		/* while (반복조건){
		 * 반복 실행 부분
		 * }
		 * */
		
		for(int i=0; i<=5; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		int j=0;
		boolean run = true;
		while(run) {
			System.out.print(j+" ");
			j++;
			if(j==5) {
				run =false;
			}
		}
	}

}
