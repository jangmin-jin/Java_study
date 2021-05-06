package ex07;

public interface MyInterface1 {
	void methodA ( );
	
	// JDK 8 부터 추가된 기능 (많이 쓰는 형태는 아님)
	default void methodB( ) {
		System.out.println( "methodB( ) 호출" );
	}
	static void methodC( ) {
		System.out.println( "methodC( ) 호출" );
	}
}