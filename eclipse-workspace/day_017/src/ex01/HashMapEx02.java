package ex01;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class HashMapEx02 {

	public static void main(String[] args) {
		HashMap<String, String> hm1 = new HashMap<String, String>();
		hm1.put( "a1", "홍길동" );
		hm1.put( "a2", "박문수" );
		hm1.put( "a3", "이몽룡" );
		
		// key 모음
		Set<String> keys = hm1.keySet( );
		for( String key : keys ) {
			System.out.println( key + " : " + hm1.get( key ) );
		}
		
		// value 모음
		Collection<String> values = hm1.values( );
		for( String value : values ) {
			System.out.println( value );
		}
		
		// String, Student 인 HashMap 데이터 가져오기
		HashMap<String, Student> hm2 = new HashMap<String, Student>();
		hm2.put( "a1", new Student( "1001", "홍길동" ) );
		hm2.put( "a2", new Student( "1002", "박문수" ) );
		hm2.put( "a3", new Student( "1003", "이몽룡" ) );
		
		// 데이터 출력
		Set<String> keys2 = hm2.keySet( );
		for(String key : keys2) {
			System.out.println( key + " : " + hm2.get( key ).getHakbun( ) + " : " + hm2.get(key).getName( ) );
		}
		
		// values 값 뽑아오기
		Collection<Student> values2 = hm2.values( );
		for( Student stu : values2 ) {
			System.out.print( stu.getHakbun( ) );
			System.out.println( stu.getName( ) );
		}
	}
}