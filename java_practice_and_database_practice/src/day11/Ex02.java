package day11;

public class Ex02 {

	public static void main(String[] args) {
		Ex01 ex01 = new Ex01();
	System.out.println(ex01.name); // 초기화가 디폴트이다
	System.out.println(ex01.num);
	System.out.println();
	
	Ex01 ex011 = new Ex01(11);
	
	for(int i=0; i<=3; i++)
	{int num1 = 213;
	int num2 = 432;
	Ex01 ex012 = new Ex01(num1,num2);
	}
	System.out.println();
	Ex01 ex013 = new Ex01(123,"123");
	
	}
}

