package day_017_practice1;

import java.util.Arrays;
import java.util.Random;

public class Sorting {

	public static void main(String[] args) {
		Random rand = new Random();
		int temp = 0;
		int[] arr = new int[10];
		for( int i = 0; i < 10; i++) {
			arr[i] = rand.nextInt(100);
		}
		System.out.println("초기값");
		for(int value : arr) {
			System.out.print(value + " ");
		}
		System.out.println( );
				
		// 정렬
		for( int i = 0; i < arr.length -1; i++) {
			for ( int j = 0; j < arr.length -1; j++) {
				if ( arr[j] > arr[j+1] ) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		// 정렬 - Arrays import 사용
		// System.out.println( "정렬 완료값" );
		// Arrays.sort(arr);
		// for(int value : arr) {
		//	System.out.print(value + " ");
		//}
		
		// 정렬 완료
		System.out.println( "정렬 완료값" );
		for(int value : arr) {
			System.out.print(value + " ");
		}
	}
}