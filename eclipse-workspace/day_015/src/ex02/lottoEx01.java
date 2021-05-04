package ex02;

public class lottoEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 선언부
		int[][] lottoNum = new int[5][6];
		
		// 입력부
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 6; j++) {
				lottoNum[i][j] = ( int )(( Math.random( ) * 45) + 1);
			}
		}
		
		// 출력부
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 6; j++) {
				System.out.print( lottoNum[i][j] + " ");
			}
			System.out.println( );
		}
		
	}
}
