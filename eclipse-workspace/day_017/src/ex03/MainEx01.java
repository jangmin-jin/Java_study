package ex03;

public class MainEx01 {

	public static void main(String[] args) {
		Parent1 p1 = new Parent1( );
		Child1 c1 = new Child1( );
		
		// 추상 클래스는 직접 인스턴스화를 못시킨다
		// 객체변수로 못씀 - 불완전 클래스, 자식을 통해서 완성되는 클래스
		// Parent2 p2 = new Parent2( );
		// Child2 c2 = new Child2();
		// c2.viewParent2( );
		
		GrandChild2 gc2 = new GrandChild2( );
		gc2.viewParent2( );
	}
}