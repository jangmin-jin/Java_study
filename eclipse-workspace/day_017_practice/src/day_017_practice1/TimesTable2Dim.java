package day_017_practice1;

public class TimesTable2Dim {

	public static void main(String[] args) {
		int[][] gugu = new int[9][9];
		System.out.println( "gugu의 길이 : " + gugu.length );
		System.out.println( "gugu의 0번째 요소의 길이 : " + gugu[0].length );
		// 배열에 구구단 저장
		for ( int i = 0 ; i < gugu.length; i++ ) {
			for ( int j = 0 ; j < gugu[0].length; j++) {
				gugu[i][j] = (i+1) * (j+1);
			}
		}
		
		for ( int i = 0 ; i < gugu.length; i++ ) {
			for ( int j = 0 ; j < gugu[0].length; j++) {
				System.out.print( gugu[i][j] + "\t" );
			}
			System.out.println( );
		}
	}
}