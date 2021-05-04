package ex02;

import java.util.Date;

public class DateEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date d1 = new Date( ); // 선언한 순간 현재 날짜/시간이 들어감
		Date d2 = new Date(2014 - 1900, 1 - 1, 14);
		// 시간은 안들어가서 무조건 오전 12:00:00 고정
		System.out.println( d2.toLocaleString( ) );
		System.out.println( d2.getDay( ) );
		
		// 지정한 날짜의 getDay() (요일값) 도 구할 수 있다
		Date d3 = new Date(2021 - 1900, 12 - 1, 25);
		System.out.println( d3.getDay( ) );
	}
}