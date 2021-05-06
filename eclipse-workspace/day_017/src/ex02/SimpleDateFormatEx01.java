package ex02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatEx01 {

	public static void main(String[] args) throws ParseException{
		String source = "2021년 5월 6일";
		
		SimpleDateFormat format = new SimpleDateFormat( "YYYY년 MM월 DD일" );
		Date parsedDate = format.parse(source);
		System.out.println( parsedDate.toLocaleString( ) );
	}
}