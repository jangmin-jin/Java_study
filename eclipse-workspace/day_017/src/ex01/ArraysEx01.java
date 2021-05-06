package ex01;

import java.util.Arrays;

public class ArraysEx01 {

	public static void main(String[] args) {
		String[] arrs = { "aaa", "bbb", "ccc" };
		
		System.out.println( arrs );
		System.out.println( arrs.toString( ) ); // 이래도 주소 나옴
		
		// Arrays를 이용한 Array toString 출력
		System.out.println( Arrays.toString( arrs ) );
		
		// 채우기
		Arrays.fill( arrs, "xxx");
		System.out.println( Arrays.toString( arrs ) );
		
		// 원하는 위치에 채우기
		Arrays.fill( arrs, 0, 2, "yyy");
		System.out.println( Arrays.toString( arrs ) );
		
		// 배열 내용 비교
		String[] arrs1 = { "aaa", "bbb", "ccc" };
		String[] arrs2 = { "ccc", "bbb", "aaa" };
		
		// 참조 주소 비교
		System.out.println( arrs1 == arrs2 );    // false
		// 순서 참조 비교
		System.out.println( Arrays.equals( arrs1, arrs2 ) );	// false
	}
}