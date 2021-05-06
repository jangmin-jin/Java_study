package ex05;

public class ClassA implements InterA, InterB {

	@Override
	public void methodA() {
		System.out.println( "methodA( ) 호출" );
	}

	@Override
	public void methodB() {
		System.out.println( "methodB( ) 호출" );
	}

	@Override
	public void methodC() {
		System.out.println( "methodC( ) 호출" );
	}

	@Override
	public void methodD() {
		System.out.println( "methodD( ) 호출" );
	}
}