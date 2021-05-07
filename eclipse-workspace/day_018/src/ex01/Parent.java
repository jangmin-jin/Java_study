package ex01;

// 만들때 설정하면 자동으로 추상 클래스화 된다.
public abstract class Parent {
	
	// 일반 메서드
	public void methodA( ) {
		System.out.println( "methodA( ) 호출" );
	}
	
	// 추상 메서드
	public abstract void methodB( );
}