package ex01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedFileReaderEx01 {

	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			br = new BufferedReader (new FileReader("./newtest.txt") );  
			
			int data = 0;
			
			// 1글자씩 읽는 방법
			while( (data = br.read() ) != -1) {
				System.out.print( (char)data );
			}
		} catch (FileNotFoundException e) {
			System.out.println( "에러 : " + e.getMessage() );
		} catch (IOException e) {
			System.out.println( "에러 : " + e.getMessage() );
		}finally {
			if(br!=null) try { br.close();} catch (IOException e) {}
		}
	}
}