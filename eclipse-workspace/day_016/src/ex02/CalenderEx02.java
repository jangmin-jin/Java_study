package ex02;

import java.util.Calendar;

public class CalenderEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar c = Calendar.getInstance( );
		
		// 5월 1일에서 1일 빼면 4월 마지막날로 감
		c.set( 2021, 5-1, 3 );
		System.out.println( c.getTime( ) );
		
		Calendar c2 = Calendar.getInstance( );
		long timeGap = c2.getTimeInMillis( ) - c.getTimeInMillis( );
		System.out.println( "timeGap : " + timeGap/1000 );
		System.out.println( "timeGap : " + timeGap/1000/60 );
		System.out.println( "timeGap : " + timeGap/1000/60/60 );
	}
}