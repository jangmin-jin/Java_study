package ex01;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileEx01 {

	public static void main(String[] args) {
		// RandomAccess
		RandomAccessFile raf = null;
		
		try {
			// rw : read, write
			// 읽기 위치 : 파일 포인터
			raf = new RandomAccessFile("./score.dat", "rw");
			
			int[] scores = {
					1, 100, 90, 90,
					2, 70, 90, 100,
					3, 100, 100, 100,
					4, 70, 60, 80,
					5, 70, 90, 100
			};
			
			// scores의 파일 포인터 확인
			for( int i=0; i<scores.length; i++) {
				raf.writeInt(scores[i]);
				System.out.println( raf.getFilePointer() );
			}
			System.out.println( "출력 성공" );
			
			// 위치 바꾸기 : seek
			// 0 byte째 부터 읽는다.
			raf.seek(0);
			
			while(true) {
				System.out.println( raf.readInt() );
			}
			
		} catch (FileNotFoundException e) {
			System.out.println( "에러 : " + e.getMessage() );
		} catch (IOException e) {
			System.out.println( "에러 : " + e.getMessage() );
		} finally {
			if( raf != null ) try { raf.close(); } catch(IOException e) {}
		}
	}
}