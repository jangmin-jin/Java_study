package ex01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedFileReaderEx02 {

	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			br = new BufferedReader (new FileReader("./gugudan.txt") );  
			
			String data = null;
			
			// 1줄씩 읽는 방법
			while( (data = br.readLine() ) != null) {
				System.out.println( data );
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