package jdbcMember;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberService {

	MemberDao mdao = new MemberDao();
	public void memberJoin() {

		System.out.println("회원가입");
		//1. 가입할 회원 정보 입력
			// 아이디 중복 확인 (select)
		Scanner scan = new Scanner(System.in);
		System.out.println("등록할 아이디 입력: ");
		String inputMid=scan.next();
		// 아이디 중복 확인 
		
		String duplicateMid = mdao.select_idCheck(inputMid);
		
		if(duplicateMid != null) {
			System.out.println("사용할 수 없는 아이디");
			System.out.println("회원가입 다시 시도하라");
			return;
		}
		
		System.out.println("등록할 비밀번호 입력: ");
		String inputMpw=scan.next();
		System.out.println("등록할 이름 입력: ");
		String inputMname=scan.next();
		System.out.println("등록할 전화번호 입력: ");
		String inputMphone=scan.next();
		System.out.println("등록할 생년월일 입력: ");
		String inputMbirth=scan.next();
		//2. 회원정보를 Members 테이블에 insert 
		
		Member mi = new Member();
		mi.setMid(inputMid);
		mi.setMpw(inputMpw);
		mi.setMname(inputMname);
		mi.setMphone(inputMphone);
		mi.setMbirth(inputMbirth);
		
		
		
		int insertResult = mdao.insertMember(mi);
		if(insertResult > 0) {
			System.out.println("새 회원정보가 등록됨");
		}
		else {
			System.out.println("새 회원정보가 등록 실패");
		}
		
		
	/*	ArrayList<Member> mList = mdao.selectMember();
		
		//3. insert 결과 출력
		if(mList.size() <=0) {
			System.out.println("검색된 연락처가 없습니다");
		}
		for(int i=0; i<mList.size(); i++) {
			System.out.println(mList.get(i).getMid());
			System.out.println(mList.get(i).getMpw());
			System.out.println(mList.get(i).getMname());
			System.out.println(mList.get(i).getMphone());
			System.out.println(mList.get(i).getMbirth());
		}*/
	}
	private String loginId = null; // 로그인 중인 아이디 저장 

	public String getLoginId() {
		return loginId;
	}

	public void memberLogin() {

		Scanner scan = new Scanner(System.in);

		System.out.println("로그인");
		// 1. 아이디입력,비밀번호 입력
		System.out.println("아이디 입력");
		String inputMid = scan.next();
		System.out.println("비밀번호 입력");
		String inputMpw=scan.next();
		
		// 2. 일치하는 회원정보가 있는 지 조회
		Member loginMember=mdao.select_login(inputMid,inputMpw);
		System.out.println(loginId);
		if(loginMember != null) 
		{
		System.out.println("로그인 성공");
		loginId = loginMember.getMid();
		}
		else {
			
		System.out.println("아이디 비밀번호 불일치");
		System.out.println("로그인 실패");
		}
		// 3. 로그인 처리 
		
	}

	public void memberLogout() {
		loginId=null;
		System.out.println("로그아웃됨");
	}

}
