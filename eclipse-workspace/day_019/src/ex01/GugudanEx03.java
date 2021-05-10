package ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GugudanEx03 {

	public static void main(String[] args) {
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			br = new BufferedReader(new FileReader("./gugudan.txt"));
			bw = new BufferedWriter(new FileWriter("./newgugudan.txt"));
			
			// 한글자씩 읽어서 쓰기
			int data = 0;
			while( (data = br.read() ) != -1) {
				bw.write(data);
			}
			
			// String으로 한줄씩 읽어서 쓰기
			String data2 = null;
			while( (data2 = br.readLine() ) != null ) {
				bw.write(data2 + "\r\n");
			}
			
			System.out.println( "복사 완료" );
		} catch (FileNotFoundException e) {
			System.out.println( "에러 : " + e.getMessage() );
		} catch (IOException e) {
			System.out.println( "에러 : " + e.getMessage() );		
		}finally {
			if(br!=null) try { br.close();} catch (IOException e) {}
			if(bw!=null) try { bw.close();} catch (IOException e) {}
		}
	}
}