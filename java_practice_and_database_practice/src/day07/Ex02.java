package day07;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int account = 0;
		boolean run = true;
		
		while(run) {
			System.out.println("[1] 입금 [2] 출금 [3] 잔고 [4] 종료");
			System.out.print("선택>>");
			int selectMenu = scan.nextInt();
			
			switch (selectMenu) {
			case 1:
				System.out.println("입금 값 입력>>");
				int deposit = scan.nextInt();
				account+=deposit;
				break;
			case 2:
				System.out.println("출금 값 입력>>");
				int withdraw = scan.nextInt();
				
				if(account >= withdraw && withdraw != 0) {
				account-=withdraw;
				break;
				}
				
				else {
					Boolean rerun=true;
					while(rerun) {
					System.out.println("출금 값 다시 입력: ");
					int redownnum = scan.nextInt();
					if(redownnum <= account) {
						account-=redownnum;
						rerun = false;
					}
					else {
						System.out.println("잔고가 부족");
					}
					}
					break;
				}
				
			case 3:
				System.out.println("현재 잔고는 "+account+" 입니다.");
				break;
			case 4: 
				run=false;
				break;
			}	
		}
		System.out.println("종료");

	}

}
