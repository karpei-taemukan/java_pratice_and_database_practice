package day11;

public class UserMain {

	public static void main(String[] args) {
		
		String userId01 = "id01";
		String userPw01 = "pw01";
		User user = new User();
		user.id = userId01;
		user.pw = userPw01;
		
		System.out.println("ID: "+user.id);
		System.out.println("PW: "+user.pw);
		
		String str1 = "IDS";
		String str2 = "PWS";
		User user2 = new User(str1, str2);
		System.out.println(user2.id+"\n"+user2.pw);
		
}
}
