package ex03;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet hs = new HashSet( );
		
		// 데이터 순서는 지 멋대로 들어감
		// 중복값 허용 안함
		hs.add( "아메리카노" );
		hs.add( "에스프레소" );
		hs.add( "카푸치노" );
		hs.add( "에스프레소" );
		hs.add( "카푸치노" );
		hs.add( "에스프레소" );
		hs.add( "카푸치노" );
		hs.add( "에스프레소" );
		hs.add( "카푸치노" );
		
		System.out.println( hs.size( ) );
		System.out.println( hs.toString( ) );
		
		// index를 통한 제거가 안됨
		// hs.remove( "아메리카노" );
		// System.out.println( hs.toString( ) );
		
		// hs.clear( );
		// System.out.println( hs.toString( ) );
		
		// iterator를 이용하여 뽑아낼 수 있다.
		// 인덱스가 없기 때문에 이러한 방법을 이용(구형임 근데)
		Iterator i = hs.iterator( );
		while( i.hasNext( ) ) {
			System.out.println( (String)i.next( ) );
		}
		
		// 향상된 for문을 사용하면 한방에 뽑혀나온다
		for ( Object obj : hs ) {
			System.out.println( (String)obj );
		}
	}
}