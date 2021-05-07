package ex09;

import java.io.File;
import java.util.Arrays;
import java.util.Date;

public class FileEx03 {

	public static void main(String[] args) {
		File f1 = new File( "c://java//test.txt" );
		
		// 파일 속성 검증
		System.out.println( f1.canExecute( ) );
		System.out.println( f1.canRead( ) );
		System.out.println( f1.canWrite( ) );
		System.out.println( f1.isHidden( ));
		
		File f2 = new File( "C:\\java\\eclipse\\eclipse.exe" );
		long fileSize = f2.length( );
		// byte단위로 크기를 알 수 있다.
		System.out.println( fileSize / 1024 ); // KB변환
		
		// 파일의 타임 스탬프도 뜯어올 수 있다.
		long fileDate = f2.lastModified( );
		System.out.println( fileDate );
		System.out.println( new Date(fileDate).toLocaleString( ) );
		
		File f3 = new File( "c:/java" );
		// String / File
		String[] lists = f3.list( );
		
		// 출력문
		System.out.println( Arrays.toString(lists) );
		for(String list : lists) {
			System.out.println( list );
		}
		
		// 출력문2
		File[] fileLists = f3.listFiles( );
		for(File fileList : fileLists) {
			System.out.println( fileList.getName( ) );
		}
	}
}