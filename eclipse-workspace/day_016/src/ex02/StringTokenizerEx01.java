package ex02;

import java.util.StringTokenizer;

public class StringTokenizerEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// split 이랑 같은 기능해줌
		String data = "사과 배 복숭아 도지";
		// 구분자에 의해 자동으로 분류가 된다.
		StringTokenizer st = new StringTokenizer( data );
		// 잘린 조각이 몇개니
		System.out.println( st.countTokens( ) );
		
		// 데이터 출력
		// System.out.println( st.nextToken( ) );
		// System.out.println( st.nextToken( ) );
		// System.out.println( st.nextToken( ) );
		// System.out.println( st.hasMoreTokens( ) );
		
		while( st.hasMoreTokens( ) ) {
			System.out.println( st.nextToken( ) );
		}
		
		// 다른 구분자 구별하는 방법
		String data2 = "사과&배&복숭아&도지";
		StringTokenizer st2 = new StringTokenizer( data2, "&" );
		while ( st2.hasMoreTokens( ) ) {
			System.out.println( st2.nextToken( ) );
		}
	}
}