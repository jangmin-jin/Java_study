package ex04;

public class MainEx01 {

	public static void main(String[] args) {
		
		// abstract 하지 않으면 하기와 같이 받아야 한다
		Child1 c1 = new Child1( );
		Child2 c2 = new Child2( );
		Child3 c3 = new Child3( );
		c1.sal1( );
		c2.salary( );
		c3.sala( );
		
		c1.sal();
		c2.sal();
		c3.sal();
	}
}