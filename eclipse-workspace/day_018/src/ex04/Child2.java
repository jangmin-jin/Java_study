package ex04;

public class Child2 extends Parent {
	public void methodC( ) {
		System.out.println( "methodC( ) 호출" );
	}
	@Override
	void methodB( ) {
		System.out.println( "Child2 methodB( ) 호출" );
	}
}