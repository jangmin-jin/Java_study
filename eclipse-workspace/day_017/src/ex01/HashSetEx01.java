package ex01;

import java.util.HashSet;

public class HashSetEx01 {

	public static void main(String[] args) {
		HashSet<String> hs1 = new HashSet<String>();
		hs1.add( "아메리카노" );
		hs1.add( "카페라떼" );
		hs1.add( "에스프레소" );
		hs1.add( "에스프레소" );
		hs1.add( "에스프레소" );
		hs1.add( "에스프레소" );
		hs1.add( "카라멜마끼아또" );
		
		System.out.println( hs1.size( ) );
		System.out.println( hs1.toString( ) );
		
		for (String str : hs1) {
			System.out.println( str );
		}
	}
}