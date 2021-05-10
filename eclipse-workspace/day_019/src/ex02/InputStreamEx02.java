package ex02;

import java.io.IOException;
import java.io.InputStream;

public class InputStreamEx02 {

	public static void main(String[] args) {
		
		// InputStream을 이용한 입력 환경 만들기
		InputStream is = null;
		
		try {
			// 한글은 못받아준다.
			is = System.in ;
			System.out.print( "입력 : " );
			
			int data = 0;
			// 13 = 엔터키
			while ( (data = is.read() ) != 13) {
				System.out.println( "입력내용 : " + (char)data );
			}
			
		} catch (IOException e) {
			System.out.println( "에러 : " + e.getMessage() );
		} finally {
			if ( is != null ) try { is.close(); } catch( IOException e) {}
		}
	}
}