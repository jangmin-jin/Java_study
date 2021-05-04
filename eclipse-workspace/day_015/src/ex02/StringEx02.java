package ex02;

public class StringEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str1 = "Hello String";
		
		// 문자열의 길이
		System.out.println( str1.length( ) );
		System.out.println( "Hello".length( ) );
		
		// 문자 추출
		char ch1 = str1.charAt( 0 );
		char ch2 = str1.charAt( str1.length( ) -1 );
		System.out.println( ch1 );
		System.out.println( ch2 );
		
		// 문자열 추출 ( 활용도가 높음 )
		String pstr1 = str1.substring( 2 );
		System.out.println( pstr1 );
		
		// 2 <= x < 4
		String pstr2 = str1.substring( 2, 4 );
		System.out.println( pstr2 );
		
		// 문자열 위치
		System.out.println( str1.indexOf( 'l' ) );
		System.out.println( str1.indexOf( "ll" ) );
		System.out.println( str1.indexOf( 'o', 5 ) );
		System.out.println( str1.lastIndexOf( 'o', 5 ) );
		
		// 문자열 존재 검색
		// startsWith / contains / endsWith = true / false
		System.out.println( str1.startsWith( "h" ) );     // false
		System.out.println( str1.startsWith( "H" ) );    // true
		
		// 문자열 치환
		System.out.println( str1.replaceAll( "Hello", "안뇽") );
		
		// 문자열 결합 ( + 로 간단하게 해도 됨 )
		System.out.println( str1.concat( " 안녕" ) );
		
		// 대소문자 변경
		System.out.println( str1.toUpperCase( ) );
		System.out.println( str1.toLowerCase( ) );
		
		// 앞뒤 공백 제거
		String str2 = "          Hello          ";
		System.out.println( str2.length( ) );
		
		// 중간 공백 빼고 앞뒤의 공백을 지워버림
		String str21 = str2.trim( );
		System.out.println( str21.length( ) );
		
		// 구분자 단위로 분리 .split("구분자", 갯수);
		String str3 = "apple,banana,pineapple,kiwi";
		String[] strArray1 = str3.split( "," );
		for(String str : strArray1) {
			System.out.println( str );
		}
		
		// 구분자 단위를 기준으로 합치기
		String str4 = String.join( ",", strArray1);
		System.out.println( str4 );
		
		String str5 = strArray1[0] + strArray1[1] + strArray1[2];
		System.out.println( str5 );
		
		// format - System.out.printf
		String str6 = String.format( "%s,%s,%s", strArray1[0], strArray1[1], strArray1[2]);
		System.out.println( str6 );
	}
}
