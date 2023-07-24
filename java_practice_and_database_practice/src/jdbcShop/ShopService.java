package jdbcShop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ShopService {
	
	Scanner scan = new Scanner(System.in);
	
	ShopDao shopdao = new ShopDao();
	
	private String loginId=null; // 로그인 아이디 
	
	public String getLoginId() {
		return loginId;
	}

	public void memberJoin() {
		
		
		System.out.println("등록할 아이디 입력");
		String id = scan.next();
		
		String id_check = shopdao.select_idcheck(id);
		
		if(id_check == null) {
			System.out.println("사용 가능 아이디");
	}
		else {
			System.out.println("사용즁인 아이디");
			return ;
		}
		
		System.out.println("등록할 비밀번호 입력");
		String pw = scan.next();
		
		System.out.println("등록할 이름 입력");
		String name= scan.next();
		
		System.out.println("등록할 전화번호 입력: ");
		String phonenum=scan.next();
		
		System.out.println("등록할 생년월일 입력");
		String birth = scan.next();
		
		Member member = new Member();
		
		member.setMid(id);
		member.setMpw(pw);
		member.setMbirth(birth);
		member.setMname(name);
		member.setMphone(phonenum);
		
		int insertResult = shopdao.insertMember(member);
	
		 if(insertResult > 0) {
			 System.out.println("회원 가입 성공");
		 }
		 else {
			 System.out.println("회원 가입 실패");
		 }
	}

	public void memberInfo() {

		System.out.println("내 정보 조회");
		
	
		//ArrayList<Member> mList = shopdao.select_memberInfo(loginId);
		
		Member mList = shopdao.select_memberInfo(loginId);
		if(mList == null) {
			System.out.println("검색된 연락처가 없습니다");
		
	//	}
//		if(mList.size() <=0) {
		}
		else {	
		System.out.println(mList.getMid());
		System.out.println(mList.getMpw());
		System.out.println(mList.getMname());
		System.out.println(mList.getMphone());
		System.out.println(mList.getMbirth());
		
		
		
		int countOrder = shopdao.selectCountOrder(loginId);
	int totalPrice = shopdao.selectTotalOrder(loginId);
		
		System.out.println("총 주문수: "+countOrder);
		System.out.println("총 결제금액: "+totalPrice);
		/*	for(int i =0; i < mList.size(); i++) {
				System.out.println(mList.get(i).getMid());
				System.out.println(mList.get(i).getMpw());
				System.out.println(mList.get(i).getMname());
				System.out.println(mList.get(i).getMphone());
				System.out.println(mList.get(i).getMbirth());
			}*/
		}
	}

	public void memberLogin() {
		
		System.out.println("로그인");
		
		System.out.println("아이디 입력");
		String inputId = scan.next();
		
		System.out.println("비밀번호 입력");
		String inputPw = scan.next();
		
		Member loginMember = shopdao.select_login(inputId,inputPw);
		
		if(loginMember != null) {
			if(loginMember.getMstate().equals("Y")) {
			System.out.println("로그인 성공");
			loginId = loginMember.getMid();}
		else {
			System.out.println("이용정지 계정");
		}
		}	else {
			System.out.println("아이디 비밀번호 불일치");
			System.out.println("로그인 실패");
		}
	}

	public void memberlogout() {
		 loginId=null; 
		 System.out.println("로그아웃");
	}

	
ArrayList<Goods> getGoodsList(){ // 상품목록 조회
	
	ArrayList<Goods> goodsList = null;

	System.out.println("[1] 전체 상품 [2] 종류 별 상품 [3] 인기 상품");
	System.out.println("선택 >> ");
	int selectList = scan.nextInt();
	
	switch (selectList) { // 상품 목록 조회
	case 1:
		System.out.println("[전체 상품 목록]");
		goodsList=shopdao.selectGoods_all();
		break;
	case 2:
		System.out.println("[종류별 상품 목록]");
		// 1. GTYPE 조회
		ArrayList<Goods> gtypeList = shopdao.selectGtype();
	
		gtypeList=shopdao.selectGtype();
		if(gtypeList != null) {
			for(int i=0; i<gtypeList.size(); i++) {
				System.out.print("["+i+"]"+gtypeList.get(i).getGtype());
			}
			System.out.println("\n선택>>");
			int selectType=scan.nextInt();
			String gtype = gtypeList.get(selectType).getGtype();
			goodsList=shopdao.selectGoods_type(gtype);
					
		}
		break;
	case 3: 
		System.out.println("[인기 상품 목록]");
		goodsList=shopdao.selectGoods_best();
		break;
	
	} // switch 문 종료
	return goodsList;
}


	public void goodsOrder() {
		ArrayList<Goods> goodsList = getGoodsList();
		
		
		if(goodsList==null || goodsList.size() <= 0) {
			System.out.println("삼품목록 조회 실패");
			System.out.println("다시 선택");
			return;
		}
		
		for(int i=0; i<goodsList.size(); i++) {
			System.out.println("["+i+"]"+goodsList.get(i).getGname());
			if(goodsList.get(i).getGstate().equals("Y")) {
				System.out.println(goodsList.get(i).getGprice()+"원");
				System.out.println(goodsList.get(i).getGstock()+"개");
			}
			else {
				System.out.println("주문 불가 상품");
			}
		}
		System.out.println("상품선택 >> ");
		int selectGoods = scan.nextInt();
		Goods goods = goodsList.get(selectGoods);
		System.out.println(goods.getGname()+"[가격]"+goods.getGprice());
		
		if(goods.getGstate().equals("N")) {
			System.out.println("["+goods.getGname()+"]은 주문 불가");
			System.out.println("다시 선택");
			return ;
		}
		
		System.out.println("상품을 선택했습니다");
		String odgcode=goods.getGcode(); // 주문 상품코드 
		
		System.out.println("주문 수량 입력>>");
		int odqty = scan.nextInt(); // 주문 수량
		if(odqty > goods.getGstock()) {
			System.out.println("재고가 부족");
			return;
		}
		
		// 주문자 아이디(odmid) = 로그인 아이디(loginId), 주문 시간(oddate) = sysdate
		// 주문코드 생성 'O0001', 'O0002', 'O0003', 'O0004'
		// 1. 현재 주문코드 최대값 조회 'O0004'
		// -- select nvl(max(odcode), 'O0004') from orders
		
		
		String maxOdcode = shopdao.selectMaxOdcode(); // 주문코드의 최대값

		if(maxOdcode == null) {
			System.out.println("주문처리 중 문제 발생 다시 시도하라");
			return; // null 값이 nvl을 통해 변환했기 때문에 예외처리가 아닌 이상 null 값이 넘어오지 않는다 
		}
		System.out.println("maxOdcode" + maxOdcode); // 'O0004'
		
	
		String strCode=maxOdcode.substring(0,1);
		
		int numCode = Integer.parseInt(maxOdcode.substring(1))+1; // 
		
		String odCode=strCode+String.format("%04d", numCode);
		// odgcode에 1 추가해서 새로운 코드 생성
	
		System.out.println("odCode"+odCode);
		Order od = new Order();
		od.setOdcode(odCode);
		od.setOdmid(loginId);
		od.setOdgcode(odgcode);
		od.setOdqty(odqty);
		
		int orderResult = shopdao.insertOrder(od);
		
		if(orderResult > 0) {			
			int goodsResult = shopdao.updateGoods(odgcode,odqty);
			System.out.println("주문완료");
		}
		else {
			System.out.println("주문처리 실패");
			System.out.println("다시 주문");
		}
		
		// 주문자 아이디 = 로그인 아이디,  주문 시간=SYSDATE
		
		// 주문코드 생성  O0005부터 만든다 
		
		/* 1. 현재 주문코드의 최댓값 조회 (O0004)
		 * 2. 문자와 숫자 분리 'O' '0004'
		 * 3. 0004 숫자로 변환
		 * 4. 숫자 4 에 +!
		 * 5. 숫자를 4자리의 0000 형식을 변환
		 * 6. O와 0004 로 결합 
		 * */
		
		
		// 1. 판매중인 상품 목록 출력 goods에 select 
		//-> 전체 상품 목록, 종류별 상품 목록 인기 상품 목록
		
		// 2. 구매할 상품 선택 --> 상품코드선택 
		
		// 3. 구매 수량 입력 -> 주문수량입력
		// 3.5 주문코드 생성  orders => select
		
		// 4. 주문 처리 후 결과 출력 --> orders에 insert 
		// 4.5 goods에 update 상품재고  수정 
		// 5. orders insert 주문정보 입력
		
		
		
	}

	public void goodsList_Map() {
	System.out.println("[상품목록(map)]");	
	// 1. 상품목록 조회 (dao-select >> service 리턴)
	ArrayList<HashMap<String, String>> goodsList = shopdao.selectGoods_Map();
	// 2. 조회된 상품목록 조회
	for(int i=0; i<goodsList.size(); i++) {
		System.out.println(goodsList.get(i).get("gcode")+"");
		System.out.println(goodsList.get(i).get("gname")+"");
		System.out.println(goodsList.get(i).get("gprice")+"");
		System.out.println(goodsList.get(i).get("gtype")+"");
		System.out.println(goodsList.get(i).get("gstock")+"");
	}
	}

	public void orderList() {
		System.out.println("[주문 내역]");
		System.out.println("[1] 최근주문 [2] 총액 높은순");
		
		Scanner scan = new Scanner(System.in);
		int selectOption = scan.nextInt();

		// dao - 주문내역 조회 select
		ArrayList<HashMap<String, String>> orderList = shopdao.selectOrders_Map(loginId, selectOption);
		// 주문내역 출력
		
		if(orderList == null) {
			System.out.println("주문내역 조회 실패"); // -> DB 접속 실패
			return;
		}
		else if(orderList.size() == 0){
			System.out.println("주문내역이 없음");
			return;
		}
		
			for(int i=0; i< orderList.size(); i++) {
				System.out.println("["+i+"]"+orderList.get(i).get("gname"));
				System.out.println(", "+orderList.get(i).get("gprice"));
				System.out.println(", "+orderList.get(i).get("odqty"));
				System.out.println(", "+orderList.get(i).get("totalprice"));
				System.out.println(", "+orderList.get(i).get("oddate"));
				System.out.println(", "+ orderList.get(i).get("odcode"));
			}
			/*
			 * 주문취소 
			 * 상품재고 수정 
			 * */
			System.out.println("취소할 주문선택");
			int selectOrder = scan.nextInt();
			HashMap<String, String> order = orderList.get(selectOrder);
			String odcode = order.get("odcode"); // 취소할 주문 코드
			int gstock =  Integer.parseInt(order.get("odqty")); // 증가시킬 재고
			String gcode =  order.get("gcode");//재고를 증가시킬 상품 코드 
			System.out.println(odcode + ", "+gstock+", "+ gcode);
			
			
			int cancelResult = shopdao.cancelOrder(odcode, gstock, gcode);
			
			if(cancelResult > 0) {
				System.out.println("주문내역 삭제");
			}
			else {
				System.out.println("주문내역 삭제 실패");
			}
			

	}


}
