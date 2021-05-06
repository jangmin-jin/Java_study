package ex02;

import java.util.Scanner;

public class ScannerEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Scanner 를 이용하여 데이터 받기
		// 명령프롬프트 또는 파일 입력으로도 가능함
		
		// System.in - 키보드(표준 입력장치)를 통한 입력
		Scanner sc = new Scanner(System.in);
		System.out.print( "입력> " );
		String msg1 = sc.next( );  // 스페이스바 (공백 기준) 자동 분리됨
		String msg2 = sc.next( );  // " 이안에 문장을 넣어도 " 공백 기준으로 잘려나옴
		
		System.out.println( "입력 메세지1 : " + msg1 );
		System.out.println( "입력 메세지2 : " + msg2 );
		sc.close( );
	}
}