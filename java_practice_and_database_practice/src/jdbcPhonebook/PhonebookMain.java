package jdbcPhonebook;

import java.util.Scanner;

public class PhonebookMain {

	public static void main(String[] args) {
		
		PhonebookService pbsvc = new PhonebookService();
		Scanner scan = new Scanner(System.in);
		
		
		boolean run = true;
		
		while(run){

			// 메뉴 출력
			System.out.println("[1]등록 [2]조회 [3] 수정 [4] 삭제 [5]이름으로 조회");
			System.out.println("메뉴선택>>");
			
			// 메뉴 선택
			int inputNum = scan.nextInt();
			
			// 기능 호출

			switch (inputNum) {
			case 1:
				pbsvc.insertPhoneBook();
				break;

			case 2:
				pbsvc.selectPhoneBook();
				break;
				
			case 3:
				pbsvc.updatePhoneBook();
				break;
			case 4: 
				pbsvc.deletePhoneBook();
				break;
			case 5:
				pbsvc.selectPhonebook_name();
				break;
			default:
				run=false;
			}
			break;
			
		}
	}

}
