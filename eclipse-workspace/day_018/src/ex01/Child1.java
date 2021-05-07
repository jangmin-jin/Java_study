package ex01;

public class Child1 extends Parent {

	// annotation - compiler 알려주는 기능
	@Override
	public void methodB( ) {
		System.out.println( "Child1 methodB( ) 호출" );
	}
}