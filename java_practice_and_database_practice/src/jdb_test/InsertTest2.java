package jdb_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.net.aso.c;

public class InsertTest2 {

	public static void main(String[] args) {
		// crudtest 테이블이 새로운 데이터 입력 
		
		// 1. 사용자에게 데이터 입력 
		
		Scanner scan = new Scanner(System.in);
		System.out.println("숫자 입력");
		int inputNum = scan.nextInt();
		System.out.println("문자 입력");
		String inputStr = scan.next();
		System.out.print("날짜 입력(yyyymmdd)");
		String inputDate = scan.next();
	
		
		//2. 받아온 데이터를 crudtest 테이블에 입력하는 처리
		Connection con  = null;

		//3. DB 접속
		String url="jdbc:oracle:thin:@//localhost:1521/xe";  // IP주소 -> DB위치
		// IP주소 넣어도 됨 192.168.200.101 등
		
	    String userid="jhs_dba"; // 

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
		if (con == null) {
			System.out.println("DB 접속 실패");
		}
		
		else {
			System.out.println("DB 접속 성공");
		}
		
		// 3. 쿼리문 실행 및 결과 값 반환 
		
		 String sql = "insert into crudtest(numtest,chartest, date"
		 		+ "test) " + "values(?, ?, ?)";
		 int insertResult = 0; // insert 처리 결과 값 저장 
		 
		 try {
			 // 접속된 DB 쿼리문 전송 준비
			PreparedStatement pst = con.prepareStatement(sql);
			
			// ? 자리에 매핑할 값입력 
			
			pst.setInt(1,inputNum);
			pst.setString(2, inputStr);
			pst.setString(3, inputDate);
			
			// 쿼리문 실행 및 결과 값 반환 
			insertResult = pst.executeUpdate(); // insert가 이뤄지면 1로 표기
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("inserResult: " + insertResult);
		 if(insertResult > 0) {
			 System.out.println("입력성공");
		 }
		 else {
			 System.out.println("입력실패");
		 }
		 
	}
}
