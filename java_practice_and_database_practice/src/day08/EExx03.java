package day08;

import java.util.Scanner;

public class EExx03 {

	public static void main(String[] args) {
		/* 과목수 배열 생성
		 * 성적 입력
		 * 모든 과목의 성적 출력
		 * 성적 분석 (총점 평균 최대 최소)
		 * */
	
		Scanner scan = new Scanner(System.in);
		boolean run = true;
		boolean check = true;
		int [] scores = null; // null -> 배열에 index가 없음, 다만 배열의 형태만 가지고 있다
		// int [] scores ==> 메모리를 쓸 예정이다 
		
		
		while(run) {
			System.out.println("[1] 과목수 입력 [2] 성적 입력 [3] 성적 출력 [4] 성적 분석 [5] 종료");
			int selectMenu = scan.nextInt();
			
			if(selectMenu == 1 || scores != null || selectMenu == 5) {
			switch (selectMenu) {
			case 1:
				System.out.println("과목수 입력>> ");
				int subject = scan.nextInt();
				scores = new int[subject];
				check=false;
				break;
			case 2:
			//	if(scores != null) {
					System.out.println("성적 입력>> ");
				for(int i=0; i<scores.length; i++) {
					scores[i]=scan.nextInt();
			//	}
					check=true;
				}
				//else {
			//		System.out.println("과목수 먼저 입력>>");
			//	}
				break;
			case 3:
				//if(scores != null) {
				if(check) {
				System.out.println("성적 출력>> ");
				for(int i=0; i<scores.length; i++) {
					System.out.println(scores[i]); 
				//}
				}
				}
				else {
					System.out.println("성적입력을 한 적이 없습니다");
					System.out.println("성적입력을 해주세요");
					break;
				}
				//else {
				//	System.out.println("과목수 먼저 입력>>");
				//}
				break;
			case 4:
				//if(scores != null) {
				if(check) {
				System.out.println("성적 분석>> ");
				float avg = 0;
				int max=scores[0];
				int min=scores[0];
				
				for(int i=0; i<scores.length; i++) {
					avg = (float)scores[i]/(scores.length);
					if(max < scores[i]) {
					max=scores[i];
					}
					if(min > scores[i]) {
						min=scores[i];
					}
			//	}
				}
				System.out.println("AVG: " + avg);
				System.out.println("MAX: " + max);
				System.out.println("MIN: "+ min);
				//else {
			//		System.out.println("과목수 먼저 입력>>");
			//	}
				break;
				}
				else {
					System.out.println("성적입력을 한 적이 없습니다");
					System.out.println("성적입력을 해주세요");
					break;
				}
			case 5:
				run=false;
				break;
				
			/*default:
				System.out.println("잘못 입력");
				if(selectMenu > 5 || selectMenu < 0) {
					while(true) {
						System.out.println("번호 다시 입력>> ");
						int wrongNumber = scan.nextInt();
						if(!(wrongNumber > 5 || wrongNumber < 0)) {
							break;
						}
					}
					
				}
				break; */
			}
			}
			else {
				System.out.println("잘못 입력");
				if(selectMenu > 5 || selectMenu < 0) {
					while(true) {
						System.out.println("번호 다시 입력>> ");
						int wrongNumber = scan.nextInt();
						if(!(wrongNumber > 5 || wrongNumber < 0)) {
							break;
						}
					}
					
				}
			}
			}
	}
}
