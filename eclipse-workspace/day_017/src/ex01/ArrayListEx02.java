package ex01;

import java.util.ArrayList;

public class ArrayListEx02 {

	public static void main(String[] args) {
		// ArrayList 데이터의 형태를 지정 = 제네릭
		ArrayList<String> al1 = new ArrayList<String>( );
		ArrayList<String> al2 = new ArrayList<>( );  // 안써줘도 따라감 (버전에 따라 다름)
		
		al1.add( "홍길동" );
		// al1.add( 1 ); // 스트링이 아닌 자료는 에러
		al1.add( "박문수" );
		al1.add( "이몽룡" );
		
		// 애초에 String으로 받았기 때문에 Obj -> String 변환 해 줄 필요도 없다.
		for( String str : al1) {
			System.out.println( str );
		}
		
		ArrayList<Student> al3 = new ArrayList<Student>();
		
		al3.add( new Student( "1001" , "홍길동" ));
		al3.add( new Student( "1002" , "박문수" ));
		al3.add( new Student( "1003" , "이몽룡" ));
		
		for(Student stu : al3) {
			System.out.println( stu.getHakbun( ) );
			System.out.println( stu.getName( ) );
		}
		
		// autoboxing unboxing - wrapper
		ArrayList<Integer> al4 = new ArrayList<Integer>();
		al4.add( Integer.valueOf(3));
		al4.add( 4 );
		al4.add( 5 );
		
		int sum = al4.get( 0 ) + al4.get( 1 );
		System.out.println( sum );

		for ( int i : al4) {
			System.out.println( i );
		}
	}
}