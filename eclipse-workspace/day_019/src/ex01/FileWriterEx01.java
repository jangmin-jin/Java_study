package ex01;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEx01 {

	public static void main(String[] args) {
		FileWriter fw = null;
		
		try {
			// overwriting (덮어쓰기)
			fw = new FileWriter("./newtest.txt");
			// true 넣으면 append (추가작성) 가 된다.
			// fw = new FileWriter("./newtest.txt", true);
			fw.write("FileWriter는 문자열을 \n통째로 넣을 수 있다");
			
			System.out.println( "출력 완료" );
		} catch (IOException e) {
			System.out.println( "에러 : " + e.getMessage() );
		}finally {
			if ( fw != null) try { fw.close(); } catch (IOException e) { }
		}
	}
}