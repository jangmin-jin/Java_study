package ex01;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedInputStreamEx01 {

	public static void main(String[] args) {
		// bufferedInputStream 쓰려면 FileInputStream이 필요
		// FileInputStream fis = null;
		BufferedInputStream bis = null;
		
		try {
			// fis = new FileInputStream("./gugudan.txt");
			// bis = new BufferedInputStream( fis );
			bis = new BufferedInputStream( new FileInputStream("./gugudan.txt") );
			
			int data = 0;
			// fis에서 읽으면 1차 스트림, bis에서 읽으면 2차 스트림
			while( (data = bis.read() ) != -1 ) {
				System.out.print( (char)data );
			}
		} catch (FileNotFoundException e) {
			System.out.println( "에러 : " + e.getMessage() );
		} catch (IOException e) {
			System.out.println( "에러 : " + e.getMessage() );
		} finally {
			// if ( fis != null ) try { fis.close( ); } catch (IOException e) {}
			if ( bis != null ) try { bis.close( ); } catch (IOException e) {}
		}
	}
}