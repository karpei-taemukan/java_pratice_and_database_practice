package day12;

public class MemberInfo {

/* 회원정보 
 * 아이디, 비밀번호, 이름, 전화번호 
 * */
	
	
	/*
	 
	 * public MemberInfo(String mid, String mpw, String mname, String mnumber) {
		super();
		this.mid = mid;
		this.mpw = mpw;
		this.mname = mname;
		this.mnumber = mnumber;
	}
	 * 
	 * */
	
	
private String mid;
private String mpw;
private String mname;
private String mnumber;
private MemberInfo arr[];


public String getMid() {
	return mid;
}

public String getMname() {
	return mname;

}
public String getMnumber() {
	return mnumber;
}
public String getMpw() {
	return mpw;
}
public void setMid(String mid) {
	this.mid = mid;
}
public void setMname(String mname) {
	this.mname = mname;
}
public void setMnumber(String mnumber) {
	this.mnumber = mnumber;
}
public void setMpw(String mpw) {
	this.mpw = mpw;
}

//--------------------------------------------------------------


public String overlapId(String Istr,String memList[]) {
	boolean check = true;
	for(int i=0; i<memList.length; i++) {
		if((Istr).equals(memList[i])) {
			return "SUCCESS";
		}
	
		else { 	
			while(check) {
				if((Istr).equals(memList[i])) {
					check=false;
				}
			}
			return Istr;
		}
	}
	return Istr;
}




}
