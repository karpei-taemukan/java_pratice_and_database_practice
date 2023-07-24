package day10;

public class Ex03 {

	public static void main(String[] args) {
		String[][] strArr= {{"A","B","C"},{"D","E"},{"F","G","H","I"}};
		
		for(int i=0; i<strArr[0].length; i++) {
			System.out.println(strArr[0][i]);
		}
		
		for(int i=0; i<strArr[1].length; i++) {
			System.out.println(strArr[1][i]);
		}
		
		for(int i=0; i<strArr[2].length; i++) {
			System.out.println(strArr[2][i]);
		}
		
		System.out.println("------------------------");
		
		for(int i=0; i<strArr.length; i++) {
			for(int j=0; j<strArr[i].length; j++) {
				System.out.println(strArr[i][j]);
			}
		}
		
}
}
