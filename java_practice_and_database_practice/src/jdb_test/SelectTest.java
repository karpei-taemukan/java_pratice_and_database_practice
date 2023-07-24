package jdb_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Scanner;

import oracle.net.aso.c;
import oracle.net.aso.l;

public class SelectTest {

	public static void main(String[] args) {
		// crudtest 테이블이 새로운 데이터 입력 
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Numtest 입력: ");
		int inputNum=scan.nextInt();
		
		
		// 1. 사용자에게 데이터 입력 
		
	
		
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
		
		
		String sql = "select numtest,chartest,to_char(datetest,'yyyy-mm-dd')" + " from crudtest " + 
		"where numtest = ?";
		
		ArrayList<CrudDto> crudList = new ArrayList<CrudDto>();

		try {
			// 접속된 DB에 쿼리문 전송준비
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, inputNum);

			// 쿼리문 실행 및 결과 값 반환  
			ResultSet rs = pst.executeQuery(); 
			
			while(rs.next() /*다음 행을 넘김*/) {
				CrudDto crud = new CrudDto();
				crud.setNumtest(rs.getInt(1)); // 1 대신 컬럼명을 써도 된다 
				crud.setChartest(rs.getString(2));
				crud.setDatetest(rs.getString(3));
	
				
				crudList.add(crud);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for(int i=0; i<crudList.size(); i++) {
			System.out.println(crudList.get(i).getNumtest());
			System.out.println(crudList.get(i).getChartest());
			System.out.println(crudList.get(i).getDatetest());
		}
		
	
		if(crudList.size()==0) {
			System.out.print("조회된 정보가 없습니다");
		}
	}
}
