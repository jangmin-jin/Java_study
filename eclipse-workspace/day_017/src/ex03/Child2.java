package ex03;

public abstract class Child2 extends Parent2 {
	public Child2( ) {
		// TODO Auto-generated constructor stub
		System.out.println( "Child2( ) 호출" );
	}
	
	// abstract 추상 메서드 선언시 오버라이드 해야함
	@Override
	public void viewParent2( ) {
		System.out.println( "viewParent2( ) 호출" );
	}
}