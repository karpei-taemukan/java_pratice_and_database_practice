package jdbcShopMaster;

import java.util.Scanner;

public class MasterMain {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		boolean run = true;
		MasterService msvc = new MasterService();
		
		while (run) {
			System.out.println("[1] 회원 관리 [2] 상품관리");	
			System.out.println("선택 >>");
			int selectMenu = scan.nextInt();
			
			switch (selectMenu) {
			
			
			case 1:
				msvc.memberManager();
				break;

			case 2:
				msvc.productManager();
				break;
			default:
				run=false;
			}
		}
	}

}
