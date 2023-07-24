package day14;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneService2 {
/*	 		기능 정의 클래스 
 * 
 *			메뉴출력 기능  
 *
 *			연락처 저장 기능
 *
 *			연락처 검색기능 
 *		   -이름을 가지고 검색
 *		   -전화번호로 이름 검색 
 *
 			연락처 수정 기능 
 		   -이름을 수정
 		   -전화번호를 수정
 		   
 		   연락처 삭제 기능
  */
	Scanner scanner = new Scanner(System.in);
	PhoneBook[] pbs = new PhoneBook[5];
	ArrayList<PhoneBook> phoneBookList = new ArrayList<PhoneBook>();
	
	
	
	public void showMenu() {
		
		System.out.println("[1] 등록 [2] 검색 [3] 수정 [4] 삭제");
		System.out.println("메뉴를 선택하세요");
		
	}
	
	public void registInfo() {
		
		System.out.println("[1] 등록할 전화번호를 입력");
			
		if(phoneBookList.size() > 20) {
			System.out.println("더이상 등록할 수 없습니다");
			return;	
		}
		
		String registNum = scanner.next();
		
		
		System.out.println("[1] 등록할 이름을 입력");

		String registName = scanner.next();

		
		PhoneBook newInfo = new PhoneBook();
	
		newInfo.setPhoneNum(registNum);
		newInfo.setName(registName);
	phoneBookList.add(newInfo);
	
		
	}
	
	public void searchInfo() {
		// 이름으로 연락처 검색
		// 전화번호로 연락처 검색
		
		System.out.println("[2] 검색할 방법을 선택하세요");
		System.out.println("[1] 이름으로 연락처 검색 [2] 전화번호로 연락처 검색 [3] 검색 종료");
		
		int selectNum = scanner.nextInt();

		
		if(selectNum == 1) {
			System.out.println("이름 입력");
			String searchName = scanner.next();
			
			int idx = searchIdx(searchName);
			
		
				if(idx > -1) {
					System.out.println("이름: "+phoneBookList.get(idx).getName());
					System.out.println("전화번호: "+phoneBookList.get(idx).getPhoneNum());
				}
				else {
					System.out.println("이름이 존재하지 않습니다");
					
				}
			}
			
		
		
		else if(selectNum == 2){
			System.out.println("전화번호 입력");
			String searchNum = scanner.next();
			
			int idx = searchIdx(searchNum);

		/*	for(int i=0; i<pbs.length; i++) {
				 if(pbs[i] != null) {
				 if(searchNum.equals(pbs[i].getPhoneNum())) {
				idx=i;
				break;
				 }
				 }}*/
			for(int i=0; i<phoneBookList.size(); i++) {
				if(searchNum.equals(phoneBookList.get(i).getPhoneNum())) {
					idx=i;
				}
			}
			
				 if(idx > -1) {
						System.out.println("이름: "+phoneBookList.get(idx).getName());
						System.out.println("전화번호: "+phoneBookList.get(idx).getPhoneNum());
				 }
				 else {
					 System.out.println("전화번호가 존재하지 않습니다");
				 }
			 
			 }
		
		
		else {
			System.out.println("종료");
			return;
		}
		
		}
		
	

	public void modifyInfo() {
		// 수정하려는 연락처 검색
		// 연락처 수정되었을 경우
		// - 이름 수정
		// -전화번호 수정
		// 검색되지 않았을 경우
		// - 등록되지않았다고 출력
		
		
		System.out.println("수정하려는 연락처를 입력하세요");
		System.out.println("이름 입력");
		String searchName = scanner.next();
		System.out.println("전화번호 입력");
		 String searchNum = scanner.next();

		 for(int i=0; i<phoneBookList.size(); i++) {
			 if(searchName.equals(phoneBookList.get(i).getName()) 
					 && searchNum.equals(phoneBookList.get(i).getPhoneNum())) {
				System.out.println("[1] 이름 수정 [2] 전화번호 수정 [3] 종료");
				int selectModify = scanner.nextInt();
				
				
				if(selectModify == 1) {
					System.out.println("수정할 이름을 입력하세요");
					 String modifyName = scanner.next();
					 //pbs[i].setName(modifyName);
					phoneBookList.get(i).setName(modifyName);
					 System.out.println(phoneBookList.get(i).getName());
					 break;
				}
				else if(selectModify == 2) {
					System.out.println("수정할 전화번호를 입력하세요");
					String modifyNum = scanner.next();
					// pbs[i].setPhoneNum(modifyNum);
					phoneBookList.get(i).setPhoneNum(modifyNum);
					System.out.println(phoneBookList.get(i).getPhoneNum());
						 break; 
					
				}
				else {
					return;
				}
			 }
		 }
		 
		 
	}
	
	public void deleteInfo() {
		/*
		 * 삭제할 연락처 검색
		 * 연락처 검색되었으면 연락처 삭제
		 * 연락처 검색 안됬다면 등록되지않았다고 출력
		 */
		
		System.out.println("[삭제]");
		System.out.println("삭제할 연락처 검색");
		String searchName = scanner.next();
		int idx = searchIdx(searchName);
		if(idx > -1) {
			//pbs[idx]=null;
			phoneBookList.remove(idx);
			phoneBookList.get(idx).setPhoneNum(null);
			System.out.println("연락처 삭제");
		}
		else{
			System.out.println("검색할 연락처가 없습니다");
		}
	}
	
	 
	public int searchIdx(String search) {
		
	int idx = -1;
			
			for(int i=0; i<phoneBookList.size(); i++) {
				if(search.equals(phoneBookList.get(i).getName())) {
					idx=i;
				}
			}
		return idx;
	}
	
}