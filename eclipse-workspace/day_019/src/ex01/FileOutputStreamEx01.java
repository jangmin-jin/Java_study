package ex01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamEx01 {

	public static void main(String[] args) {
		FileOutputStream fos = null;
		try {
			// 파일 생성
			// 절대 경로
			// fos = new FileOutputStream("c:/java/newtest.txt");
			
			// 상대 경로 : 현재 디렉토리 (class 디렉토리)
			fos = new FileOutputStream("./newtest.txt");
			
			// 파일에 쓰기 : 단위 char
			// overwriting - 지웠다가 다시 쓰기
			fos.write('1');
			fos.write('2');
			
			fos.write('\n');
			// fos.write('\r');
			
			fos.write('a');
			fos.write('b');
			
		} catch (FileNotFoundException e) {
			System.out.println( "에러 : " + e.getMessage() );
		}catch(IOException e) {
			System.out.println( "에러 : " + e.getMessage() );
		}finally {
			if(fos != null) try { fos.close(); } catch (IOException e) { }
		}
	}
}