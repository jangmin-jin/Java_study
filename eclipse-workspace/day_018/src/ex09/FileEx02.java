package ex09;

import java.io.File;
import java.io.IOException;

public class FileEx02 {

	public static void main(String[] args) {
		// 절대 경로
		File f1 = new File( "c://java//test.txt" );
		// 상대 경로 : ./ ../
		File f2 = new File( "./text.txt" );
		
		// 파일명 추출
		System.out.println( f1.getName( ) );
		System.out.println( f2.getName( ) );
		
		// 부모 디렉토리 추출
		System.out.println( f1.getParent( ) );
		System.out.println( f2.getParent( ) );
		
		// 경로 추출
		System.out.println( f1.getPath( ) );
		System.out.println( f2.getPath( ) );
		
		// 본래 전체 경로 추출
		try {
			System.out.println( f1.getCanonicalPath( ) );
			System.out.println( f2.getCanonicalPath( ) );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}