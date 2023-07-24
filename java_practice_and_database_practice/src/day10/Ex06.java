package day10;

import day10.Ex05;

public class Ex06 {

	public static void main(String[] args) {
		Ex05 ex05 = new Ex05();
		System.out.println(ex05.age);
		System.out.println(ex05.name);
		ex05.printMyInfo();
		
		System.out.println();
		
		ex05.name="ABC";
		ex05.age=123;
		System.out.println(ex05.name);
		System.out.println(ex05.age);
		ex05.printMyInfo();
		
		System.out.println();
		
		Ex05 ex052 =  new Ex05();
		System.out.println(ex052.age);
		System.out.println(ex052.name);
		ex052.printMyInfo();
		System.out.println(ex052.phone);
	}

}
