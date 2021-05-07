package ex09;

import java.io.File;

public class FileEx01 {

	public static void main(String[] args) {
		
		// 파일(디렉토리) => File 객체 생성
		// **경로( 절대경로( 드라이브명 ) / 상대경로( 현재 파일부터 ) )
		// 존재하지 않는 파일로도 File 객체 생성 가능
		
		// windows, linux
		File f1 = new File( "c:\\java\\" );
		// linux
		File f2 = new File( "c:/java/" );
		
		// 파일도 지정 가능
		File f3 = new File("c:\\java\\test.txt");
		
		// 존재유무 ( 경로검증 )
		System.out.println( f1.exists( ) );
		System.out.println( f2.exists( ) );
		System.out.println( f3.exists( ) );
		
		// 파일이나 디렉토리 구분
		System.out.println( f1.isDirectory( ) );
		System.out.println( f3.isFile( ) );
	}
}