package day16_1;

public class Student extends Person{
	
	String univName;
	String major;
	

	public Student() {
		
	}
	
	public Student(String name, int age, String addr) {
	super(name, age, addr);
	}

	public Student(String name, int age, String addr, String uni, String maj) {
	super(name, age, addr);
	this.univName = uni;
	this.major=maj;
	}
	public void myjob() {
		System.out.println("STUDENT");
	}
}
