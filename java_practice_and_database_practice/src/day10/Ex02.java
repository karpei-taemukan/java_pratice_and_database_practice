package day10;

public class Ex02 {

	public static void main(String[] args) {
		 String[][] strArr = new String[2][3]; // => 2 row    3 column
				strArr[0][0] = "A";
				
				System.out.println("row's count: " + strArr.length);
				System.out.println("0 row: "+ strArr[0].length);
				System.out.println("1 row: "+ strArr[1].length);
				
				String [][] strArr2 = new String[3][]; // 3개의 row에 크기가 랜덤인 배열이 들어갈것이다 
				System.out.println(strArr2.length);
				
				strArr2[0] = new String[2];
				strArr2[1] = new String[5];
				
				System.out.println(strArr[0].length);
				System.out.println(strArr[1].length);
				
	}

}
