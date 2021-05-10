package ex01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamEx02 {

	public static void main(String[ ] args) {
		// InputStream(1byte) - File =>
		
		FileInputStream fis = null;
		try {
			// 절대 경로
			// fis = new FileInputStream( "c:/java/test.txt" );
			// 상대 경로
			fis = new FileInputStream( "./newtest.txt" );
			
			
			int data = 0;
			while ( (data = fis.read( ) ) != -1 ){
				// 윈도우 : \r\n , 리눅스 : \n
				// 엔터키가 진짜 히든인지 확인
				if( data == '\r') {
					System.out.print( "(r)" );
				}else if ( data == '\n') {
					System.out.print( "(n)" );
				}else {
					System.out.print( (char)data );
				}
				
				// 엔터키가 히든값인데 읽어들임
			    // System.out.print( (char)data );
			}
			
		} catch ( FileNotFoundException e ) {
			System.out.println( "에러 : " + e.getMessage() );
		} catch ( IOException e ) {
			System.out.println( "에러 : " + e.getMessage() );
		}finally {
			if( fis != null ) try { fis.close( ); } catch( IOException e ) { }
		}
	}
}