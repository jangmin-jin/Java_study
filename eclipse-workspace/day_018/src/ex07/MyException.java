package ex07;

// 사용자 정의 Exception 생성
public class MyException extends Exception {
	public MyException( ) {
		super( );
	}
	
	public MyException( String message ) {
		super( message );
	}
}