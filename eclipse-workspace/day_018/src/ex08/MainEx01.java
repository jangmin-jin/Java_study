package ex08;

import java.util.Calendar;

public class MainEx01 {

	public static void main(String[] args) {
		
		// 문자열이 아니라 상수 값임
		System.out.println( Grade.SALES );
		
		// Calender도 비슷한 원리
		Calendar c = Calendar.getInstance( );
		System.out.println( c.get( Calendar.YEAR ) );
		
		// 이렇게 변수에 넣어 선언도 가능
		Grade grad = Grade.SALES;
		System.out.println( grad );
		
	}
}