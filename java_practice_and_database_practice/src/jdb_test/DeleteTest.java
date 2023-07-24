package jdb_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteTest {

	public static void main(String[] args) {
		

	
		// 1. DB 접속
		
		String url="jdbc:oracle:thin:@//localhost:1521/xe";  
	    String userid="jhs_dba"; 
	    String userpw="1212";
		Connection con = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(url,userid,userpw);
			int deleteResult=0;
			if(con == null) {
				System.out.println("접속실패");	
			}
			else {
				System.out.println("접속 성공");
				
				// 2. 접속된 DB에 쿼리문을 전송 결과값 반환
				String sql = "delete crudtest";
				
		
				PreparedStatement pst = con.prepareStatement(sql);
				deleteResult = pst.executeUpdate();
				
				if(deleteResult > 0) {
					System.out.println("삭제 성공");
}
				else {
					System.out.println("삭제 실패");
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		 catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
