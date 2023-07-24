package day08;

public class Ex01 {

	public static void main(String[] args) {
		int sum = 0;
		int[] score = {80,88,90,78,100};
		
		for(int i=0; i<score.length; i++) {
			System.out.println(score[i]);
		}
		for(int i=0; i<score.length; i++) {
			if(score[i] == 90) {
				System.out.println(i);
				score[i]=95;
				System.out.println(score[i]);
			}
		}
		
		for(int i=0; i<score.length; i++) {
			sum+=score[i];
			System.out.println(sum);
			System.out.println((float)sum/(score.length));
		}
		
				}

}
