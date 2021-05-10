package ex02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputStreamEx04 {

	public static void main(String[] args) {
		
		// InputStreamReader를 이용한 입력 환경 만들기
		// InputStreamReader isr = null;
		BufferedReader br = null;
		
		try {
			// 한글을 받아 줄 수 있다.
			br = new BufferedReader(new InputStreamReader(System.in)) ;
			System.out.print( "입력 : " );
			
			String data = null;
			while( (data = br.readLine() ) != null) {
				System.out.println( "입력내용 : " + data );
			}
			
		} catch (IOException e) {
			System.out.println( "에러 : " + e.getMessage() );
		} finally {
			if ( br != null ) try { br.close(); } catch( IOException e) {}
		}
	}
}