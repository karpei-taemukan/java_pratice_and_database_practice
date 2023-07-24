package day12;

public class MemberMain {

	public static void main(String[] args) {
		
		Member member = new Member("ABC", "12");
		  
		  System.out.println(member.getId());
		  member.setId("@#");
		  System.out.println(member.getId());
	}
}
