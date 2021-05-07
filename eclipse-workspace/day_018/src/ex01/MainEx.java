package ex01;

public class MainEx {

	public static void main(String[] args) {
		// 상속이 안되있으면 아래와 같이 선언 불가
		// Parent p = new Parent( );
		// 오버라이딩 안하면 아래와 같이 선언 불가
		// Child1 c1 = new Child1();
		
		Child1 c1 = new Child1();
		c1.methodA();
		c1.methodB();
		
		Child2 c2 = new Child2();
		c2.methodA();
		c2.methodB();
	}
}