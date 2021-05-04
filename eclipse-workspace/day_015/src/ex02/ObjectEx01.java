package ex02;

public class ObjectEx01 /* extends Object */ {

	public static void main( String[] args ) {
		// TODO Auto-generated method stub
		Object o1 = new Object( );
		
		// *객체변수 = 객체변수.toString()
		// 클래스형태 @참조주소
		System.out.println( o1 );					// java.lang.Object@182decdb
		System.out.println( o1.toString( ) );    // java.lang.Object@182decdb
		
		ObjectEx01 o2 = new ObjectEx01( );
		System.out.println( o2 );					// ex02.ObjectEx01@7637f22
		System.out.println( o2.toString( ) );    // ex02.ObjectEx01@7637f22
		
		// 클래스에 대한 정보를 가져오는 방법
		System.out.println( o1.getClass ( ).getName( ) ); // java.lang.Object
		System.out.println( o1.hashCode( ) ); 			   // 405662939
		System.out.printf( "%x\n", o1.hashCode( ) );    // 182decdb
		
		// 오버라이딩
		String str = new String( "Hello java object" );
		System.out.println( str );
		System.out.println( str.toString( ) );
		
		Student s = new Student( "홍길동", 30 );
		System.out.println( s );
		// toString의 용도는 클래스 내부의 맴버필드 내용을 출력할 목적으로 미리 Object 클래스에 선언
		System.out.println( s.toString( ) );                 // 오버라이딩 안하면 11,12,15,16번 줄 형식처럼 나옴
	}
}