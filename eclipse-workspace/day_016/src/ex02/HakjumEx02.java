package ex02;

import java.util.Scanner;

public class HakjumEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print( "점수 > " );

		// 스트링으로 받고 변환 해주어도 상관없다.
		String point = sc.nextLine( );
		int intpoint = Integer.parseInt( point );
		sc.close();
		
		if( intpoint >= 90 ) {
			System.out.println( "학점은 A 입니다");
		}else if( intpoint >= 80) {
			System.out.println( "학점은 B 입니다");
		}else if( intpoint >= 70) {
			System.out.println( "학점은 C 입니다");
		}else if( intpoint >= 60) {
			System.out.println( "학점은 D 입니다");
		}else {
			System.out.println( "학점은 F 입니다");
		}
	}
}