package day16;

public class Child extends Parent{
// 재정의
	
	
	@Override// 상속받은 클래스를 재정의
	
	void parentMethod() {
		System.out.println("자식 클래스에 정의된 parentMethod()");
	}

	
	/*	오버 라이드 됌, 단지 호출을 안함
	 * int testMethod() {
		System.out.println("testMethod() 호출");
		return 1;
	}
	 * 
	 * */
	
	// 오버 로딩 
	int testMethod(int num) {
		System.out.println("testMethod() 호출");
		return num+1;
		
	}
	
void childMethod() {
	System.out.println(protectedField);
	System.out.println(defaultField);
}
	
}