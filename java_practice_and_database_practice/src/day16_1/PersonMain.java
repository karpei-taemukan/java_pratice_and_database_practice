package day16_1;

public class PersonMain {

	public static void main(String[] args) {
	Person per = new Person("ABC",23,"qwe");
		
	
	Student stu = new Student("ABC", 23, "qwe", "uni", "maj");
	
	
	
	Developer dev = new Developer("ABC", 23, "qwe", "uni", "maj","Java","lA");
	
	per.myjob();
	stu.myjob();
	dev.myjob();
	PersonService psvc = new PersonService();
	psvc.choiceType(per);
	psvc.choiceType(stu);
	psvc.choiceType(dev);
	}
	
Person personStu = new Student();
Person personDev = new Developer(null, 0, null, null, null, null, null);

}
