package ex03;

public class Child1 extends Parent {
	public void methodC( ) {
		System.out.println( "methodC( ) 호출" );
	}
	@Override
	void methodB( ) {
		System.out.println( "Child1 methodB( ) 호출" );
	}
}