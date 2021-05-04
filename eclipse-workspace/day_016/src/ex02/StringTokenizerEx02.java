package ex02;

import java.util.StringTokenizer;

public class StringTokenizerEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// StringTokenizer 같은 경우 나눳을때 공백이 들가는 부분을 자동으로 지워준다.
		String data1 = "사과&참외&&수박&&&딸기";
		StringTokenizer st1 = new StringTokenizer( data1, "&" );
		System.out.println( st1.countTokens( ) );    // 4
		
		while( st1.hasMoreTokens( ) ) {
			System.out.println( st1.nextToken( ) );
		}
		
		// split 으로 구분할 경우 공백이 들어가는 데이터가 생긴다.
		String data2[] = data1.split( "&" );
		System.out.println( data2.length );    		 // 7
		for ( String arr : data2) {
			System.out.println( arr );
		}
	}
}