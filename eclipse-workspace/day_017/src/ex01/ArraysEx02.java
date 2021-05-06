package ex01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysEx02 {

	public static void main(String[] args) {
		Integer[] nums = { 5, 2, 3, 1, 4 };
		
		// 정렬
		Arrays.sort( nums );
		System.out.println( Arrays.toString( nums ) );
		
		// 아스키 코드기준 정렬
		String[] names = { "xMan", "Alex", "XMan", "Bob", "Curl", "flex", "alex" };
		Arrays.sort( names );
		System.out.println( Arrays.toString( names ) );
		
		// 배열 -> list -> 배열
		List<String> lists = Arrays.asList( names );
		
		// 아래 코드는 강제 형변환에서 문제가 생김
		// ArrayList<String> lists = (ArrayList<String>)Arrays.asList(names);
		
		for( String list : lists ) {
			System.out.println( list );
		}
	}
}