package jdbcPhonebook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import day14.PhoneBook;

public class PhonebookDao {

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
	
	public int insertPhonenum(PhoneBook pb) { // phonebook table insert function

		Connection con = getConnection();
		int result = 0;
		
		if(con == null) {
			System.out.println("DB 접속 실패");
			return 0;
		} 
		
			String sql = "insert into phonebook(name,phonenum) "+"values(?,?)";
			try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, pb.getName());
			pst.setString(2, pb.getPhoneNum());
			result = pst.executeUpdate();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return result;
					
	}

	public ArrayList<Phonebook> select() {
		Connection con = getConnection();
		if(con == null) {
			System.out.println("DB 접속 실패");
			return null;
		} 

		String sql = "select * from phonebook";
		
	
		ArrayList<Phonebook> pbList = new ArrayList<Phonebook>();
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs  = pst.executeQuery();
			while(rs.next()) {
				Phonebook pb = new Phonebook();
				pb.setName(rs.getString("name"));
				pb.setPhonenum(rs.getString(2));
				pbList.add(pb);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return pbList;
	}

	public ArrayList<Phonebook> select_name(String inputname) {
		
		
		
		Connection con = getConnection();
		if(con == null) {
			System.out.println("DB 접속 실패");
			return null;
		} 

		String sql = "select * from phonebook "+"where name = ?";
		
	
		ArrayList<Phonebook> pbList = new ArrayList<Phonebook>();
		
		
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1,inputname); // 물음표 채우기 
			
			ResultSet rs  = pst.executeQuery();
			while(rs.next()) {
				Phonebook pb = new Phonebook();
				pb.setName(rs.getString("name"));
				pb.setPhonenum(rs.getString(2));
				pbList.add(pb);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return pbList;
	}

	public int update(Phonebook pb, String inputPhonenum) {
		
		Connection con = getConnection();
		
		if(con == null) {
			System.out.println("DB 접속 실패");
			return 0;
		} 

		String sql = "update phonebook "+ "set phonenum = ? "+"where name = ? and phonenum = ?";
		int result = 0;
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setString(1,inputPhonenum);
			pst.setString(2, pb.getName());
			pst.setString(3, pb.getPhonenum());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return result;
	}

	public int delete(Phonebook pb) {
	Connection con = getConnection();
	int result=0;
		
		if(con == null) {
			System.out.println("DB 접속 실패");
			return 0;
		} 
		
		
		
		String sql = "delete from phonebook "+"where name = ? and phonenum = ?";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, pb.getName());
			pst.setString(2, pb.getPhonenum());
			result=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}


}
