package day_017_practice1;

import java.util.Arrays;
import java.util.Random;

public class LottoGeneratorByArray2 {

	public static void main(String[] args) {
		// selected 배열 선언
		// 번호 생성을 위한 배열 fullBall 선언
		int selected[] = new int[6];
		int fullBall[] = new int[45];
		
		int count = 0;
		Random rand = new Random();
		while( count < 6) {
			int index = rand.nextInt(45);
			int ball = fullBall[index]; 
			if ( ball == 0 ) {
				selected[count] = index + 1;
				count++;
				fullBall[index] = -1;
			}
		}
		Arrays.sort(selected);
		for( int value : selected) {
			System.out.print( value + " " );
		}
	}
}