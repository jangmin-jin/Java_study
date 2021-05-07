package ex09;

import java.io.File;

public class FileEx04 {

	public static void main(String[] args) {
		File f = new File( "c:/java/dir1" );
		
		// 디렉토리 생성
		if ( f.mkdir( ) ) {
			System.out.println( "성공" );
		}else {
			System.out.println( "실패" );
		}
		
		// 디렉토리 삭제
		if( f.delete( ) ){
			System.out.println( "성공" );
		}else {
			System.out.println( "실패" );
		}
		
		// renameTo 로 이름 바꾸기
		File f2 = new File("c:/java/dir2");
		
		if( f.renameTo(f2) ) {
			System.out.println( "성공" );
		}else {
			System.out.println( "실패" );
		}
	}
}