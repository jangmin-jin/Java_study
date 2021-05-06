package day_017_practice1;

import java.util.Arrays;
import java.util.Random;

public class LottoGeneratorByArray {

	public static void main(String[] args) {
		// 로또 한줄 받고 정렬해서 뱉어주는 녀석 작성
		int arr[] = new int[6];
		Random rand = new Random();
		for (int i = 0 ; i < arr.length; i++) {
			arr[i] = rand.nextInt(45) + 1;
		}
		for ( int value : arr ) {
			System.out.print(value + " ");
		}
		System.out.println( );
		
		Arrays.sort(arr);
		for (int value : arr) {
			System.out.print( value + " " );
		}
		System.out.println( );
	}

}