package ex01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamEx02 {

	public static void main(String[] args) {
		ObjectOutputStream oos = null;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream( "./serial.dat" ));
			
			Person p = new Person("홍길동", "010-1111-1111", 30, "서울시");
			
			// 객체 직렬화 해야지 파일안에 쓰기가 가능함
			oos.writeObject(p);
			
			System.out.println( "출력 성공" );
		} catch (FileNotFoundException e) {
			System.out.println( "에러 : " + e.getMessage() );
		} catch (IOException e) {
			// System.out.println( "에러 : " + e.getMessage() );
			// 전체 에러를 보려면 하기와같이 입력
			e.printStackTrace();
		} finally {
			if( oos != null ) try { oos.close(); } catch(IOException e) {}
		}
	}
}