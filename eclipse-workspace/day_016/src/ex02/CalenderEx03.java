package ex02;

import java.util.Calendar;

public class CalenderEx03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar c = Calendar.getInstance( );
		System.out.println( c.getTime( ) );
		
		// 하루 증가
		c.add( Calendar.DATE, 1 );
		System.out.println( c.getTime( ) );
		
		// 하루 감소
		c.add( Calendar.DATE, -1 );
		System.out.println( c.getTime( ) );
		
		// 100일 증가
		c.add( Calendar.DATE, 100 );
		System.out.println( c.getTime( ) );
	}
}