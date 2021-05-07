package ex09;

import java.io.File;
import java.io.IOException;

public class FileEx05 {

	public static void main(String[] args) {
		File f = new File( "c:/java/text.txt" );
		try {
			f.createNewFile( );
			System.out.println( "성공" );
		} catch (IOException e) {
			System.out.println( "에러 : " + e.getMessage( ) );
		}
	}
}