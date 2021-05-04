package ex02;

import java.util.Date;

public class DateEx03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date d1 = new Date( );
		System.out.println( d1.getTime( ) );    // timestamp
		
		// Date d2 = new Date( d1.getTime( ) );
		Date d2 = new Date( System.currentTimeMillis( ) );
		System.out.println( d2.toLocaleString( ) );
		
		// 시간차를 구하는 방법
		Date d3 = new Date( 2021 - 1900, 5-1, 3);
		long timeGap = d1.getTime( ) - d3.getTime( );
		System.out.println( "시간차 : " + timeGap/1000/60/60 );
	}
}