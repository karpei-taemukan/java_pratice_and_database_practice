package jdbcPhonebook;

import java.util.ArrayList;
import java.util.Scanner;

import day14.PhoneBook;

public class PhonebookService {

	public void insertPhoneBook() {
		PhonebookDao pdao = new PhonebookDao();
		System.out.println("등록");
		// 1. 등록한 이름, 전화번호 압력 --> DB에 들어감
		
		Scanner scan = new Scanner(System.in);
		System.out.println("등록할 이름 입력: ");
		String name = scan.next();
		System.out.println("등록할 전화번호 압력: ");
		String phonenum = scan.next();
		
		PhoneBook pb = new PhoneBook();
		pb.setName(name);
		pb.setPhoneNum(phonenum);
		
		// 2. DAO insert 기능을 하는 메소드 호출
		
		 int insertResult = pdao.insertPhonenum(pb);
		
		// 3. 결과 확인 및 처리
		 
		 if(insertResult > 0) {
			 System.out.println("새 연락처가 등록됨");
		 }
		 else {
			 System.out.println("새 연락처 등록 실패");
		 }
		
	}
	
	

	public void selectPhoneBook() {
		PhonebookDao pdao = new PhonebookDao();
		System.out.println("조회");
		
		ArrayList<Phonebook> pbList = pdao.select();
		
		if(pbList == null) {
			return;
		}
		
		if(pbList.size() <=0) {
			System.out.println("검색된 연락처가 없습니다");
		}
		else {
			for(int i =0; i < pbList.size(); i++) {
				System.out.println(pbList.get(i).getName());
				System.out.println(pbList.get(i).getPhonenum());
			}
		}
	}


	
	public void selectPhonebook_name() {
		Scanner scan = new Scanner(System.in);
		System.out.println("검색할 이름 입력 >> ");
		String inputname = scan.next();
		
		
		// 1. Phonebookdao 기능 메소드 호출
		PhonebookDao pdao = new PhonebookDao();
			ArrayList<Phonebook> pbList = pdao.select_name(inputname);
			
			if(pbList == null) {
				return;
			}
			if(pbList.size() <=0) {
				System.out.println("검색된 연락처가 없습니다");
			}
			else {
				for(int i =0; i<pbList.size(); i++) {
					System.out.println("이름: " + pbList.get(i).getName());
					System.out.println("전화번호: "+pbList.get(i).getPhonenum());
				}
			}
			
		// 2. 연락처 풀력
	}



	public void updatePhoneBook() {
		Scanner scan = new Scanner(System.in);
		System.out.println("[수정]");
		
		//1. 수정할 연락처를 검색
		System.out.println("검색할 이름 입력 >> ");
		String inputname = scan.next();
		
		
		// 1. Phonebookdao 기능 메소드 호출
		PhonebookDao pdao = new PhonebookDao();
			ArrayList<Phonebook> pbList = pdao.select_name(inputname);
			
			if(pbList == null) {
				return;
			}
			if(pbList.size() <=0) {
				System.out.println("검색된 연락처가 없습니다");
			}
			
			else {
				System.out.println("연락처가 " + pbList.size() +"개 검색됨" );
				for(int i =0; i<pbList.size(); i++) {
					System.out.println("["+i+"] 이름: " + pbList.get(i).getName());
					System.out.println("전화번호: "+pbList.get(i).getPhonenum());
				}
				System.out.println("수정할 연락처 선택>>");
				
				int selectpb = scan.nextInt();
				Phonebook pb = pbList.get(selectpb);
				System.out.println("새 전화번호를 입력>>");
				String inputPhonenum=scan.next();
				
				int result = pdao.update(pb, inputPhonenum);
				
				if(result > 0) {
					System.out.println("연락처가 수정됨");
				}
				else {
					System.out.println("연락처 수정 실패");
				}
				
			}
		
			
	}



	public void deletePhoneBook() {
		Scanner scan = new Scanner(System.in);
		System.out.println("[삭제]");
		
	
		System.out.println("검색할 이름 입력 >> ");
		String inputname = scan.next();
		
		PhonebookDao pdao = new PhonebookDao();
		
		ArrayList<Phonebook> pbList = pdao.select_name(inputname);
		
		if(pbList == null) {
			return;
		}
		if(pbList.size() <=0) {
			System.out.println("검색된 연락처가 없습니다");
		}
		else {
			System.out.println("연락처가 " + pbList.size() +"개 검색됨" );
			for(int i =0; i<pbList.size(); i++) {
				System.out.println("["+i+"] 이름: " + pbList.get(i).getName());
				System.out.println("전화번호: "+pbList.get(i).getPhonenum());
			}
			System.out.println("삭제할 연락처 선택>>");
			
			int selectpb = scan.nextInt();
			Phonebook pb = pbList.get(selectpb);
			
			int result = pdao.delete(pb);
			
			if(result > 0) {
				System.out.println("연락처가 삭제됨");
			}
			else {
				System.out.println("연락처 삭제 실패");
			}
			
		}
	}

}
