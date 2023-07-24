package jdb_test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.TextStyle;
import java.util.spi.LocaleNameProvider;

public class ConnectionTest {

	public static void main(String[] args) {
		System.out.println("접속 테스트");
		
		String url="jdbc:oracle:thin:@//localhost:1521/xe";  // IP주소 -> DB위치
									// IP주소 넣어도 됨 192.168.200.101 등
		String userid="jhs_dba"; // 
	
		String userpw="1212";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver"); // 드라이버 세팅
			
			Connection con = DriverManager.getConnection(url,userid,userpw); //  접속상태 정보
			
			System.out.println("DB 접속 성공");
	
			//쿼리문 작성
			String sql="select * from emp"; 
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			// 접속정보(con)를 바탕으로 전송할 준비
			
			ResultSet rs = pstmt.executeQuery();
			// executeQuery() 쿼리문 보내서 실행 
			
			// rs.next() => 레코드의 위치를 다음으로 이동시킨다
			while (rs.next()) {
				System.out.println(rs.getString(1)+" "+rs.getString(2));
					}		
			
			rs.close();
			pstmt.close();
			con.close();
			
			
		} catch (ClassNotFoundException e) {
		
			System.out.println("드라이버 Exception"); // 드라이버 관련 예외 -> 드라이버 이름 틀림
			
			e.printStackTrace();
		
		} catch (SQLException e) { // db에 관련된 예외 -> db 주소,host 이름,db 비밀번호 틀림
		
			System.out.println("DB Exception");
			
			e.printStackTrace();
		}
	}

}
