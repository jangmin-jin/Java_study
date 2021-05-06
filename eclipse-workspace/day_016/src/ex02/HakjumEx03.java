package ex02;

import java.util.Scanner;

public class HakjumEx03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner( System.in );
		
		while( true ) {

			System.out.print( " 입력 > " );
			
			// String data = sc.nextLine( ); 스트링값으로 받을 수도 있음
			int data = sc.nextInt( );
			if ( data == 0 ) {
				break;
			}else {
				System.out.println( " 데이터 : " + data );
			}
			sc.close( );
		}
	}
}