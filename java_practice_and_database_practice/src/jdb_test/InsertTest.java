package jdb_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class InsertTest {

	public static void main(String[] args) {

	System.out.println("Insert Test");
    
	Connection con = null;   // 접속상태 확인 

	// 1. DB 접속 (DB 접속 상태 확보)
	// DB 주소, DB 아이디, DB 비밇번호
	
	String url="jdbc:oracle:thin:@//localhost:1521/xe";  // IP주소 -> DB위치
	// IP주소 넣어도 됨 192.168.200.101 등
	
    String userid="jhs_dba"; // 

    String userpw="1212";


	
	try {
		Class.forName("oracle.jdbc.OracleDriver"); // 드라이버 선언 

		con = DriverManager.getConnection(url,userid,userpw);
	}
	catch (ClassNotFoundException e){ 
		e.printStackTrace();
		System.out.println("드라이버 예외");
	
	} catch (SQLException e) { // DB 예외
		e.printStackTrace();
		System.out.println("DB 예외");
	}
	
	
	if(con  != null) {
		System.out.println("DB 접속");
		System.out.println("connection: " + con);
		// 2. 실행할 쿼리문 전송 및 경과값 반환 
		String sql = "insert into crudtest(numtest, chartest, datetest) " + "values(1, '테스트1', sysdate)"; // commit 까지 진행
		
		int insertResult = 0; // insert 가 되면 0 보다 크고, 안되면 0 보다 작다 
		
		try {
			
			con.setAutoCommit(false); // 자동 commit 기능 삭제 
			
			
			// 접속된 DB에 쿼리문에 전송 준비
			PreparedStatement st = con.prepareStatement(sql);
			
			// DB에서 쿼리문 실행 
			 insertResult = st.executeUpdate();
			
			con.commit();
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		if(insertResult > 0) {
			System.out.println("insert 성공");
		}
		else {
			System.out.println("insert 실패");
		}
		
	}
	
	
	else {
		System.out.println("DB 접속 실패");
	}


	}

}
