package day11;

import java.util.Scanner;

public class Usermains {

	public static void main(String[] args) {
	
	UserInfo info = new UserInfo("ABC", "123", "A1", "010-1234-5678");	
	
	// login function
	// 1. enter ID, P.W
	// 2. match (ID,P.W) ?= userinfo 
	// 3. true, login   false, not login
	
	Scanner scan = new Scanner(System.in);
	
	System.out.println("enter ID");
	String loginId = scan.next();
	System.out.println("enter P.W");
	String loginPw = scan.next();

	boolean loginCheck = info.loginChecked(loginId, loginPw);
	if(loginCheck) {
		System.out.println("LOGIN SUCCESS");
		info.showInfo();
		System.out.println(info);
		//System.out.println("ID: "+info.userId+" P.W: "+info.userPw+" NAME: "+info.userName+" PHONE: "+info.userPhone);
	}

	else {
System.out.println("LOGIN FAIL");
	}
	}
}