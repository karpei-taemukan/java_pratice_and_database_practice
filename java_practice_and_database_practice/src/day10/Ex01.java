package day10;

public class Ex01 {

	public static void main(String[] args) {
/*
 * 		index    [0]|[1]|[2]
 * 				  11| 12| 13
 * 	
 * 		index    [0]|[1]|[2]
 * 		 [0]	  11| 12| 13	
 * 	     [1]	  14| 15| 16
 *  	 [2]	  17| 18| 19
 * */		

		int scores[][] = {{11,12,13},{14,15,16},{17,18,19}};
	
			for(int i=0; i<3; i++) {
				for(int k=0; k<3; k++) {
					System.out.println(scores[i][k]);
				}
			}
			
			int scores2[][] = {{1,2,3},{4,5,6,7,8},{9,10}};
			
			/*		index    [0]|[1]|[2]
 * 					 [0]	  1| 2  | 3	|   |   => 4번째, 5번째 index 자체가 없다
 * 	    			 [1]	  4| 5  | 6 | 7 | 8
 *  				 [2]	  9| 10 |   |   |   => 4번째, 5번째, 6번째 index 자체가 없다
			 */
	
			System.out.println("row's count: "+ scores2.length);
			System.out.println("0 row size: "+scores2[0].length);
			System.out.println("1 row size: "+scores2[1].length);
			System.out.println("2 row size: "+scores2[2].length);
	}
}
