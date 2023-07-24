package day07;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = 0;
		boolean run = true;
		while(run) {
			System.out.println("[1] 증가 [2] 감소 [3] 종료");
			System.out.print("선택>>");
			int selectMenu = scan.nextInt();
			switch (selectMenu) {
			case 1:
				num++;
				break;
			case 2:
				num--;
				break;
			case 3:
				run=false;
				break;
			}
			System.out.println("현재 값은 "+num+" 입니다.");
		}

	}

}
