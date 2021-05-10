package ex02;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputStreamEx03 {

	public static void main(String[] args) {
		
		// InputStreamReader를 이용한 입력 환경 만들기
		InputStreamReader isr = null;
		
		try {
			// 한글을 받아 줄 수 있다.
			isr = new InputStreamReader(System.in) ;
			System.out.print( "입력 : " );
			
			int data = 0;
			// 13 = 엔터키
			while ( (data = isr.read() ) != 13) {
				System.out.println( "입력내용 : " + (char)data );
			}
			
		} catch (IOException e) {
			System.out.println( "에러 : " + e.getMessage() );
		} finally {
			if ( isr != null ) try { isr.close(); } catch( IOException e) {}
		}
	}
}