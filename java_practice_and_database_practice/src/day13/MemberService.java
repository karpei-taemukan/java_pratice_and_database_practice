package day13;

import java.util.Scanner;

public class MemberService {
		/*기능 정의 클래스*/

	Scanner scanner = new Scanner(System.in);
	
	Member[] memberList = new Member[3];
	// 메뉴 출력 기능 메소드
	boolean check = true;
	
//======================================================
	
	public void showMenu() {
	System.out.println("[1] 회원 가입 [2] 로그인 [3] 종료");	
	System.out.println("메뉴를 선택하세요");
	}

	
//======================================================
	
	// 회원가입 기능 메소드
	public void memberJoin() {
		System.out.println("[1] 회원가입");
		
		// 3. 회원 목록에 저장

		int idx = -1;
		
		for(int i=0; i<memberList.length; i++) {
			if(memberList[i] == null) { // 배열이 꽉찼다는 건 인덱스를 더이상 반복 불가 
				idx=i;
				break;
			}
		}
		if(idx == -1) { 
			System.out.println("더이상 회원 가입을 할 수 없습니다.");
			return; // void 메소드는 return;으로 메소드 중지 가능 
		}
		// 회원 가입 처리
		
		// 1. 가입정보 입력
		System.out.println("생성할 아이디 입력: ");
		String inputId = scanner.next();
		
		// 아이디 중복확인 기능 메소드
		for(int i=0; i<memberList.length; i++) {
			if(memberList[i]!=null) {
		if((inputId).equals(memberList[i].getMid())) {
			System.out.println("중복된 아이디");
			return;
			
		}
		}}
		System.out.println("생성할 비밀번호 입력: ");
		String inputPw = scanner.next();
		System.out.println("생성할 이름 입력: ");
		String inputName = scanner.next();
		
		// 2. 입력된 정보를 하나로 모으고
		Member mem = new Member();
		
		mem.setMid(inputId);
		mem.setMname(inputName);
		mem.setMpw(inputPw);
		
		memberList[idx] = mem;
		// id, pw, name을 클래스에 저장한뒤, 그 클래스에 있는  id pw name을 같은 인덱스에 
		// 저장할 수 있다 이유는 호출할땐 각각 id pw name 의 호출메소드가 따로따로 존재하기 때문이다 
		
		//System.out.println(memberList[0].getMid());
		//System.out.println(memberList[0].getMpw());
		//System.out.println(memberList[0].getMname());
		//System.out.println("가입됨");
		
	}
	
//======================================================	
	
	
	// 로그인 기능 메소드 
	
	public void memberLogin() {
		System.out.println("[로그인]");
		// 1. 로그인할 아이디 입력
		// 2. 입력한 값과 일치하는 회원 정보 검색
		// 3. 일치하는 회원이 있을 경우 id,pw,name 출력
		// 불일치 회원 not match id,pw,name 출력
		System.out.println("아이디 입력: ");
		String loginId = scanner.next();
		System.out.println("비밀번호 입력: ");
		String loginPw = scanner.next();
		
		int idx = -1;
		
		for(int i=0; i<memberList.length; i++) {
			if(memberList[i] != null) {
			if(loginId.equals(memberList[i].getMid())
					&&
					loginPw.equals(memberList[i].getMpw())) {
				System.out.println("로그인 성공");
				System.out.println("아이디: "+memberList[i].getMid());
				System.out.println("비밀번호: "+memberList[i].getMpw());
				System.out.println("이름: "+memberList[i].getMname());
				idx = i;				
			break;
			}
			
			else {
				System.out.println("NOT MATCH");
				break;
			}
		}
			else {
				System.out.println("가입자가 아님");
				memberJoin();
				return;
			}
		}
	/*	if(idx > -1) {
			System.out.println("로그인 성공");
			System.out.println("아이디: "+memberList[idx].getMid());
			System.out.println("비밀번호: "+memberList[idx].getMpw());
			System.out.println("이름: "+memberList[idx].getMname());
		}
		else {
			System.out.println("아이디/비밀번호 불일치");
		}
		*/
	}
	
//======================================================	
	
}
