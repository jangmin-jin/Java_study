package ex03;

import java.util.ArrayList;
import java.util.Date;

public class ArrayListEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 여러 자료형이 들어가지만 가능한 통일해 주는게 편하다
		// 저장 공간
		ArrayList al1 = new ArrayList( );
		ArrayList al2 = new ArrayList( 100 );
		
		al1.add( "홍길동" );
		al1.add( new String( "박문수" ) );
		al1.add( new Date( ) );
		
		System.out.println( al1.size( ) );       // Array 개수 출력
		System.out.println( al1.toString( ) ); // 전부 출력
		System.out.println( al1.get( 0 ) );    // 0번째 값 출력
		
		// 이런식으로 선언 / 출력이 가능하다
		Object obj1 = al1.get( 0 );
		String str1 = ( String )obj1;		// 강제 형변환 시켜줘야함
		System.out.println( str1 );
		
		Object obj2 = al1.get(2);
		Date date1 = ( Date )obj2;		// 강제 형변환 시켜줘야함
		System.out.println( date1.toLocaleString( ) );
		
	}
}