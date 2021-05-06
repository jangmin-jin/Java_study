package day_017_practice1;

public class SimpleInitTest {

	public static void main(String[] args) {
		// HELLO / JAVA / WORLD를 글자하나하나 쪼개서 2차원 배열에 저장
		// 2중 for문을 이용하여 출력
		
		Character c1[][] = {
				{'H', 'E', 'L', 'L', 'O'},
				{'J', 'A', 'V', 'A'},
				{'W', 'O', 'R', 'L', 'D'}
		};
		
		for ( int i = 0;  i< c1.length; i++) {
			for ( int j = 0; j < c1[i].length; j++) {
				System.out.print( c1[i][j] );
			}
			System.out.println( );
		}
	}
}