package ex02;

public class CapitalizeEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 입력
		String str1 = ( "hong gil dong2" );
		String[ ] arr1 = str1.split( " " );
		
		// 처리
		for( int i = 0; i <= 2; i++ ) {
			arr1[ i ] = arr1[ i ].substring( 0, 1 ).toUpperCase( ) + arr1[i].substring( 1 );
		};
		String str2 = String.join( " ", arr1 );
		
		// 출력
		System.out.println( str2 );
	}
}