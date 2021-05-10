package ex01;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedFileWriterEx01 {

	public static void main(String[] args) {
		BufferedWriter bw = null;
		
		try {

			bw =new BufferedWriter( new FileWriter("./newtest.txt") );
			bw.write("123\r\n");
			bw.write("abc\r\n");
			bw.write("123\r\n");
			bw.write("FileWriter는 문자열을 \n통째로 넣을 수 있다");
			
			System.out.println( "출력 완료" );
		} catch (IOException e) {
			System.out.println( "에러 : " + e.getMessage() );
		}finally {
			if ( bw != null) try { bw.close(); } catch (IOException e) { }
		}
	}
}