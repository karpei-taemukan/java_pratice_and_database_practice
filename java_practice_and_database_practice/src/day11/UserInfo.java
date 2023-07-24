package day11;

public class UserInfo {

public UserInfo(String userId, String userPw, String userName, String userPhone) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userPhone = userPhone;
	}
String userId;
String userPw;
String userName;
String userPhone;

boolean loginChecked(String loginId, String loginPw) {
	boolean result = false;
	if((loginId).equals(this.userId) && (loginPw).equals(this.userPw)) {
	System.out.println("MATCH");
	return !result;
	}
	else {
		System.out.println("NOT MATCH");
	return result;
	}
}

public void showInfo() {
	System.out.println("ID: "+this.userId+" P.W: "+this.userPw+" NAME: "+this.userName+" PHONE: "+this.userPhone);
}

@Override // 재정의
public String toString() {
	return "UserInfo [Id=" + userId + ", Pw=" + userPw + ", Name=" + userName + ", Phone=" + userPhone
			+ "]";
}

}