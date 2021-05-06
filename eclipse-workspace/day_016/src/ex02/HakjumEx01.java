package ex02;

import java.util.Scanner;

public class HakjumEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int hakjum = 0;
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.print( "점수 > " );

			// 바로 인트값으로 받을 수 있다.
			hakjum = sc.nextInt( );	
			
			if( hakjum >= 90) {
				System.out.println( "학점은 A 입니다" );
			}else if( hakjum >= 80) {
				System.out.println( "학점은 B 입니다");
			}else if( hakjum >= 70) {
				System.out.println( "학점은 C 입니다");
			}else if( hakjum >= 60) {
				System.out.println( "학점은 D 입니다");
			}else if( hakjum >= 1){
				System.out.println( "학점은 F 입니다");
			}
			
			if( hakjum == 0 ) {
				sc.close( );
				return;
			}
		}
	}
}