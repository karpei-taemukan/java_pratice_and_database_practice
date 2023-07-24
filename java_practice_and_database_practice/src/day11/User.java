package day11;

public class User {
String id;
String pw; 

public User() {
	
}
public User(String st1, String st2) {
this.id = st1; 
// 				User user = new User("qq","ww") 
//       ==> this.id => "qq"         ==> this.pw => "ww" 
this.pw = st2;
System.out.println(this.id+"\n"+this.pw);

}



}