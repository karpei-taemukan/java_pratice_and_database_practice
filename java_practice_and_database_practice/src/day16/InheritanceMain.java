package day16;

public class InheritanceMain {

	public static void main(String[] args) {
		Child chd = new Child();
			chd.parentFiled = "";	
			chd.parentMethod();
	
		Parent prt = new Parent();
		prt.parentMethod();
	int a = 2;
	String q = "@";
	
	ParentClass parent = new ParentClass(a,q);
	ChildClass child = new ChildClass();
	
	}
}