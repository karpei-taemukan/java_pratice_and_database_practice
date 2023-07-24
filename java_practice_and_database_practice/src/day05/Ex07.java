package day05;

public class Ex07 {

	public static void main(String[] args) {
		/* 1. 1~30번 학생
		 * 2. 짝수번 홀수번 학생으로 나눔
		 * 3. 짝수: 통새우와퍼세트->9700, 홀수: 와퍼세트-> 8900원
		 * 	  5의 배수인 학생인 경우 -> 와퍼주니어 -> 6600원 // 5 10 15 20 25 30
		 * 		 * 4. 통새우와퍼세트의 총액, 와퍼세트의 총액
		 * */
		int oddSt=0;
		int evenSt=0;
		int fiveSt=0;
		
		for(int i=1; i<=30; i++) {
		
			
			if(i%2==0) {
				evenSt+=1;	
			//evenSt=evenSt+9700;
			if(i%5==0) {
				fiveSt+=1;
				//System.out.println(i);
			}
			}
			else {
				oddSt+=1;
				//oddSt=oddSt+8900;
				if(i%5==0) {
					fiveSt+=1;
					//System.out.println(i);
				}
			}
		}
		System.out.println("통새우와퍼세트 고른 학생 수 "+(evenSt-fiveSt));
		System.out.println("와퍼세트 고른 학생 수 "+(oddSt-fiveSt));
		System.out.println("와퍼세트 고른 학생 수 "+fiveSt);
		System.out.println("통새우와퍼버거세트의 총액: "+ (evenSt-fiveSt)*9700/*evenSt*/);
		System.out.println("와퍼세트의 총액 " + (oddSt-fiveSt)*8900/*oddSt*/);
		System.out.println("와퍼주니어의 총액 " + fiveSt*6600);
	}
}