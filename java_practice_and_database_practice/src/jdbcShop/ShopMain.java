package jdbcShop;

import java.util.Scanner;

public class ShopMain {

	/*
	 * 1.Member, Goods, Order
	 * 2.ShowService(기능) 
	 * 3.ShopDao(DB)
	 * 4.ShopMain
	 * 
	 * */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean run = true;
		
		ShopService shopsvc=new ShopService();
		
		while(run) {
			// 메뉴출력 (로그인 상태에 따라 다른 메뉴 출력)
			String loginId=shopsvc.getLoginId();
			
			if(loginId == null) {
					// 로그인 x
				System.out.println("[1] 회원가입 [2] 로그인 [9]상품목록(map)");
			}
			else {  // 로그인 o
				System.out.println("[1] 내 정보 확인 [2] 로그아웃 [3] 상품주문 [4] 주문내역");
				
			}
			System.out.println("메뉴선택");
			int selectMenu = scan.nextInt();
			switch (selectMenu) {
			case 1:
				if(loginId == null) {
					// 로그인 x 회원가입 기능 호출
					shopsvc.memberJoin();
			}
			else {  // 로그인 o 내 정보확인 기능 호출
					shopsvc.memberInfo();
			}
				break;
			case 2:
				if(loginId == null) {
					// 로그인 기능 호출
					shopsvc.memberLogin();
			}
			else {  // 로그아웃 기능 호출 
				 shopsvc.memberlogout();
			}
				break;
			case 3:
				if(loginId == null) {
					// 로그인 기능 호출
				}
			else {  // 로그아웃 기능 호출 
				shopsvc.goodsOrder();
			}
				break;
			case 4:
				if(loginId != null) {
					shopsvc.orderList();
				}
				 break;
		
			case 9:
				shopsvc.goodsList_Map();
				break;
			default:
				run=false;
				}
			System.out.println();
		}
	}

}
