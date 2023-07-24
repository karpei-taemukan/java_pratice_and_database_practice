package day14;

public class PhoneBookMain {

	public static void main(String[] args) {
		PhoneService phoneSvc = new PhoneService();
		
		boolean run = true;
		
		while(run) {
			phoneSvc.showMenu();
			int selectMenu = phoneSvc.scanner.nextInt();
			switch (selectMenu) {
			case 1:
				phoneSvc.registInfo();
				break;
			case 2:
				phoneSvc.searchInfo();
				break;
			case 3:
				phoneSvc.modifyInfo();
				break;
			case 4:
				break;
							
				
			default:
				run=false;
			}
		}
		
		
		
		
		
		
		
	}

}
