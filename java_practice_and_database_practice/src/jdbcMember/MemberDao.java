package jdbcMember;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class MemberDao {

	Connection getConnection() {
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
	
	public int insertMember(Member mi) {

		Connection con = getConnection();
		

	    int result = 0;
	    
	    if(con == null) {
			System.out.println("DB 접속 실패");
			return 0;
		} 
	    
	    String sql = "insert into Members(mid,mpw,mname,mphone,mbirth) "+"values(?,?,?,?,?)";
		
	    try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, mi.getMid());
			pst.setString(2, mi.getMpw());
			pst.setString(3, mi.getMname());
			pst.setString(4, mi.getMphone());
			pst.setString(5, mi.getMbirth());
			result =pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    
	
		return result;
	}

	public String select_idCheck(String inputMid) {

	Connection con = getConnection();
		

	    String idCheck = null;
	    
	    if(con == null) {
			System.out.println("DB 접속 실패");
			return null;
		} 

	    String sql = "select mid from members "+ "where mid=?";
	    
	    try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1,inputMid);
			 ResultSet rs= pst.executeQuery();
			 while(rs.next()) {
				idCheck=rs.getString(1); 
			 } // id가 중복이면 while문이 실행 안됨 
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		return idCheck;
	}

	public Member select_login(String inputMid, String inputMpw) {

		Member loginMember = null;
		
		
		Connection con=getConnection();
	    if(con == null) {
				System.out.println("DB 접속 실패");
				return null;
			} 
	    
	    String sql = "select * from members "+ "where mid = ? and mpw = ?";
	    
	
		try {
		    PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, inputMid);
			pst.setString(2, inputMpw);
			
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()) {
				loginMember = new Member();
				loginMember.setMid(rs.getString(1));
				loginMember.setMpw(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
		return loginMember;
	}

	/*public ArrayList<Member> selectMember() {
		Connection con = getConnection();
		if(con == null) {
			System.out.println("DB 접속 실패");
			return null;
		} 

		String sql = "select * from members";
		
		ArrayList<Member> mList = new ArrayList<Member>();
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				
				Member member = new Member();
				member.setMid(rs.getString(0));
				member.setMpw(rs.getString(1));
				member.setMname(rs.getString(2));
				member.setMphone(rs.getString(3));
				member.setMbirth(rs.getString(4));
				mList.add(member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mList;
	}*/

}
