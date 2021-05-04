package ex02;

public class ObjectEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Object o1 = new Object( );
		Object o2 = new Object( );
		
		// 참조값을 비교
		System.out.println( o1 == o2 );			  // false
		System.out.println( o1.equals( o2 ) );     // false
		
		// String은 자동 오버라이드 되나벼
		String str1 = new String( "문수팍" );
		String str2 = new String( "문수팍" );
		
		// 참조값을 비교
		System.out.println( str1 == str2 );   	  // false
		// 데이터를 비교하도록 오버라이딩 시킴
		System.out.println( str1.equals( str2 ) );  // true
		
		Student s1 = new Student( "홍길동", 23 );
		Student s2 = new Student( "홍길동", 23 );
		
		// 비교 ( 참조값 / 내용 )
		System.out.println( s1 == s2 );			  // false
		System.out.println( s1.equals( s2 ) );	  // false
	}
}
