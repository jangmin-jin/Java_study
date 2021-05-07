package ex05;

public class MainEx {

	public static void main(String[] args) {
		
		// 인터페이스는 직접 인스턴스화 X
		// InterA a = new InterA();
		
		InterA a = new Child1();
		a.methodA( );
		
		a = new Child2();
		a.methodA( );
	}
}