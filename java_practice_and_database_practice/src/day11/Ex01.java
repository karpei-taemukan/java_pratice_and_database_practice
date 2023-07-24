package day11;

public class Ex01 {

int num;
String name;

// 기본 생성자
public Ex01(){
	this.name="ABC";
	this.num=123;
}
public Ex01(int num) {
	System.out.println("Parameter->1 "+num);
}

// 생성자
public Ex01(int num1, int num2) {
	System.out.println("Parameter->2 "+num1+num2);
}

public Ex01(int num1, String str) {
	System.out.println("Parameter->2 "+num1+str);
}
}
