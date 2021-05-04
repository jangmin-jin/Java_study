package ex02;

public class StringEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 문자열 저장
		// String / StringBuffer / StringBuilder
		
		// 단순 String 선언 방법
		String str1 = "Hello String";
		
		// 생성자 이용 단일 문자열 생성 방법
		String str2 = new String( "Hello String str2" );
		
		// 생성자 이용 배열 생성 방법
		char[] charArray = { 'H', 'e', 'l', 'l', 'o' };
		String str3 = new String( charArray );
		
		System.out.println( str1 );
		System.out.println( str2 );
		System.out.println( str3 );
		
		// ==( 참조값 비교 ) / equals( 내용값 비교 )
		// toString( default : 참조값, override : 내용값)
	}
}
