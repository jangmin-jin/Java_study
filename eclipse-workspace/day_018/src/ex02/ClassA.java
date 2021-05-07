package ex02;

public class ClassA implements InterB, InterC {

	public static void main(String[] args) {

	}

	@Override
	public void methodA() {
		System.out.println( "methodA ( )호출" );
	}

	@Override
	public void methodC() {
		System.out.println( "methodC ( )호출" );
	}

	@Override
	public void methodB() {
		System.out.println( "methodB ( )호출" );
	}
}