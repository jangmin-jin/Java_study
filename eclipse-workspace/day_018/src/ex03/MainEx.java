package ex03;

public class MainEx {

	public static void main(String[ ] args) {
		Child1 c1 = new Child1( );
		
		// 상속
		c1.methodA( );
		c1.methodC( );
		c1.methodB( );  // overriding
		
		// 형변환
		Parent p1 = new Child1( );
		
		p1.methodA( );
		p1.methodB( );  // overriding
		
		// 17번 줄과 23번줄은 다형 관계
		p1 = new Child2( );
		
		p1.methodA( );
		p1.methodB( );  // overriding
	}
}