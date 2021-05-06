package ex07;

public class MainEx {

	public static void main(String[] args) {
		Child c = new Child( );
		
		c.methodA( );
		c.methodB( );
		
		// static void method라서 이렇게 호출
		MyInterface1.methodC();
	}
}