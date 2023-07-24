package day12;

import java.util.Scanner;

public class MemberJoin {

	public static void main(String[] args) {
		
	MemberInfo[] memList = new MemberInfo[2]; // 회원정보
	// 회원가입
	// 1.가입정보를 입력
	// 2. 입력된 정보를 MemberInfo의 객체에 저장
	// 3. memList배열에 0~5번 인덱스에 저장
	
	
	MemberInfo mem01 = new MemberInfo();
	MemberInfo mem02 = new MemberInfo();
	//MemberInfo mem03 = new MemberInfo();
//	MemberInfo mem04 = new MemberInfo();
	//MemberInfo mem05 = new MemberInfo();
	
	System.out.println("회원1 정보 입력");
	
	Scanner scanner = new Scanner(System.in);
	
	System.out.println("아이디입력: ");
	String scanId1 = scanner.next();
	mem01.setMid(scanId1);
	
	System.out.println("비밀번호 입력: ");
	String scanPw1 = scanner.next();
	mem01.setMpw(scanPw1);
	
	System.out.println("이름 입력: ");
	String scanName1 = scanner.next();
	mem01.setMname(scanName1);
	
	System.out.println("번호 입력: ");
	String scanNumber1 = scanner.next();
	mem01.setMnumber(scanNumber1);
	

	/*MemberInfo mem01 = new MemberInfo(scanId,scanPw,scanName,scanNumber);*/
	
	memList[0] = mem01;


	System.out.println("회원2 정보 입력");
	
	System.out.println("아이디입력: ");
	String scanId2 = scanner.next();
	mem02.setMid(scanId2);
	
	System.out.println("비밀번호 입력: ");
	String scanPw2 = scanner.next();
	mem02.setMpw(scanPw2);
	
	System.out.println("이름 입력: ");
	String scanName2 = scanner.next();
	mem02.setMname(scanName2);
	
	System.out.println("번호 입력: ");
	String scanNumber2 = scanner.next();
	mem02.setMnumber(scanNumber2);
	
	memList[1] = mem02;
	System.out.println("아이디: "+memList[0].getMid());
	System.out.println("비밀번호: "+memList[0].getMpw());
	System.out.println("이름: "+memList[0].getMname());
	System.out.println("번호: "+memList[0].getMnumber());
	
	System.out.println("아이디: "+memList[1].getMid());
	System.out.println("비밀번호: "+memList[1].getMpw());
	System.out.println("이름: "+memList[1].getMname());
	System.out.println("번호: "+memList[1].getMnumber());
	

	//System.out.println(mem02.overlapId(memList[1].getMid()));
	/*boolean idCheck = true;
	for(int i=0; i<memList.length; i++) {
	if(memList[i] != null) {
		if(scanId2.equals(memList[i].getMid())){
			idCheck=false;
		}
	}
	}*/
	
	
	/*	 memList[2] = mem03;
	memList[3] = mem04;
	memList[4] = mem05;
	*/
	
	}

}
