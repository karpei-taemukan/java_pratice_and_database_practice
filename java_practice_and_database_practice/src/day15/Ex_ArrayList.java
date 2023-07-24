package day15;

import java.util.ArrayList;

public class Ex_ArrayList {

	public static void main(String[] args) {

		Member [] memArr = new Member[10]; // 회원목록 배열
		
		Member member01 = new Member();
		memArr[0]=member01;
		
		Member member02 = new Member();
		memArr[1]=member02;
		System.out.println("array size: "+ memArr.length);
		
	ArrayList<Member> memList = new ArrayList<Member>();

	Member mem01 = new Member();
	mem01.setId("id01");
	mem01.setPw("pw01");
	memList.add(mem01);
	System.out.println("ArrayList size: "+memList.size());
	
	Member mem02 = new Member();
	mem02.setId("id02");
	mem02.setPw("pw02");
	memList.add(mem02);
	System.out.println("ArrayList size: "+memList.size());
	
	System.out.println(memList.get(0).getId());
	System.out.println(memList.get(1).getId());
	System.out.println("ArrayList size: "+memList.size());

	}
}
