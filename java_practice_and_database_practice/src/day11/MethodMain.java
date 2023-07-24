package day11;

public class MethodMain {

	public static void main(String[] args) {

	Method method = new Method();
	method.voidMethod();
	int m = method.intMethod();
	System.out.println(m);
	method.intVal=1;
	method.upCount1();
	System.out.println(method.intVal);
	method.upCount1();
	System.out.println(method.intVal);
	
	int u2 = method.upCount2(method.intVal);
	System.out.println(u2);
	}
}