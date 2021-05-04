package ex02;

public class lottoEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for( int i = 1 ; i <= 5; i++) {
			for ( int j = 1 ; j <= 6; j++) {
				System.out.print( ( int )( Math.random( ) * 45 ) + 1 + "\t" );
			}
			System.out.println( );
		}
	}
}