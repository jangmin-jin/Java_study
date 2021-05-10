package ex02;

import java.io.IOException;
import java.io.InputStream;

public class InputStreamEx01 {

	public static void main(String[] args) {
		
		// InputStream을 이용한 입력 환경 만들기
		InputStream is = null;
		
		try {
			is = System.in ;
			System.out.print( "입력 : " );
			// askII 형식으로 한글자씩 읽어온다.
			System.out.println( " 입력 내용 : " + is.read() );
			// char 형식으로 한글자씩 읽어온다.
			System.out.println( " 입력 내용 : " + (char)is.read() );
		} catch (IOException e) {
			System.out.println( "에러 : " + e.getMessage() );
		} finally {
			if ( is != null ) try { is.close(); } catch( IOException e) {}
		}
	}
}