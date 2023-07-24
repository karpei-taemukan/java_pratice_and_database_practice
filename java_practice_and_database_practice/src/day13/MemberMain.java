package day13;


public class MemberMain {

	public static void main(String[] args) {
	
		boolean run = true;
		
		MemberService memsvc = new MemberService();
		
		while(run) {
			// 메뉴 출력 기능 메소드 호출
			memsvc.showMenu();
			
			// 메뉴 선택 
		
			int selectMenu = memsvc.scanner.nextInt();
			
			switch(selectMenu) {
			case 1:
				memsvc.memberJoin();
				break;
			// 회원가입 기능 메소드 호출
				
			case 2:
				memsvc.memberLogin();
				break;
			// 로그인 기능 매소드 호출 
			
			default:
				run = false;
			}
			 
		}
	}

}
