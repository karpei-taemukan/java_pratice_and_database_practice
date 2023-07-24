package day06;

public class Ex01 {

	public static void main(String[] args) {
		for(int i=9; i>=2; i--) {
			if(i!=3) {
				continue;
			}	
			for(int j=9; j>=1; j--) {
				System.out.println(i + "X" +j+"="+ i*j);

			}
		}
		
		int line = 5; 

		String tree = "*";
		for (int i = 0; i < line; i++) {
			for (int j = (line - 1) - i; j>0; j--) {
				System.out.print(" ");
			}
			System.out.println(tree);
			tree += "*";
		}
		

		String blank = "";
		for(int i=0; i<line; i++) {
			String star="*";
			for(int j=0; j<(line-1)-i; j++) {
				star+="*";
		
			}
		
			System.out.println(blank+star);
			blank+=" ";
			
		}
	}

	
}
