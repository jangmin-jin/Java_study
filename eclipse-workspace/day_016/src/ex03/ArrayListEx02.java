package ex03;

import java.util.ArrayList;

public class ArrayListEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList al1 = new ArrayList( );
		
		al1.add( "길동홍" );
		al1.add( "문수팍" );
		al1.add( "몽룡이" );
		
		// 출력 방법들
		for ( int i = 0; i < al1.size( ); i++) {
			String data = ( String )al1.get( i );
			System.out.println( data );
		}
		
		for( Object obj : al1) {
			System.out.println( ( String )obj );
		}
		
		for( int i = 0; i < al1.size( ); i++) {
			System.out.println( al1.get( i ) );
		}
		
		// 추가 데이터
		// 원하는 위치에 추가
		al1.add( 2, "꺽정임" );
		System.out.println( al1 ); // [길동홍, 문수팍, 꺽정임, 몽룡이]
		
		// 데이터 수정
		al1.set( 0, "자방" );
		System.out.println( al1 ); // [자방, 문수팍, 꺽정임, 몽룡이]
		
		// 일부 삭제
		al1.remove( 0 );
		System.out.println( al1 ); // [문수팍, 꺽정임, 몽룡이]
		
		// 전체 삭제
		al1.clear();
		System.out.println( al1 );
		System.out.println( al1.size( ) );
	}
}