package ex03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchZipcodeEx01 {

	public static void main(String[] args) {
		BufferedReader br = null;
		
		Scanner scanDong = new Scanner(System.in);
		System.out.print(" 동을 입력하세요 : ");
		String inputDong = scanDong.next( );
		
		String checkDong[] = inputDong.split("");
		if( checkDong.length <2 ) {
			System.out.println( "두글자 이상을 입력하세요" );
			scanDong.close();
			return;
		}else {
			scanDong.close();
		}
		
		try {
			br = new BufferedReader(new FileReader("./zipcode_seoul_utf8_type2.csv"));
			String data = null;
			int count = 0;
			
			while ( (data =br.readLine() ) != null) {
				String arr[] = data.split( "," ) ;
				if ( arr[3].contains(inputDong) ) {
					System.out.println( data );
					count++;
				}
			}
			if ( count == 0 ) {
				System.out.println("일치하는 결과가 없습니다.");
				return;
			}
			count = 0;
			scanDong.close();
		} catch (FileNotFoundException e) {
			System.out.println( "에러 : " + e.getMessage() );
		} catch (IOException e) {
			System.out.println( "에러 : " + e.getMessage() );
		} finally {
			if ( br != null ) try { br.close(); } catch(IOException e) {}
		}
	}
}