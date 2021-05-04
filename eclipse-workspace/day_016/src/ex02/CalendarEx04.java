package ex02;

import java.util.Calendar;

public class CalendarEx04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 달력 만들기
		// 초기 날자 세팅 / 년/ 월
		int year = 2021;
		int month = 5;
		
		// 1일의 요일
		int startDayOfWeek = 0;
		// 마지막날 요일
		int endDay = 0;
		Calendar startCalendar = Calendar.getInstance( );
		Calendar endCalendar = Calendar.getInstance( );
		
		startCalendar.set( year, month-1, 1 ); // 1일
		endCalendar.set( year, month, 1-1 );   // 마지막날
		startDayOfWeek = startCalendar.get( Calendar.DAY_OF_WEEK );
		endDay = endCalendar.get( Calendar.DATE );
		
		// 6개 공백
		System.out.println( "      " + year + "년 " + month + "월 " );
		System.out.println( " SU MO TU WE TH FR SA" );
		
		for( int i = 1; i<startDayOfWeek; i++ ) {
			System.out.print( "   " );    // 3개 공백
		}
		for( int i = 1, n=startDayOfWeek; i <= endDay; i++, n++ ) {
			System.out.print( (i<10) ? "  " + i : " " + i );  // 공백 2개 / 1개
			if ( n%7 == 0 ) {
				System.out.println( );
			}
		}
	}
}