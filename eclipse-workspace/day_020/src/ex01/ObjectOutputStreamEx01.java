package ex01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamEx01 {

	public static void main(String[] args) {
		// 내장 class 저장 => 사용자정의 class 저장
		// ObjectOutputStream을 이용한 파일 쓰기
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream( new FileOutputStream("./value1.dat") );
			
			String[] names = { "홍길동", "박문수", "이몽룡" };
			int[] ages = { 10, 20, 30 };
			double[] weights = { 71.4, 67.9, 58.5 };
			
			oos.writeObject(names);
			oos.writeObject(ages);
			oos.writeObject(weights);
			
			System.out.println( "출력 성공" );
		} catch (FileNotFoundException e) {
			System.out.println( "에러 : " + e.getMessage() );
		} catch (IOException e) {
			System.out.println( "에러 : " + e.getMessage() );
		} finally {
			if( oos != null ) try { oos.close(); } catch(IOException e) {}
		}
	}
}