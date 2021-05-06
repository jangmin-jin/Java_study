package ex06;

public class ClassA implements InterB {

	@Override
	public void methodA() {
		System.out.println( "methodA() 호출" );
	}

	@Override
	public void methodB() {
		System.out.println( "methodB() 호출" );
	}
}