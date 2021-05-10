package ex01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamEx01 {

	public static void main(String[ ] args) {
		// InputStream(1byte) - File =>
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream( "c:/java/test.txt" );
			
			// 1byte 읽어들임 / char읽으려면 (char)로 형변환
			int data = fis.read( );
			System.out.println("data : " + (char)data);
			data = fis.read( );
			System.out.println("data : " + (char)data);
			data = fis.read( );
			System.out.println("data : " + (char) data);
			
			// 배열로 여러개 한번에 읽기
			byte[] datas = new byte[5];
			fis.read(datas);
			
			System.out.println( (char)datas[0] );
			System.out.println( (char)datas[4] );
			
			for(int arr : datas) {
				System.out.println( (char)arr );
			}
			
		} catch ( FileNotFoundException e ) {
			System.out.println( "에러 : " + e.getMessage() );
		} catch ( IOException e ) {
			System.out.println( "에러 : " + e.getMessage() );
			
			// 반드시 닫아주어야 한다. 안닫으면 깨질 수 도 있음
		}finally {
			if( fis != null ) try { fis.close( ); } catch( IOException e ) { }
		}
	}
}