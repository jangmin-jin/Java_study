package ex02;

// ctrl + shift + O 누르면 자동으로 import 잡아줌
import java.util.Date;

public class DateEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 날짜 / 시간
		// Date / Calendar
		// java.util.Date d1 = new java.util.Date( );
		Date d1 = new Date( );
		
		// Date 클래스에서 overiding 된거임
		System.out.println( d1.toString( ) );
		// deprecated - 이제 곧 없어질 기능임
		System.out.println( d1.toLocaleString( ) );
		
		// 년 월 일만 출력하는 구문
		String strDate = d1.toLocaleString( );
		System.out.println( strDate );
		System.out.println( strDate.substring(0, 4) );
		System.out.println( strDate.substring(5, 7) );
		System.out.println( strDate.substring(8, 10) );
		
		// 년 월 일만 출력하는 구문을 만들어봐라
		String Date[] = new String[3];
		String DateSplit[] = d1.toLocaleString( ).split(" ");
		System.out.println( DateSplit[0] );
		System.out.println( DateSplit[1] );
		System.out.println( DateSplit[2] );
		
		// 그냥 내부 기능으로 바로 뽑아내는 방법
		System.out.println( d1.getYear( ) + 1900 );
		System.out.println( d1.getMonth( ) + 1 );
		System.out.println( d1.getDate( ) );
		System.out.println( d1.getHours( ) );
		System.out.println( d1.getDay( ) ); // 0: 일요일 1: 월요일 2: 화요일 ...
		
		// switch 문으로 요일을 바로 출력할 수 있다.
		String day = "";
		switch( d1.getDay() ) {
			case 0: day = "일요일" ; break;
			case 1: day = "월요일" ; break;
			case 2: day = "화요일" ; break;
			case 3: day = "수요일" ; break;
			case 4: day = "목요일" ; break;
			case 5: day = "금요일" ; break;
			case 6: day = "토요일" ; break;
		}
		System.out.println( day );
		
		// 배열을 이용하여 요일을 바로 출력할 수 있다.
		String days[] = {"일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"};
		System.out.println( days[d1.getDay( )] );
	}
}