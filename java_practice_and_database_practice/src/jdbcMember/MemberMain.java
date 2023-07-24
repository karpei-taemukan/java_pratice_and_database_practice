  package jdbcMember;

import java.util.Scanner;

public class MemberMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		boolean run = true;
				
		MemberService msvc = new MemberService();
		while (run) {
			//메뉴출력 
			System.out.println("로그인 아이디: "+ msvc.getLoginId());

			if(msvc.getLoginId() == null) {
				System.out.println("[1]회원가입 [2]로그인"); // 로그인을 되지 않았을 경우 출력
			}

			else {
				System.out.println("[1] 정보확인 [2] 로그아웃");
				
			}
			
			System.out.println("메뉴선택>>");
			//메뉴선택
			int selectMenu = scan.nextInt();
			
			//선택된 메뉴 호출 

			switch (selectMenu) {
			case 1:
				// 로그인 되지 않았을 경우 -> 회원 가입 기능 호출
				
				if(msvc.getLoginId() == null) {
					msvc.memberJoin(); // 회원 가입 기능					
				}
				else {
					// 정보확인 기능 호출
					
					//msvc.memberSelect();
				}
				break;
			case 2:
				if(msvc.getLoginId() == null) {
				msvc.memberLogin();
				}
				else {
				// 로그아웃 기능 호출 	
				msvc.memberLogout();
				}
				break;
				
			default:
			run=false;
			}
		}
	}

}
