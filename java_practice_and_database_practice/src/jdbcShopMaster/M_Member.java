package jdbcShopMaster;

public class M_Member {
	// Member
	// 아이디, 비밀번호, 이름, 전화번호, 생년월일
	private String mid;
	private String mpw;
	private String mname;
	private String mphone;
	private String mbirth;
	private String mstate;

	public String getMbirth() {
		return mbirth;
	}public String getMid() {
		return mid;
	}public String getMname() {
		return mname;
	}public String getMphone() {
		return mphone;
	}public String getMpw() {
		return mpw;
	}
	public String getMstate() {
		return mstate;
	}
	public void setMbirth(String mbirth) {
		this.mbirth = mbirth;
	}public void setMid(String mid) {
		this.mid = mid;
	}public void setMname(String mname) {
		this.mname = mname;
	}public void setMphone(String mphone) {
		this.mphone = mphone;
	}public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	public void setMstate(String mstate) {
		this.mstate = mstate;
	}
}
