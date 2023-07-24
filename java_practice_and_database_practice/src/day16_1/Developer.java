package day16_1;

public class Developer extends Person {

	
	String lanType;
	String company;

	public Developer(String name, int age, String addr,String uni, String maj, String lan, String com) {
		super(name, age, addr);
		
		this.lanType = lan;
		this.company = com;
		}
	public void myjob() {
		System.out.println("DEVELOPER");
	}
}
