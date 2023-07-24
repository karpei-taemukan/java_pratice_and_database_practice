package jdbcShop;

public class Goods {
	private String gname;
	private int gprice;
private String gcode;
private String gtype;
private int gstock;
private String gstate;
public String getGstate() {
	return gstate;
}
public String getGcode() {
	return gcode;
}public String getGname() {
	return gname;
}public int getGprice() {
	return gprice;
}public int getGstock() {
	return gstock;
}public String getGtype() {
	return gtype;
}
public void setGstate(String gstate) {
	this.gstate = gstate;
}
public void setGcode(String gcode) {
	this.gcode = gcode;
}
public void setGname(String gname) {
	this.gname = gname;
}public void setGprice(int gprice) {
	this.gprice = gprice;
}public void setGstock(int gstock) {
	this.gstock = gstock;
}public void setGtype(String gtype) {
	this.gtype = gtype;
}
}
