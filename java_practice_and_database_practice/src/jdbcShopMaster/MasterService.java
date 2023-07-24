package jdbcShopMaster;

import java.util.ArrayList;
import java.util.Scanner;
import jdbcShop.Member;

public class MasterService {

	MasterDao mdao = new MasterDao();
	//     private int toggle = -1;
	Scanner scan = new Scanner(System.in);
	
	
	public void memberManager() {
		ArrayList<M_Member> memInfo = new ArrayList<M_Member>();
		memInfo = mdao.showMembersList();

		
		System.out.println("[회원관리]");
		if(memInfo != null) {
			for(int i=0; i<memInfo.size(); i++) {
				System.out.println("["+i+"]"+"["+memInfo.get(i).getMstate()+"]"+"["+"아이디"+"]"+memInfo.get(i).getMid());
				
			}
		}
		

System.out.println("회원 선택 >>");
int selectMember  = scan.nextInt();
String mid = memInfo.get(selectMember).getMid();
String mstate = memInfo.get(selectMember).getMstate();
int result = MasterDao.updateMstate(mid, mstate);

if(result > 0) {
	if(mstate.equals("Y")) {
		System.out.println("["+mid+"]"+"이용정지");
	}
	else {
		System.out.println("["+mid+"]"+"이용가능");
	}
}else {
	System.out.println("변경상태 처리 실패");
}
	}
	
public void productManager() {
ArrayList<M_Goods> pdInfo =  new ArrayList<M_Goods>();
pdInfo=mdao.showProductList();
System.out.println("[상품관리]");
if(pdInfo != null) {
	for(int i=0; i<pdInfo.size(); i++) {
		System.out.println("["+i+"]"+"["+pdInfo.get(i).getGstate()+"]"+"["+"이름"+"]"+pdInfo.get(i).getGname()+"["+pdInfo.get(i).getGprice()+"원"+"]"+"["+pdInfo.get(i).getGstock()+"개"+"]");
		
	}
}

System.out.println("상품선택 >>");
int selectOption = scan.nextInt();
String gcode = pdInfo.get(selectOption).getGcode();
String gname = pdInfo.get(selectOption).getGname();
String gstate = pdInfo.get(selectOption).getGstate();


	if(gstate.equals("Y")) {
	System.out.println("선택한 상품은 "+ "["+pdInfo.get(selectOption).getGname()+"]"+"은"+"\n");

		System.out.println("["+gname+"]"+"은 판매 가능");
	}
	
	else {
System.out.println("선택한 상품은 "+ "["+pdInfo.get(selectOption).getGname()+"]"+"은"+"\n");

		System.out.println("["+gname+"]"+"은 판매 불가");
	}

System.out.println("판매 상태를 변경 ?");
System.out.println("[1] yes"+"[2] no");
int num = scan.nextInt();

if(num == 1) {
	int result = MasterDao.updateGstate(gcode,gstate);
	if(result > 0) {
		if(gstate.equals("Y")) {
		System.out.println("["+gname+"]"+"은 판매 블가 처리");
	}else {
		System.out.println("["+gname+"]"+"은 판매 가능 처리");
	}
}
	else {System.out.println("판매상태 변경 실패");}
}
else if(num == 2)
{
	return;
}
else {
	System.out.println("잘못선택");
	return;
}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		/*System.out.println("회원 아이디 입력");
		
		Scanner scan = new Scanner(System.in);
		
		String inputId = scan.next();
		
		
		M_Member mem = new M_Member();
		
		if(inputId == "0") {
			return ;
		}
		
		

	if(toggle < 0)
	{
	int	mstResult = mdao.changeNState(inputId);
		mem=mdao.selectMid(inputId);
		toggle =1;
	}
	else {
		int mstResult= mdao.changeYState(inputId);
		mem=mdao.selectMid(inputId);
		toggle=-1;
	}*/
	
		


	

	
	


}
