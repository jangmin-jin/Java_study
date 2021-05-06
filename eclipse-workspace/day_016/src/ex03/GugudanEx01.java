package ex03;

import java.util.Scanner;

public class GugudanEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 스캐너 선언
		Scanner inputDan = new Scanner(System.in);
		
		// 입력단 및 값 할당
		System.out.print( "시작단 > " );
		int startDan = inputDan.nextInt( );
		System.out.print( "끝단 > " );
		int endDan = inputDan.nextInt( );
		
		// 시작단 > 끝단 일경우 재입력 실행
		while( startDan > endDan ) {
			inputDan = new Scanner(System.in);
			System.out.print( "시작단을 다시 입력하세요 > " );
			startDan = inputDan.nextInt();
			System.out.print( "끝단을 다시 입력하세요 > " );
			endDan = inputDan.nextInt( );
		}
		
		// 구구단 출력
		for ( int i = startDan; i <= endDan; i++ ) {
			for( int j = 1; j <= 9; j++) {
				System.out.print( i + "X" + j + "=" + (i*j) + "\t" );
			}
			System.out.println( );
		}
		
		// 입력 최종 종료
		inputDan.close( );
	}
}