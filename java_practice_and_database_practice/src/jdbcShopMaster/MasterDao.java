package jdbcShopMaster;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class MasterDao {

	M_Member member = new M_Member();

	
	static Connection getConnection() {
		Connection con  = null;

		String url="jdbc:oracle:thin:@//localhost:1521/xe"; 
	    String userid="jhs_dba"; 
	    String userpw="1212";
	    
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			 con = DriverManager.getConnection(url, userid, userpw);
		
		}
		catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return con;	
	}

	public ArrayList<M_Member> showMembersList() {
		Connection con = getConnection();
	    if(con == null) {
			System.out.println("DB 접속 실패");
			return null;
		}	
			
	    String sql = "select * from members";
	    ArrayList<M_Member> mList = new ArrayList<M_Member>();
	    
	    
	    try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				M_Member member = new M_Member();
				member.setMbirth(rs.getString("mbirth"));
				member.setMid(rs.getString("mid"));
				member.setMname(rs.getString("mname"));
				member.setMphone(rs.getString("mphone"));
				member.setMpw(rs.getString("mpw"));
				member.setMstate(rs.getString("mstate"));
				mList.add(member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    return mList;
	}

	/*public int changeNState(String inputId) {
		Connection con = getConnection();
	    if(con == null) {
			System.out.println("DB 접속 실패");
			return 0;
		}	
	    
	
	    String nsql = "update members set mstate = 'N' where mid = ?";
	    
	    int n = 0;  
	    
	    try {
			PreparedStatement pst = con.prepareStatement(nsql);
			pst.setString(1, inputId);
			n=pst.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	  
	    
		return n;
	}


	public int changeYState(String inputId) {
		Connection con = getConnection();
	    if(con == null) {
			System.out.println("DB 접속 실패");
			return 0;
		}	
	    

	    String ysql = "update members set mstate = 'Y' where mid = ?";
	
	    int y =0;
	    
	    try {
			PreparedStatement pst = con.prepareStatement(ysql);

			pst = con.prepareStatement(ysql);
			pst.setString(1, inputId);
			y=pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	 
		return y;
	}

	public M_Member selectMid(String inputId) {
		Connection con = getConnection();
	    if(con == null) {
			System.out.println("DB 접속 실패");
			return null;
		}	

	    String sql = "select mid from members where mid = ?";
	    M_Member member = null;
	    try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, inputId);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				 member = new M_Member();
				 member.setMid(inputId);
				 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    		
		return member;
	}
*/
	public static  int updateMstate(String mid, String mstate) {
		Connection con = getConnection();
	    if(con == null) {
			System.out.println("DB 접속 실패");
			return 0;
		}
	    
	   String sql = "update members ";
	   
	   if(mstate.equals("Y")) {
		   sql+=" set mstate = 'N'";
	   }
	   else {
		   sql+=" set mstate = 'Y'";
	   } 
	sql+=" where mid = ?";
	int result=0;
	
	try {
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, mid);
		result=pst.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return result;
	}

	public ArrayList<M_Goods> showProductList() {
		Connection con = getConnection();
	    if(con == null) {
			System.out.println("DB 접속 실패");
			return null;
		}
	    
	    String sql = "select * from goods";
	    ArrayList<M_Goods> pdList = new ArrayList<M_Goods>();
		
	    
	    try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				M_Goods goods = new M_Goods();
				
				goods.setGname(rs.getString("gname"));
				goods.setGcode(rs.getString("gcode"));
				goods.setGprice(rs.getInt("gprice"));
				goods.setGstate(rs.getString("gstate"));
				goods.setGstock(rs.getInt("gstock"));
				goods.setGtype(rs.getString("gtype"));
				
				pdList.add(goods);
			}
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		return pdList;
	}

	public static int updateGstate(String gcode, String gstate) {
		Connection con = getConnection();
	    if(con == null) {
			System.out.println("DB 접속 실패");
			return 0;
		}
	    
	    String sql = "update goods ";
	    
	    if(gstate.equals("Y")) {
	    	sql+="set gstate = 'N' ";
	    }
	    else {
	    	sql+="set gstate = 'Y' ";
	    }
	    
	    sql+="where gcode = ?";
	    
	    int result = 0;
	    
	    try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, gcode);
			result = pst.executeUpdate();
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
		return result;
	}

}
