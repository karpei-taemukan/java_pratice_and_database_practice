package day15;

import java.util.ArrayList;

public class Ex_ArrayList01 {

	public static void main(String[] args) {
ArrayList<String> strList = new ArrayList<String>();
	strList.add("A");
	strList.add("B");
	strList.add("C");
	System.out.println("0 index: "+ strList.get(0));
	System.out.println("1 index: "+ strList.get(1));
	System.out.println("2 index: "+ strList.get(2));
	System.out.println("size: "+ strList.size());

	strList.add(1, "D");
	strList.add(4, "E");
	System.out.println("size: "+ strList.size());
	for(int i=0; i<strList.size(); i++)
	{
	System.out.println("index: "+ strList.get(i));
	}
	System.out.println(strList.size());

	System.out.println();
	
	strList.remove("B"); // index를 삭제함으로써 배열요소들이 한 칸씩 땡겨진다 
	
	for(int i=0; i<strList.size(); i++)
	{
	System.out.println("index: "+ strList.get(i));
	}	
	
	System.out.println(strList.get(2));
	System.out.println(strList.size());
	
	
	ArrayList<Member> memList = new ArrayList<Member>();
	Member[] memArr = new Member[5];
	
	System.out.println("ArrayList start");
	for(int i=0; i<memList.size(); i++) { // 사이즈가 0이므로 에러는 나지않는다
		System.out.println(memList.get(i).getId());
	}
	
	System.out.println("Array start");
	for(int i=0; i<memArr.length; i++) { // 길이가 0 => null 이다 null 에러난다
		System.out.println(memArr[i].getId());
	}
}
}