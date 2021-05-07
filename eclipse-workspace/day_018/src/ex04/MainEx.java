package ex04;

public class MainEx {

	public static void main(String[ ] args) {
		// abstract 라 안됨
		// Parent p = new Parent( ) ;
		
		Parent p1 = new Child1( );
		p1.methodB( );
		
		Parent p2 = new Child2( );
		p2.methodB( );
		
		// p1dl Object를 통해 만들어진 인스턴스니 ?
		System.out.println( p1 instanceof Object );
		// p1이 Child1을 통해 만들어진 인스턴스니 ?
		System.out.println( p1 instanceof Child1 );
		// p1이 Parent를 통해 만들어진 인스턴스니 ?
		System.out.println( p1 instanceof Parent );
		// p1이 Child2를 통해 만들어진 인스턴스니 ?
		System.out.println( p1 instanceof Child2 );
	}
}