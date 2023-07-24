package day11;

public class Method {
	
// void : return값이 없는 메소드
// 타입 : 해당 타입의 값을 return 하는 메소드
	/*	메소드타입 메소드이름(매개변수1, 매개변수2 ...){
	 * 
	 * }
	 * */
	int intVal;
public Method() {
	
}
void voidMethod() {
	System.out.println("call voidMethod()");
}
int intMethod() {
System.out.println("call intMethod()");
return 10;
}

void upCount1() {
intVal++;
}

int upCount2(int num) {
	for(int i=0; i<=6; i++) {
		num+=i;
	}
	return num;
}
}
