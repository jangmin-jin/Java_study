package ex02;

import java.text.DecimalFormat;
import java.text.ParseException;

public class DecimalFormatEx01 {

	public static void main(String[] args) throws ParseException{
		// 형식화된 문자열 - String.format( );
		// 숫자 / 날짜 등
		
		String strFormat = String.format( "$%s, %s", "10", "000");
		System.out.println( strFormat );
		
		// 숫자 -> 형식화된 문자열
		// 자동으로 반올림도 해준다.
		DecimalFormat df = new DecimalFormat( "$#,###.##" );
		double orgNum = 12345.0;
		double orgNum2 = 12345.123;
		System.out.println( df.format( orgNum ) );
		System.out.println( df.format( orgNum2 ) );
		
		// .parse를 이용하여 변환
		String strNum = "$1,234,567.891";
		// String -> double 변환
		double parsedNum = (double)df.parse( strNum );
		System.out.println( parsedNum );
	}
}