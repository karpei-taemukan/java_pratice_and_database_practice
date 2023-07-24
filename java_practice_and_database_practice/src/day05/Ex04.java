package day05;

public class Ex04 {

	public static void main(String[] args) {
		int k,l; 
		
		for(k=1; k<=10; k++) {
			
			if(k==5) {
				break;
			}			
			// break;
			// continue;
			
			System.out.println(k);
			
		}
		
		System.out.println();
	for(l=1; l<=10; l++) {
			
			if(l==5) {
				continue;
			}			
			// break;
			// continue; // 다음 단계로 건너뛴다
			
			System.out.println(l);
			
		}
	}

}
