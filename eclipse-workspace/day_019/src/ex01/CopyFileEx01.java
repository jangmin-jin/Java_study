package ex01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileEx01 {

	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		// 이미지 파일 복사
		try {
			fis = new FileInputStream("./Jellyfish.jpg");
			fos = new FileOutputStream("./newJellyfish.jpg");
			
			int data = 0;
			// 파일 내용 복사
			while( (data = fis.read()) != -1 ) {
				fos.write(data);
			}
			System.out.println( "복사 완료" );
		} catch (FileNotFoundException e) {
			System.out.println( "에러 : " + e.getMessage() );
		} catch (IOException e) {
			System.out.println( "에러 : " + e.getMessage() );
		} finally{ 
			if ( fis != null) try { fis.close(); } catch (IOException e) {}
			if ( fos != null) try { fos.close(); } catch (IOException e) {}
		}
	}
}