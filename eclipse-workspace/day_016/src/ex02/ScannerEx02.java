package ex02;

import java.util.Scanner;

public class ScannerEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.print( "입력> " );
		
		// 한줄 입력
		String msg = sc.nextLine( );

		System.out.println( "입력 메세지1 : " + msg );
		sc.close( );
	}
}