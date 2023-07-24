package jdb_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Scanner;


public class UpdateTest {

	public static void main(String[] args) {
		// crudtest 테이블이 새로운 데이터 입력 
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Where Numtest 입력: ");
		int inputNum=scan.nextInt();
		
		System.out.println("Chartest 컬럼 수정할 값 입력: ");
		String inputChar = scan.next();
		
		// 1. 사용자에게 데이터 입력 
		
		
		
		//2. 받아온 데이터를 crudtest 테이블에 입력하는 처리
		Connection con  = null;

		//3. DB 접속
		String url="jdbc:oracle:thin:@//localhost:1521/xe";  // IP주소 -> DB위치
		// IP주소 넣어도 됨 192.168.200.101 등
		
	    String userid="jhs_dba"; // 

	    String userpw="1212";
	    int updateResult=0;
	    
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
			String sql = "update crudtest "+"set chartest = ? "+"where numtest = ?";
			try {
				PreparedStatement pst = con.prepareStatement(sql);
				
				pst.setString(1,inputChar); // mapping 과정
				pst.setInt(2, inputNum);   //  mapping 과정
				updateResult=pst.executeUpdate();
				System.out.println("updateResult: "+updateResult);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		if(updateResult > 0) {
			System.out.println("update success");
			
		}
		else {
			System.out.println("update fail");
		}
		
		
		
	}
}
